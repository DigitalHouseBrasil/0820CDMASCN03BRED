package com.github.cesar1287.desafiopicpayandroid.tmdb.model

import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi
import com.github.cesar1287.desafiopicpayandroid.tmdb.repository.TmdbHomeRepository
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.BASE_URL_ORIGINAL_IMAGE

class TmdbHomeBusiness {

    private val repository by lazy {
        TmdbHomeRepository()
    }

    suspend fun getRated(pageNumber: Int): ResponseApi {
        val response = repository.getTopRated(pageNumber)
        return if (response is ResponseApi.Success) {
            val topRated = response.data as TopRated
            topRated.results.forEach {
                it.posterPath = "$BASE_URL_ORIGINAL_IMAGE${it.posterPath}"
            }
            ResponseApi.Success(topRated)
        } else {
            response
        }
    }
}