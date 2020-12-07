package com.github.cesar1287.desafiopicpayandroid.api

import com.github.cesar1287.desafiopicpayandroid.model.Movie
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.TopRated
import com.github.cesar1287.desafiopicpayandroid.model.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("movie/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id") movieId: Int
    ): Response<Movie>

    @GET("movie/{movie_id}/{movie_video}")
    suspend fun movieDetails(
        @Path("movie_video") movieVideo: String,
        @Path("movie_id") movieId: Int
    ): Response<Any>
}