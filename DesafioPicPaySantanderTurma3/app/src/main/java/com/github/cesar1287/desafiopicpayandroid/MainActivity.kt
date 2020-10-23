package com.github.cesar1287.desafiopicpayandroid

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.lifecycle.ViewModelProvider
import com.github.cesar1287.desafiopicpayandroid.RegisterCreditCardActivity.Companion.KEY_CREDIT_CARD_NUMBER
import com.github.cesar1287.desafiopicpayandroid.RegisterCreditCardActivity.Companion.KEY_TEACHER
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PaymentViewModel

    //Main(posição1) -> Main2(posição2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberCreditCard = intent.getStringExtra(KEY_CREDIT_CARD_NUMBER)
        val professor = intent.getParcelableExtra<Professor>(KEY_TEACHER)
        val double = intent.getDoubleExtra("double", 0.0)

        val bundle = intent.extras
        bundle?.getDouble("double")
        bundle?.getFloat("float")

        professor?.nome
        professor?.sobrenome
        professor?.matricula

        //etCreditCardNumber.text = Editable.Factory.getInstance().newEditable(numberCreditCard)

        initComponents()
    }

    override fun onResume() {
        super.onResume()

        viewModel = ViewModelProvider(this).get(PaymentViewModel::class.java)

        viewModel.onTextChange.observe(this, { color ->
            color?.let {
                tvCreditCardTitle.setTextColor(Color.parseColor(color))
            }
        })
    }

    private fun initComponents() {
        etCreditCardNumber.addTextChangedListener(MaskWatcher(etCreditCardNumber, getString(R.string.credit_card_mask)))
        etCreditCardExpiration.addTextChangedListener(MaskWatcher(etCreditCardExpiration, getString(R.string.expiration_mask)))
        etCreditCardCvv.addTextChangedListener(MaskWatcher(etCreditCardCvv, getString(R.string.cvv_mask)))

        etCreditCardNumber.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        btCreditCardSave.setOnClickListener {
            startMain2(this@MainActivity)
        }

        ibCreditcardBack.setOnClickListener {
            finish()
        }
    }

    fun startMain2(context: Context) {
        val intent = Intent(context, PaymentActivity::class.java)
        startActivity(intent)
    }
}