package com.github.cesar1287.desafiopicpayandroid.tmdb.model

import android.content.Context
import com.github.cesar1287.desafiopicpayandroid.tmdb.repository.MovieDetailRepository

class MovieDetailBusiness(
    private val context: Context
) {

    private val repository by lazy {
        MovieDetailRepository(context)
    }

    suspend fun getMovieById(movieId: Int): Result {
        return repository.getMovieById(movieId)
    }

    suspend fun deleteMovie(movie: Result) {
        repository.deleteMovie(movie)
    }

    suspend fun updateMovie(movie: Result) {
        movie.apply {
            title = "$title - teste update"
        }
        repository.updateMovie(movie)
    }
}