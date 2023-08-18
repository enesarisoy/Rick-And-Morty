package com.ns.rickandmortyinviochallenge.presentation.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ns.rickandmortyinviochallenge.core.util.getNumbersInList
import com.ns.rickandmortyinviochallenge.presentation.screens.detail.components.CharacterDetailAppBar
import com.ns.rickandmortyinviochallenge.presentation.screens.detail.components.CharacterDetailImage
import com.ns.rickandmortyinviochallenge.presentation.screens.detail.components.DetailRowList

@Composable
fun CharacterDetailScreen(
    navController: NavController,
    characterId: Int,
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {
    viewModel.getCharacter(characterId)

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            CharacterDetailAppBar(navController = navController, viewModel = viewModel)

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                val state = viewModel.characterState
                state.item?.let { character ->

                    CharacterDetailImage(character = character)

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        DetailRowList(title = "Status:", detail = character.status)
                        DetailRowList(title = "Specy:", detail = character.species)
                        DetailRowList(title = "Gender:", detail = character.gender)
                        DetailRowList(title = "Location:", detail = character.origin.name)
                        DetailRowList(title = "Origin:", detail = character.location.name)
                        DetailRowList(
                            title = "Episodes:", detail = character.episode.getNumbersInList(", ")
                        )
                        DetailRowList(title = "Created at\n(in API):", detail = character.created.toString())
                    }
                }
            }
        }
    }
}

