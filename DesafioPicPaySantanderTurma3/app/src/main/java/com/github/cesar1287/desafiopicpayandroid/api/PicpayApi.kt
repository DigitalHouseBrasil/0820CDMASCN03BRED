package com.github.cesar1287.desafiopicpayandroid.api

import com.github.cesar1287.desafiopicpayandroid.tmdb.model.TopRated
import com.github.cesar1287.desafiopicpayandroid.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface PicpayApi {

    @GET("users")
    suspend fun users(): Response<Users>

    @GET("movie/top_rated?language=pt-BR&page=1")
    suspend fun topRated(): Response<TopRated>

    @GET("movie/latest?language=en-US")
    suspend fun latest(): Response<TopRated>
}