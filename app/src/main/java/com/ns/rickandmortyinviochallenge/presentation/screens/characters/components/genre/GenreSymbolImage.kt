package com.ns.rickandmortyinviochallenge.presentation.screens.characters.components.genre

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun GenreSymbolImage(
    @DrawableRes painter: Int,
    contentDescription: String? = null
) {
    Image(
        painter = painterResource(id = painter),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(80.dp)
            .alpha(0.5f)
    )
}
