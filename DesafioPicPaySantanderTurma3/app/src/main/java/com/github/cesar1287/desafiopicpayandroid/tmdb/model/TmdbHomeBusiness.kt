package com.github.cesar1287.desafiopicpayandroid.tmdb.model

import android.content.Context
import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi
import com.github.cesar1287.desafiopicpayandroid.tmdb.repository.TmdbHomeRepository
import com.github.cesar1287.desafiopicpayandroid.utils.Constants.Api.BASE_URL_ORIGINAL_IMAGE

class TmdbHomeBusiness(
    context: Context
) {

    private val repository by lazy {
        TmdbHomeRepository(context)
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

    suspend fun getAllMovies(): List<Result> {
        return repository.getAllMovies()
    }
}