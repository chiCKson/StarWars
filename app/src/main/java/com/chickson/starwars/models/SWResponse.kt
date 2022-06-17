package com.chickson.starwars.models

data class SWResponse<T>(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: T,
    var detail: String? = null
)