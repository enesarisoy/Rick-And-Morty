package com.ns.rickandmortyinviochallenge.domain.model

import java.util.Date

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: Date
)