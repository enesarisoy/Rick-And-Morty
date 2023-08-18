package com.ns.rickandmortyinviochallenge.presentation.screens.detail

import com.ns.rickandmortyinviochallenge.domain.model.Character

data class CharacterDetailState(
    val item: Character? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)