package com.ns.rickandmortyinviochallenge.data.dto.location

import java.util.Date

data class LocationDto(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: Date
)
