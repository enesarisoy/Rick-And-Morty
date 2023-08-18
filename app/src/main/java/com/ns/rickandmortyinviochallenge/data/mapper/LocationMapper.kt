package com.ns.rickandmortyinviochallenge.data.mapper

import com.ns.rickandmortyinviochallenge.data.dto.location.LocationDto
import com.ns.rickandmortyinviochallenge.domain.model.Location

fun LocationDto.toLocation(): Location = Location(
    id = id,
    name = name,
    type = type,
    dimension = dimension,
    residents = residents,
    url = url,
    created = created
)