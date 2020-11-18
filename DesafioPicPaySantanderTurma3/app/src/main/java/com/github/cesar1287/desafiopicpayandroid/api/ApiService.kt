package com.github.cesar1287.desafiopicpayandroid.api

import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val picpayApi = getPicpayApiClient().create(PicpayApi::class.java)

    fun getPicpayApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}