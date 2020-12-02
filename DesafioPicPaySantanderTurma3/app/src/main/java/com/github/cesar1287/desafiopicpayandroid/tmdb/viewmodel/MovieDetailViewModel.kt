package com.github.cesar1287.desafiopicpayandroid.tmdb.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.MovieDetailBusiness
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    application: Application
) : AndroidViewModel(application) {

    val onMovieDetailLoaded: MutableLiveData<Result> = MutableLiveData()

    private val business by lazy {
        MovieDetailBusiness(application)
    }

    fun getMovieById(movieId: Int) {
        viewModelScope.launch {
            onMovieDetailLoaded.postValue(
                business.getMovieById(movieId)
            )
        }
    }

}