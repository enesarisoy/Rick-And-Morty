package com.ns.rickandmortyinviochallenge.presentation.screens.characters

import com.ns.rickandmortyinviochallenge.domain.model.Location

data class LocationState(
    val page: Int = 1,
    val isLoading: Boolean = false,
    val items: List<Location> = emptyList(),
    val endReached: Boolean = false,
    val error: String? = null,
    val isFirstTime: Boolean = true
)