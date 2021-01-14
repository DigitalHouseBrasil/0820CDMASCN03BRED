package com.github.cesar1287.desafiopicpayandroid.model

import android.content.SharedPreferences

data class UserFirestore(
    val name: String? = null,
    val last_name: String? = null,
    val email: String? = null,
    val phone: String? = null
)