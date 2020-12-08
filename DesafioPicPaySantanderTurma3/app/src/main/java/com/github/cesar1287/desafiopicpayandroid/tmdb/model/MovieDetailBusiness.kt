package com.github.cesar1287.desafiopicpayandroid.tmdb.model

import android.content.Context
import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi
import com.github.cesar1287.desafiopicpayandroid.extensions.getFullImagePath
import com.github.cesar1287.desafiopicpayandroid.model.Movie
import com.github.cesar1287.desafiopicpayandroid.tmdb.repository.MovieDetailRepository

class MovieDetailBusiness(
    private val context: Context
) {

    private val repository by lazy {
        MovieDetailRepository(context)
    }

    suspend fun getMovieById(movieId: Int): ResponseApi {
        return when(val response = repository.getMovieById(movieId)){
            is ResponseApi.Success -> {
                val movie = response.data as? Movie
                movie?.posterPath = movie?.posterPath?.getFullImagePath()
                ResponseApi.Success(movie)
            }
            is ResponseApi.Error ->{
                response
            }
        }
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

    suspend fun insertMovie(movie: Movie) {
        repository.insertMovie(movie)
    }
}