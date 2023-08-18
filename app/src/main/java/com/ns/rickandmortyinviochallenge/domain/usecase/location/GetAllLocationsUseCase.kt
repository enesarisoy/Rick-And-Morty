package com.ns.rickandmortyinviochallenge.domain.usecase.location

import com.ns.rickandmortyinviochallenge.core.util.Resource
import com.ns.rickandmortyinviochallenge.domain.model.Location
import com.ns.rickandmortyinviochallenge.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllLocationsUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
){

    suspend operator fun invoke(page: Int): Flow<Resource<List<Location>>> =
        repository.getAllLocations(page)
}