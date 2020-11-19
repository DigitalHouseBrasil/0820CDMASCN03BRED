package com.github.cesar1287.desafiopicpayandroid.api

sealed class ResponseApi {
    class Success(val data: Any?): ResponseApi()
    class Error(val message: String): ResponseApi()
}