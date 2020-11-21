package com.github.cesar1287.desafiopicpayandroid.tmdb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.TmdbHomeBusiness
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.TopRated
import kotlinx.coroutines.launch

class TmdbHomeViewModel : ViewModel() {

    val onResultTopRated: MutableLiveData<TopRated> = MutableLiveData()
    val onResultFailure: MutableLiveData<String> = MutableLiveData()

    private val business by lazy {
        TmdbHomeBusiness()
    }

    fun getTopRated() {
        viewModelScope.launch {
            when(val response = business.getRated()) {
                is ResponseApi.Success -> {
                    onResultTopRated.postValue(
                        response.data as TopRated
                    )
                }
                is ResponseApi.Error -> {
                    onResultFailure.postValue(response.message)
                }
            }
        }
    }
}