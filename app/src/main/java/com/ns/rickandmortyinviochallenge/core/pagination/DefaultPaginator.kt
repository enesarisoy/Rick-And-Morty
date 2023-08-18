package com.ns.rickandmortyinviochallenge.core.pagination

import com.ns.rickandmortyinviochallenge.core.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class DefaultPaginator<Key, Item>(
    private val initialKey: Key,
    private inline val onLoadUpdated: (Boolean) -> Unit,
    private inline val onRequest: suspend (nextKey: Key) -> Flow<Resource<List<Item>>>,
    private inline val getNextKey: (List<Item>) -> Key,
    private inline val onError: suspend (String?) -> Unit,
    private inline val onSuccess: suspend (items: List<Item>, newKey: Key) -> Unit
) : Paginator<Key, Item> {

    private var currentKey = initialKey
    private var isMakingRequest = false

    override suspend fun loadNextItems() {
        if (isMakingRequest)
            return
        isMakingRequest = true
        onLoadUpdated(true)
        val result = onRequest(currentKey)
        isMakingRequest = false

        try {
            result.collect {
                when (it) {
                    is Resource.Success -> {
                        currentKey = getNextKey(it.data)
                        onSuccess(it.data, currentKey)
                        onLoadUpdated(false)
                    }

                    is Resource.Error -> {
                        onLoadUpdated(false)
                        onError(it.error)
                    }

                    is Resource.Loading -> onLoadUpdated(true)
                }
            }
        } catch (t: Throwable) {
            onLoadUpdated(false)
            onError(t.message.toString())
            return
        }
    }

    override fun reset() {
        currentKey = initialKey
    }
}