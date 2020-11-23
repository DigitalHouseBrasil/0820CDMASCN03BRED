package com.github.cesar1287.desafiopicpayandroid.api

import com.github.cesar1287.desafiopicpayandroid.tmdb.model.TopRated
import com.github.cesar1287.desafiopicpayandroid.model.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PicpayApi {

    @GET("users")
    suspend fun users(): Response<Users>

    @GET("movie/top_rated")
    suspend fun topRated(
        @Query("page") pageNumber: Int
    ): Response<TopRated>

    @GET("movie/latest")
    suspend fun latest(): Response<TopRated>
}