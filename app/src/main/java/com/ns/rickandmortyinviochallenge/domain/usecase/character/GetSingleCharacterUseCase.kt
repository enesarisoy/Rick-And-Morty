package com.ns.rickandmortyinviochallenge.domain.usecase.character

import com.ns.rickandmortyinviochallenge.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetSingleCharacterUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
){
    suspend operator fun invoke(id: Int) = repository.getSingleCharacter(id)
}