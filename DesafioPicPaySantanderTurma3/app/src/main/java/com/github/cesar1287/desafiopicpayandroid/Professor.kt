package com.github.cesar1287.desafiopicpayandroid

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Professor(
    var nome: String,
    var sobrenome: String,
    var matricula: String
) : Parcelable