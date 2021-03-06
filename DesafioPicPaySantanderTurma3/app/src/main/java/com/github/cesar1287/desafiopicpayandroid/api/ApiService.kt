package com.github.cesar1287.desafiopicpayandroid.api

import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.API_AUTH_NAME
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.API_AUTH_VALUE
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.API_CONTENT_TYPE_NAME
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.API_CONTENT_TYPE_VALUE
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.BASE_URL
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.BASE_URL_TMDB
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.QUERY_PARAM_LANGUAGE_LABEL
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.QUERY_PARAM_LANGUAGE_VALUE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {

    val picpayApi: PicpayApi = getPicpayApiClient().create(PicpayApi::class.java)

    private fun getPicpayApiClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_TMDB)
            .client(getInterceptorClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getInterceptorClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader(API_AUTH_NAME, API_AUTH_VALUE)
                    .addHeader(API_CONTENT_TYPE_NAME, API_CONTENT_TYPE_VALUE)
                    .build()
                chain.proceed(newRequest)
            }
            .addInterceptor { chain ->
                val url = chain.request().url().newBuilder()
                    .addQueryParameter(QUERY_PARAM_LANGUAGE_LABEL, QUERY_PARAM_LANGUAGE_VALUE)
                    .build()
                val newRequest = chain.request().newBuilder().url(url).build()
                chain.proceed(newRequest)
            }
        return interceptor.build()
    }
}