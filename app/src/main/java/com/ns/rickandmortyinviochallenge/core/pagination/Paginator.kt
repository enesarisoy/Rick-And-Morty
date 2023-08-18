package com.ns.rickandmortyinviochallenge.core.pagination

interface Paginator<Key, Items> {
    suspend fun loadNextItems()
    fun reset()
}