package com.ns.rickandmortyinviochallenge.domain.usecase.character

import com.ns.rickandmortyinviochallenge.core.util.Resource
import com.ns.rickandmortyinviochallenge.domain.model.Character
import com.ns.rickandmortyinviochallenge.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
){

    suspend operator fun invoke(page: Int): Flow<Resource<List<Character>>> =
        repository.getAllCharacters(page)
}