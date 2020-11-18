package com.github.cesar1287.desafiopicpayandroid.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.github.cesar1287.desafiopicpayandroid.viewModel.PaymentViewModel
import com.github.cesar1287.desafiopicpayandroid.R

class PaymentActivity : AppCompatActivity() {

    private lateinit var viewModel: PaymentViewModel

    //PaymentViewModel

    //paymentActivity

    //paymentFragment1

    //paymentFragment2

    //paymentFragment3


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        viewModel = ViewModelProvider(this).get(PaymentViewModel::class.java)

        viewModel.onTextChange.observe(this, { color ->
            color?.let {
                //tvTest.setTextColor(Color.parseColor(color))
            }
        })

        Log.i("teste - ACTIVITY", "onCreate")

        Toast.makeText(this, "Cliquei no botão", Toast.LENGTH_SHORT).show()

//        btBottomSheet.setOnClickListener {
//            val bottomSheet = PaymentFragment()
//            val bundle = Bundle()
//            val professor = Professor(nome = "Edu", sobrenome = "Misina", matricula = "12345")
//            bundle.putString("testeString", "xpto")
//            bundle.putDouble("testeDouble", 1.0)
//            bundle.putFloat("testeFloat", 1.0f)
//            bundle.putInt("testeInt", 1)
//            bundle.putParcelable("professor", professor)
//            bottomSheet.arguments = bundle
//            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
//        }
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