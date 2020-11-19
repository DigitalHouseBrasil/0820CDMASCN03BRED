package com.github.cesar1287.desafiopicpayandroid.api

import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.BASE_URL
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.BASE_URL_TMDB
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val picpayApi = getPicpayApiClient().create(PicpayApi::class.java)

    private fun getPicpayApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_TMDB)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}