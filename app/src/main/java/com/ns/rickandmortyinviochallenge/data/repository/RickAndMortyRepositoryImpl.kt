package com.ns.rickandmortyinviochallenge.data.repository

import com.ns.rickandmortyinviochallenge.core.util.Resource
import com.ns.rickandmortyinviochallenge.data.mapper.toCharacter
import com.ns.rickandmortyinviochallenge.data.mapper.toLocation
import com.ns.rickandmortyinviochallenge.data.remote.RickAndMortyService
import com.ns.rickandmortyinviochallenge.domain.model.Character
import com.ns.rickandmortyinviochallenge.domain.model.Location
import com.ns.rickandmortyinviochallenge.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val api: RickAndMortyService
) : RickAndMortyRepository {

    override suspend fun getAllCharacters(page: Int): Flow<Resource<List<Character>>> = flow {
        delay(2500L)
        emit(Resource.Loading)
        val data = try {
            api.getAllCharacters(page)
        } catch (e: IOException) {
            emit(Resource.Error(error = e.message.toString()))
            null
        } catch (e: HttpException) {
            emit(Resource.Error(error = e.message.toString()))
            null
        }

        data?.let { incomingData ->
            emit(Resource.Loading)
            emit(Resource.Success(incomingData.results.map { it.toCharacter() }))
        }
    }

    override suspend fun getSingleCharacter(id: Int): Character =
        api.getSingleCharacter(id).toCharacter()

    override suspend fun getMultipleCharacters(ids: String): List<Character> =
        api.getMultipleCharacters(ids).map { it.toCharacter() }

    override suspend fun getAllLocations(page: Int): Flow<Resource<List<Location>>> = flow {
        delay(1000L)
        emit(Resource.Loading)

        val data = try {
            api.getAllLocations(page)
        } catch (e: IOException) {
            emit(Resource.Error(e.message.toString()))
            null
        } catch (e: HttpException) {
            emit(Resource.Error(e.message.toString()))
            null
        }

        data?.let { incomingData ->
            emit(Resource.Loading)
            emit(Resource.Success(incomingData.results.map { it.toLocation() }))
        }
    }

    override suspend fun getSingleLocation(id: Int): Location =
        api.getSingleLocation(id).toLocation()

    override suspend fun getMultipleLocations(ids: String): List<Location> =
        api.getMultipleLocations(ids).map { it.toLocation() }
}