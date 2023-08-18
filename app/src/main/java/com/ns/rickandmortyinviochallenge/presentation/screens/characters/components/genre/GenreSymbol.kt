package com.ns.rickandmortyinviochallenge.presentation.screens.characters.components.genre

import androidx.compose.runtime.Composable
import com.ns.rickandmortyinviochallenge.R
import com.ns.rickandmortyinviochallenge.domain.model.Character

@Composable
fun GenreSymbol(
    character: Character
) {
    when (character.gender) {
        Genres.Male.name ->
            GenreSymbolImage(
                painter = R.drawable.male_symbol,
                contentDescription = "Male Symbol"
            )

        Genres.Female.name ->
            GenreSymbolImage(
                painter = R.drawable.female_symbol,
                contentDescription = "Female Symbol"
            )

        Genres.Genderless.name ->
            GenreSymbolImage(
                painter = R.drawable.question_symbol,
                contentDescription = "Genderless Symbol"
            )

        Genres.Unknown.name.lowercase() ->
            GenreSymbolImage(
                painter = R.drawable.question_symbol,
                contentDescription = "Unknown Symbol"
            )
    }
}


