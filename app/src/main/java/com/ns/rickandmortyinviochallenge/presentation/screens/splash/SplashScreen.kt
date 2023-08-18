package com.ns.rickandmortyinviochallenge.presentation.screens.splash

import android.content.Context
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavController
import com.ns.rickandmortyinviochallenge.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")

@Composable
fun SplashScreen(
    navController: NavController
) {

    val context = LocalContext.current
    val isFirstLaunch = remember { mutableStateOf(true) }
    var textAlpha by remember { mutableStateOf(0f) }
    var startAnimation by remember { mutableStateOf(false) }


    LaunchedEffect(Unit) {
        isFirstLaunch.value =
            context.dataStore.data.first()[booleanPreferencesKey(IS_FIRST_LAUNCH)] ?: true
        if (isFirstLaunch.value) {
            context.dataStore.edit {
                it[booleanPreferencesKey(IS_FIRST_LAUNCH)] = false
            }
        }
    }

    LaunchedEffect(startAnimation) {
        startAnimation = true
        delay(3000L)
        navController.navigate("home"){
            popUpTo("splash"){
                inclusive = true
            }
        }
    }

    val transition = animateFloatAsState(
        targetValue = if (startAnimation) (100).dp.value else 0f,
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearEasing
        )
    )

    LaunchedEffect(Unit) {

        animate(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing,
                delayMillis = 1000
            )
        ) { value, _ -> textAlpha = value }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .graphicsLayer {
                        translationY = transition.value
                    }
                    .padding(horizontal = 30.dp)
                    .width(300.dp)
                    .height(100.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.rick_morty),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .alpha(textAlpha)
            )
            Text(
                text = if (isFirstLaunch.value) stringResource(R.string.welcome)
                else stringResource(R.string.hello),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.Black.copy(alpha = textAlpha),
                modifier = Modifier.alpha(textAlpha)
            )
        }
    }
}

private const val IS_FIRST_LAUNCH = "is_first_launch"
