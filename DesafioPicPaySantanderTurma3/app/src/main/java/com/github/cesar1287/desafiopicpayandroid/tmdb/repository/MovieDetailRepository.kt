package com.github.cesar1287.desafiopicpayandroid.tmdb.repository

import android.content.Context
import com.github.cesar1287.desafiopicpayandroid.tmdb.database.TmdbDatabase
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result

class MovieDetailRepository(
    private val context: Context
) {

    private val movieDao by lazy {
        TmdbDatabase.getDatabase(context).movieDao()
    }

    suspend fun getMovieById(movieId: Int): Result {
        return movieDao.getMovieById(movieId)
    }

    suspend fun deleteMovie(movie: Result) {
        movieDao.deleteMovie(movie)
    }

    suspend fun updateMovie(movie: Result) {
        movieDao.updateMovie(movie)
    }
}