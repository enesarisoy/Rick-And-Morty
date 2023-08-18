package com.ns.rickandmortyinviochallenge.data.mapper

import com.ns.rickandmortyinviochallenge.data.dto.character.CharacterDto
import com.ns.rickandmortyinviochallenge.domain.model.Character

fun CharacterDto.toCharacter(): Character = Character(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = origin,
    location = location,
    image = image,
    episode = episode,
    url = url,
    created = created
)