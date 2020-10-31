package com.github.cesar1287.desafiopicpayandroid

data class User(
    val userProfileAvatar: String,
    val userId: String,
    val userName: String,
    val cash: Double = 0.0
)