package com.github.cesar1287.desafiopicpayandroid

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication


class DesafioPicPayApplication :  MultiDexApplication() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        MultiDex.install(this)
    }
}