package com.github.cesar1287.desafiopicpayandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val id: Int,
    val img: String,
    var name: String,
    val username: String
): Parcelable