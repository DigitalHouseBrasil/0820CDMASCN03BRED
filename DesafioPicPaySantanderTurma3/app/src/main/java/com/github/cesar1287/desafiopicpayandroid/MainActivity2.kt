package com.github.cesar1287.desafiopicpayandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Exception

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.i("Tela 2", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Tela 2", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Tela 2", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Tela 2", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Tela 2", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Tela 2", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Tela 2", "onDestroy")
    }
}