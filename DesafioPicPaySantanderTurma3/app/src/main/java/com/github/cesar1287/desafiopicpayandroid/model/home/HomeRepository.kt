package com.github.cesar1287.desafiopicpayandroid.model.home

import com.github.cesar1287.desafiopicpayandroid.api.ApiService
import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi
import java.lang.Exception

class HomeRepository {

    suspend fun getUsers(): ResponseApi {
        return try {
            val response = ApiService.picpayApi.users()

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
}