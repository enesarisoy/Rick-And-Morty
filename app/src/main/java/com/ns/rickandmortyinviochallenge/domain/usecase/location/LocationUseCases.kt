package com.ns.rickandmortyinviochallenge.domain.usecase.location

import javax.inject.Inject

data class LocationUseCases @Inject constructor(
    val getAllLocationsUseCase: GetAllLocationsUseCase,
    val getMultipleLocationsUseCase: GetMultipleLocationsUseCase,
    val getSingleLocationUseCase: GetSingleLocationUseCase
)
