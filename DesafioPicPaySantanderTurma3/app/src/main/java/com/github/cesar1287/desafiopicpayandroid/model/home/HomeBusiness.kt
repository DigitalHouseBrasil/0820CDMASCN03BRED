package com.github.cesar1287.desafiopicpayandroid.model.home

class HomeBusiness {

    private val repository: HomeRepository by lazy {
        HomeRepository()
    }

    fun getUsers(): Users {
        val users = repository.getUsers()
        users.usersList.last().name = "Teste"
        users.usersList.first().name = users.usersList.first().name.take(2)
        return users
    }
}