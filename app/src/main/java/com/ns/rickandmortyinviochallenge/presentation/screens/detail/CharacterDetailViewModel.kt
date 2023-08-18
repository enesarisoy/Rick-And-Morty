package com.ns.rickandmortyinviochallenge.presentation.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ns.rickandmortyinviochallenge.domain.usecase.character.GetSingleCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getSingleCharacterUseCase: GetSingleCharacterUseCase
) : ViewModel() {

    var characterState by mutableStateOf(CharacterDetailState())

    fun getCharacter(id: Int) {
        viewModelScope.launch {
            try {
                characterState = characterState.copy(isLoading = true)

                val character = getSingleCharacterUseCase(id)
                characterState = characterState.copy(item = character)
            } catch (e: Exception) {
                characterState = characterState.copy(error = e.message)
            }
        }
    }
}