package com.github.cesar1287.desafiopicpayandroid.model.home

import com.github.cesar1287.desafiopicpayandroid.model.User
import com.github.cesar1287.desafiopicpayandroid.model.Users

class HomeRepository {

    fun getUsers(): Users {
        val user1 = User(
            id = 1001,
            img = "https://randomuser.me/api/portraits/men/58.jpg",
            username = "@cesar.rodrigues",
            name = "César Rodrigues",
        )
        val user2 = User(
            id = 1002,
            img = "https://randomuser.me/api/portraits/men/51.jpg",
            username = "@edu.misina",
            name = "Eduardo Misina"
        )
        val user3 = User(
            1003,
            "https://randomuser.me/api/portraits/men/35.jpg",
            "Vinicius Trápia",
            "@vinicius.trapia"
        )
        val user4 = User(
            id = 1004,
            img = "https://randomuser.me/api/portraits/men/9.jpg",
            username = "@jonatas",
            name = "Jonatas"
        )
        val user5 = User(
            id = 1005,
            img = "https://randomuser.me/api/portraits/men/79.jpg",
            username = "@lincoln",
            name = "Lincoln"
        )

        return Users(
            usersList = listOf(user1, user2, user3, user4, user5)
        )
    }


}