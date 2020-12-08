package com.github.cesar1287.desafiopicpayandroid.tmdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi
import com.github.cesar1287.desafiopicpayandroid.model.Movie
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.MovieDetailBusiness
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    application: Application
) : AndroidViewModel(application) {

    val onMovieDetailLoaded: MutableLiveData<Movie> = MutableLiveData()
    val onMovieDetailFailed: MutableLiveData<String> = MutableLiveData()

    private val business by lazy {
        MovieDetailBusiness(application)
    }

    fun getMovieById(movieId: Int) {
        viewModelScope.launch {
            when(val response = business.getMovieById(movieId)) {
                is ResponseApi.Success -> {
                    onMovieDetailLoaded.postValue(
                        response.data as? Movie
                    )
                }
                is ResponseApi.Error -> {
                    onMovieDetailFailed.postValue(
                        response.message
                    )
                }
            }
        }
    }

    fun deleteMovie(movie: Result) {
        viewModelScope.launch {
            business.deleteMovie(movie)
        }
    }

    fun updateMovie(movie: Result) {
        viewModelScope.launch {
            business.updateMovie(movie)
        }
    }

    fun insertMovie(movie: Movie) {
        viewModelScope.launch {
            business.insertMovie(movie)
        }
    }

}