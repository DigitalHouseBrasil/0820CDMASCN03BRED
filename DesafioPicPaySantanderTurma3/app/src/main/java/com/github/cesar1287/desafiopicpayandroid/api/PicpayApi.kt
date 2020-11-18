package com.github.cesar1287.desafiopicpayandroid.api

import com.github.cesar1287.desafiopicpayandroid.model.Users
import retrofit2.http.GET

interface PicpayApi {

    @GET("users")
    suspend fun users(): Users
}