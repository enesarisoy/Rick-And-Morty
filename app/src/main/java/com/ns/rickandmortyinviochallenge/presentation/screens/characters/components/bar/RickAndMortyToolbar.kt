package com.ns.rickandmortyinviochallenge.presentation.screens.characters.components.bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ns.rickandmortyinviochallenge.R

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun RickAndMortyToolbar() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(50.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
