package com.ns.rickandmortyinviochallenge.di

import com.ns.rickandmortyinviochallenge.data.remote.RickAndMortyService
import com.ns.rickandmortyinviochallenge.data.repository.RickAndMortyRepositoryImpl
import com.ns.rickandmortyinviochallenge.domain.repository.RickAndMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRickAndMortyRepository(rickAndMortyService: RickAndMortyService): RickAndMortyRepository =
        RickAndMortyRepositoryImpl(rickAndMortyService)
}