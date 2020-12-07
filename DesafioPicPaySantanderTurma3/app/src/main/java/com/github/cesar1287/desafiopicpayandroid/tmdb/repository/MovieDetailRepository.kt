package com.github.cesar1287.desafiopicpayandroid.tmdb.repository

import android.content.Context
import com.github.cesar1287.desafiopicpayandroid.api.ApiService
import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi
import com.github.cesar1287.desafiopicpayandroid.tmdb.database.TmdbDatabase
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result
import java.lang.Exception

class MovieDetailRepository(
    private val context: Context
) {

    private val movieDao by lazy {
        TmdbDatabase.getDatabase(context).movieDao()
    }

    suspend fun getMovieById(movieId: Int): ResponseApi {
        return try {
            val response = ApiService.picpayApi.getMovieById(movieId)

            if (response.isSuccessful) {
                ResponseApi.Success(response.body())
            } else {
                if (response.code() == 404) {
                    ResponseApi.Error("Dado não encontrado")
                } else {
                    ResponseApi.Error("Erro ao carregar os dados")
                }
            }
        } catch (exception: Exception) {
            ResponseApi.Error("Erro ao carregar os dados")
        }
    }

    suspend fun deleteMovie(movie: Result) {
        movieDao.deleteMovie(movie)
    }

    suspend fun updateMovie(movie: Result) {
        movieDao.updateMovie(movie)
    }
}