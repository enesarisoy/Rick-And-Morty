package com.ns.rickandmortyinviochallenge.data.dto

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("info")
    val pageInfo: ApiInfo,
    val results: List<T>
)

data class ApiInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)