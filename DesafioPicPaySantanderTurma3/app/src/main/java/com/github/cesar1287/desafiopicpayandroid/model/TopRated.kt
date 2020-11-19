package com.github.cesar1287.desafiopicpayandroid.model

data class TopRated(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)