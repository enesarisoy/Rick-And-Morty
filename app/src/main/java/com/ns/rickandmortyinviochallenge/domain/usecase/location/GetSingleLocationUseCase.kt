package com.ns.rickandmortyinviochallenge.domain.usecase.location

import com.ns.rickandmortyinviochallenge.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetSingleLocationUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
){
    suspend operator fun invoke(id: Int) = repository.getSingleLocation(id)
}