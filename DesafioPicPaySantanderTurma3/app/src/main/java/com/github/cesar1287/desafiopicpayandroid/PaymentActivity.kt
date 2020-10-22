package com.github.cesar1287.desafiopicpayandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        Log.i("teste - ACTIVITY", "onCreate")

        btBottomSheet.setOnClickListener {
            val bottomSheet = PaymentFragment()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("teste - ACTIVITY", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("teste - ACTIVITY", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("teste - ACTIVITY", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("teste - ACTIVITY", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("teste - ACTIVITY", "onDestroy")
    }
}