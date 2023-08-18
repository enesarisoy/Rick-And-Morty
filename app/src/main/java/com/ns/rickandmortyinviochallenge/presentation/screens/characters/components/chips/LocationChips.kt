package com.ns.rickandmortyinviochallenge.presentation.screens.characters.components.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ns.rickandmortyinviochallenge.presentation.screens.characters.CharactersViewModel

@Composable
fun LocationChips(
    viewModel: CharactersViewModel
) {

    val chips = viewModel.locationState.items
    var chipState by rememberSaveable {
        mutableStateOf("")
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(chips) { location ->
            val state = viewModel.locationState
            if (location == state.items.last() && !state.endReached && !state.isLoading) {
                viewModel.loadNextLocations()
            }

            SuggestionChips(
                label = location.name,
                selected = location.name == chipState,
                location = location,
                viewModel = viewModel
            ) { chip ->
                chipState = chip
            }
        }
        if (!viewModel.locationState.isFirstTime) {

            item {
                if (viewModel.locationState.isLoading) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        CircularProgressIndicator(modifier = Modifier.size(25.dp))
                    }
                }
            }
        }
    }
}

