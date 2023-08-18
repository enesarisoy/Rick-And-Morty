package com.ns.rickandmortyinviochallenge.core.util

sealed class Resource<out T : Any> {
    object Loading : Resource<Nothing>()
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Error(val error: String) : Resource<Nothing>()
}