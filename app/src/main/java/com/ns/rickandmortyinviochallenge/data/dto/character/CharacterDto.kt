package com.ns.rickandmortyinviochallenge.data.dto.character

import com.ns.rickandmortyinviochallenge.data.dto.others.NameUrl
import java.util.Date

data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: NameUrl,
    val location: NameUrl,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: Date
)