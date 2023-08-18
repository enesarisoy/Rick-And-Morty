package com.ns.rickandmortyinviochallenge.domain.repository

import com.ns.rickandmortyinviochallenge.core.util.Resource
import com.ns.rickandmortyinviochallenge.domain.model.Character
import com.ns.rickandmortyinviochallenge.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    suspend fun getAllCharacters(page: Int): Flow<Resource<List<Character>>>

    suspend fun getSingleCharacter(id: Int): Character

    suspend fun getMultipleCharacters(ids: String): List<Character>

    suspend fun getAllLocations(page: Int): Flow<Resource<List<Location>>>

    suspend fun getSingleLocation(id: Int): Location

    suspend fun getMultipleLocations(ids: String): List<Location>
}