package com.github.cesar1287.desafiopicpayandroid.model.home

import com.github.cesar1287.desafiopicpayandroid.model.User

class HomeBusiness {

    fun getUsers(): List<User> {
        val users = mutableListOf<User>()

        val user1 = User("https://randomuser.me/api/portraits/men/58.jpg", "@cesar.rodrigues", "César Rodrigues", 10.0)
        val user2 = User("https://randomuser.me/api/portraits/men/51.jpg", "@edu.misina", "Eduardo Misina")
        val user3 = User("https://randomuser.me/api/portraits/men/35.jpg", "@vinicius.trapia", "Vinicius Trápia")
        val user4 = User("https://randomuser.me/api/portraits/men/9.jpg", "@jonatas", "Jonatas")
        val user5 = User("https://randomuser.me/api/portraits/men/79.jpg", "@lincoln", "Lincoln")
        val user11 = User("https://randomuser.me/api/portraits/men/79.jpg", "@cesar.rodrigues", "César Rodrigues")
        val user21 = User("https://randomuser.me/api/portraits/men/79.jpg", "@edu.misina", "Eduardo Misina", 20.0)
        val user31 = User("https://randomuser.me/api/portraits/men/79.jpg", "@vinicius.trapia", "Vinicius Trápia")
        val user41 = User("https://randomuser.me/api/portraits/men/79.jpg", "@jonatas", "Jonatas")
        val user51 = User("https://randomuser.me/api/portraits/men/79.jpg", "@lincoln", "Lincoln", 100.0)
        val user12 = User("https://randomuser.me/api/portraits/men/79.jpg", "@cesar.rodrigues", "César Rodrigues")
        val user22 = User("https://randomuser.me/api/portraits/men/79.jpg", "@edu.misina", "Eduardo Misina")
        val user32 = User("https://randomuser.me/api/portraits/men/79.jpg", "@vinicius.trapia", "Vinicius Trápia")
        val user42 = User("https://randomuser.me/api/portraits/men/79.jpg", "@jonatas", "Jonatas")
        val user52 = User("https://randomuser.me/api/portraits/men/79.jpg", "@lincoln", "Lincoln")

        users.addAll(listOf(user1, user2, user3, user4, user5, user11, user21,
            user31, user41, user51, user12, user22, user32, user42, user52))

        return users
    }
}