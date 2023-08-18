package com.ns.rickandmortyinviochallenge.domain.usecase.character

import javax.inject.Inject

data class CharacterUseCases @Inject constructor(
    val getAllCharactersUseCase: GetAllCharactersUseCase,
    val getMultipleCharactersUseCase: GetMultipleCharactersUseCase,
    val getSingleCharacterUseCase: GetSingleCharacterUseCase
)
