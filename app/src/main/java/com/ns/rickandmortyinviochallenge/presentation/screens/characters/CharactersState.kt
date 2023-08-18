package com.ns.rickandmortyinviochallenge.presentation.screens.characters

import com.ns.rickandmortyinviochallenge.domain.model.Character

data class CharactersState(
    val page: Int = 1,
    var isLoading: Boolean = false,
    val items: List<Character> = emptyList(),
    val endReached: Boolean = false,
    val error: String? = null,
    var isMultiple: Boolean = false,
    var isEmpty: Boolean = false
)