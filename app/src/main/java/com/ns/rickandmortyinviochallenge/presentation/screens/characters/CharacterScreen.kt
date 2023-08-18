package com.ns.rickandmortyinviochallenge.presentation.screens.characters

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ns.rickandmortyinviochallenge.presentation.screens.characters.components.CharacterList
import com.ns.rickandmortyinviochallenge.presentation.screens.characters.components.genre.GenreSymbol
import com.ns.rickandmortyinviochallenge.presentation.screens.characters.components.bar.RickAndMortyToolbar
import com.ns.rickandmortyinviochallenge.presentation.screens.characters.components.chips.LocationChips
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CharacterScreen(
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel()
) {

    Column {

        RickAndMortyToolbar()
        LocationChips(viewModel = viewModel)

        CharacterList(navController = navController)
        /*LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            items(viewModel.charactersState.items) { character ->
                val state = viewModel.charactersState
                if (character == state.items.last() && !state.endReached && !state.isLoading) {
                    viewModel.loadNextCharacters()
                }

                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .border(
                                width = 1.dp,
                                color = Color.Black,
                                shape = RectangleShape
                            )
                            .clickable {
                                navController.navigate("detail/${character.id}")
                            },
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        GlideImage(
                            imageModel = character.image,
                            modifier = Modifier
                                .size(120.dp)
                        )

                        GenreSymbol(character = character)
                        Text(
                            text = character.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(
                                end = 8.dp,
                            ),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                    }
                }
            }

            item {
                if (viewModel.charactersState.isLoading) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }
        }*/
    }
}