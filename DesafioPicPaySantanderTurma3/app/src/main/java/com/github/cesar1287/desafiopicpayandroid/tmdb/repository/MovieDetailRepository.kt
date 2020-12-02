package com.github.cesar1287.desafiopicpayandroid.tmdb.repository

import android.content.Context
import com.github.cesar1287.desafiopicpayandroid.tmdb.database.TmdbDatabase
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result

class MovieDetailRepository(
    private val context: Context
) {

    suspend fun getMovieById(movieId: Int): Result {
        val movieDao = TmdbDatabase.getDatabase(context).movieDao()
        return movieDao.getMovieById(movieId)
    }
}