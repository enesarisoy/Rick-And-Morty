package com.ns.rickandmortyinviochallenge.presentation.screens.characters.components.chips

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ns.rickandmortyinviochallenge.domain.model.Location
import com.ns.rickandmortyinviochallenge.presentation.screens.characters.CharactersViewModel
import com.ns.rickandmortyinviochallenge.ui.theme.ChipColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuggestionChips(
    label: String,
    selected: Boolean,
    location: Location,
    viewModel: CharactersViewModel,
    onChipChange: (String) -> Unit
) {
    SuggestionChip(
        onClick = {

            if (!selected) {
                onChipChange(label)
                viewModel.charactersState.isMultiple = true
                viewModel.getCharactersByLocation(location.id)
                viewModel.loadNextLocations()
            } else {
                onChipChange("")
                viewModel.resetPaginator()
                viewModel.charactersState.isLoading = true
                viewModel.charactersState.isMultiple = false
            }
        },
        label = { Text(text = label) },
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = if (selected) Color.Transparent else ChipColor
        ),
        shape = RoundedCornerShape(8.dp),
        border = SuggestionChipDefaults.suggestionChipBorder(
            borderWidth = 1.dp,
            borderColor = Color.Black
        )
    )
}
