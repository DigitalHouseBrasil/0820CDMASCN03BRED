package com.github.cesar1287.desafiopicpayandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Main(posição1) -> Main2(posição2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewButton.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }

        Log.i("Tela 1", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Tela 1", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Tela 1", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Tela 1", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Tela 1", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Tela 1", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Tela 1", "onDestroy")
    }
}