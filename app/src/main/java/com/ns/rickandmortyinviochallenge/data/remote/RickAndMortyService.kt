package com.ns.rickandmortyinviochallenge.data.remote

import com.ns.rickandmortyinviochallenge.data.dto.ApiResponse
import com.ns.rickandmortyinviochallenge.data.dto.character.CharacterDto
import com.ns.rickandmortyinviochallenge.data.dto.location.LocationDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): ApiResponse<CharacterDto>

    @GET("character/{id}")
    suspend fun getSingleCharacter(
        @Path("id") id: Int
    ): CharacterDto

    @GET("character/{ids}")
    suspend fun getMultipleCharacters(
        @Path("ids") ids: String
    ): List<CharacterDto>

    @GET("location")
    suspend fun getAllLocations(
        @Query("page") page: Int
    ): ApiResponse<LocationDto>

    @GET("location/{id}")
    suspend fun getSingleLocation(
        @Path("id") id: Int
    ): LocationDto

    @GET("location/{ids}")
    suspend fun getMultipleLocations(
        @Path("ids") ids: String
    ): List<LocationDto>
}