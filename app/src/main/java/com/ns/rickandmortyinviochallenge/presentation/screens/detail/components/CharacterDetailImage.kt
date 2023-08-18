package com.ns.rickandmortyinviochallenge.presentation.screens.detail.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ns.rickandmortyinviochallenge.domain.model.Character
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterDetailImage(
    character: Character
) {
    GlideImage(
        imageModel = character.image,
        modifier = Modifier
            .size(275.dp)
            .padding(horizontal = 20.dp, vertical = 20.dp)
        // Attention pls!! Horizontal 50 dp olunca resim çok küçük görünüyordu
        // ben de kendime göre ayarladım
    )
}