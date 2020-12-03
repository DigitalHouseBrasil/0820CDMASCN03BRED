package com.github.cesar1287.desafiopicpayandroid.tmdb.repository

import android.content.Context
import com.github.cesar1287.desafiopicpayandroid.api.ApiService
import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi
import com.github.cesar1287.desafiopicpayandroid.tmdb.database.TmdbDatabase
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result
import java.lang.Exception

class TmdbHomeRepository(
    private val context: Context
) {

    suspend fun getTopRated(pageNumber: Int): ResponseApi {
        return try {
            val response = ApiService.picpayApi.topRated(pageNumber)

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

    suspend fun getAllMovies(): List<Result> {
        val movieDao = TmdbDatabase.getDatabase(context).movieDao()
        return movieDao.getAllMovies()
    }
}