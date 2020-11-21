package com.github.cesar1287.desafiopicpayandroid.tmdb.model

import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi
import com.github.cesar1287.desafiopicpayandroid.tmdb.repository.TmdbHomeRepository
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.BASE_URL_ORIGINAL_IMAGE

class TmdbHomeBusiness {

    private val repository by lazy {
        TmdbHomeRepository()
    }

    suspend fun getRated(): ResponseApi {
        val response = repository.getTopRated()
        return if (response is ResponseApi.Success) {
            val topRated = response.data as TopRated
            topRated.results.firstOrNull()?.title = "Teste 123"
            topRated.results.forEach {
                it.posterPath = "$BASE_URL_ORIGINAL_IMAGE${it.posterPath}"
            }
            topRated.results.firstOrNull()?.posterPath = "xpto"
            ResponseApi.Success(topRated)
        } else {
            response
        }
    }


}