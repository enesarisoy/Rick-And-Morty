package com.ns.rickandmortyinviochallenge.di

import com.ns.rickandmortyinviochallenge.core.util.Constants.BASE_URL
import com.ns.rickandmortyinviochallenge.data.remote.RickAndMortyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRickAndMortyService(): RickAndMortyService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyService::class.java)
    }
}