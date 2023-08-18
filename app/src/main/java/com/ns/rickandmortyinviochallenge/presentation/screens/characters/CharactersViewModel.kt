package com.ns.rickandmortyinviochallenge.presentation.screens.characters

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ns.rickandmortyinviochallenge.core.pagination.DefaultPaginator
import com.ns.rickandmortyinviochallenge.core.util.getNumbersInList
import com.ns.rickandmortyinviochallenge.domain.usecase.character.CharacterUseCases
import com.ns.rickandmortyinviochallenge.domain.usecase.location.LocationUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersUseCase: CharacterUseCases,
    private val locationUseCase: LocationUseCases
) : ViewModel() {

    var charactersState by mutableStateOf(CharactersState())
    var locationState by mutableStateOf(LocationState())

    private val characterListPaginator = DefaultPaginator(
        initialKey = charactersState.page,
        onLoadUpdated = {
            charactersState = charactersState.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            if (charactersState.isMultiple) {
                charactersState.isLoading = false
                return@DefaultPaginator emptyFlow()
            } else {
                charactersUseCase.getAllCharactersUseCase(nextPage)
            }
        },
        getNextKey = {
            charactersState.page + 1
        },
        onError = {
            charactersState = charactersState.copy(error = it)
        },
        onSuccess = { items, newPage ->
            charactersState = charactersState.copy(
                page = newPage,
                endReached = items.isEmpty(),
                items = if (charactersState.isMultiple) charactersState.items else charactersState.items + items,
                isEmpty = false
            )
        }
    )

    private val locationListPaginator = DefaultPaginator(
        initialKey = locationState.page,
        onLoadUpdated = {
            locationState = locationState.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            locationUseCase.getAllLocationsUseCase(nextPage)
        },
        getNextKey = {
            locationState.page + 1
        },
        onError = {
            locationState = locationState.copy(error = it)
        },
        onSuccess = { items, nextPage ->
            locationState = locationState.copy(
                page = nextPage,
                endReached = items.isEmpty(),
                items = locationState.items + items,
                isFirstTime = false
            )
        }
    )

    init {
        loadNextCharacters()
        loadNextLocations()
    }

    fun loadNextCharacters() = viewModelScope.launch {
        characterListPaginator.loadNextItems()
    }

    fun loadNextLocations() = viewModelScope.launch {
        locationListPaginator.loadNextItems()
    }

    fun getCharactersByLocation(id: Int) {
        viewModelScope.launch {
            try {
                locationState = locationState.copy(isLoading = true)
                val location = locationUseCase.getSingleLocationUseCase(id)

                val residents = location.residents.getNumbersInList(",")
                if (residents.isEmpty()) {
                    charactersState = charactersState.copy(items = emptyList(), isEmpty = true)
                } else {
                    charactersState = charactersState.copy(
                        isEmpty = false,
                        items = if (!residents.contains(",")) listOf(
                            charactersUseCase.getSingleCharacterUseCase(
                                residents.toInt()
                            )
                        ) else {
                            charactersUseCase.getMultipleCharactersUseCase(residents)
                        }
                    )
                }

            } catch (e: Exception) {
                locationState = locationState.copy(error = e.message)
            }
        }
    }

    fun resetPaginator() {
        characterListPaginator.reset()
        charactersState = charactersState.copy(items = emptyList(), isMultiple = false)
        loadNextCharacters()
    }
}
