package com.ns.rickandmortyinviochallenge.core.util

fun List<String>.getNumbersInList(seperator: String): String {
    val stringValue = if (size == 1) {
        this[0].substringAfterLast("/")
    } else {
        this.joinToString(seperator) { it.substringAfterLast("/") }
    }
    return stringValue
}