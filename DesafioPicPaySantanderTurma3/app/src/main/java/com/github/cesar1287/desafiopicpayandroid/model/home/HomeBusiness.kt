package com.github.cesar1287.desafiopicpayandroid.model.home

import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi

class HomeBusiness {

    private val repository: HomeRepository by lazy {
        HomeRepository()
    }

    suspend fun getUsers(): ResponseApi {
        return repository.getUsers()
    }

    suspend fun getTopRated(): ResponseApi {
        return repository.getTopRated()
    }
}