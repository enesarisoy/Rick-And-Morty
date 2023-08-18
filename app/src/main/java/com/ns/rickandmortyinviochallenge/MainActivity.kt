package com.ns.rickandmortyinviochallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ns.rickandmortyinviochallenge.presentation.screens.characters.CharacterScreen
import com.ns.rickandmortyinviochallenge.presentation.screens.characters.CharactersViewModel
import com.ns.rickandmortyinviochallenge.presentation.screens.characters.components.chips.LocationChips
import com.ns.rickandmortyinviochallenge.presentation.screens.detail.CharacterDetailScreen
import com.ns.rickandmortyinviochallenge.presentation.screens.splash.SplashScreen
import com.ns.rickandmortyinviochallenge.ui.theme.RickAndMortyInvioChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CharactersViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyInvioChallengeTheme {
                Surface {
                    Column {
                        NavigationView()
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController = navController)
        }
        composable("home") {
            CharacterScreen(navController = navController)
        }
        composable(
            "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {
            val id = it.arguments?.getString("id")
            id?.let {idd ->
                CharacterDetailScreen(navController = navController, characterId = idd.toInt())
            }
        }
    }
}
