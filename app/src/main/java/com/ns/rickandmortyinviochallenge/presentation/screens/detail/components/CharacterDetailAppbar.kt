package com.ns.rickandmortyinviochallenge.presentation.screens.detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ns.rickandmortyinviochallenge.presentation.screens.detail.CharacterDetailViewModel

@Composable
fun CharacterDetailAppBar(
    navController: NavController,
    viewModel: CharacterDetailViewModel
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {

        Box(modifier = Modifier.fillMaxWidth()){
            IconButton(
                onClick = {
                    navController.navigateUp()
                }
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
            viewModel.characterState.item?.let {
                Text(
                    text = it.name,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}