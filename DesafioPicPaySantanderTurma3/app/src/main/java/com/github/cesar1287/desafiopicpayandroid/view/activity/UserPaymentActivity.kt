package com.github.cesar1287.desafiopicpayandroid.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.cesar1287.desafiopicpayandroid.R
import com.github.cesar1287.desafiopicpayandroid.model.UsersItem
import com.github.cesar1287.desafiopicpayandroid.view.activity.HomeActivity.Companion.KEY_INTENT_USER

class UserPaymentActivity : AppCompatActivity() {

    private var user: UsersItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_payment)

        user = intent.getParcelableExtra(KEY_INTENT_USER)

        setupUser()
    }

    private fun setupUser() {
//        Glide.with(this).load(user?.img).into(ivUserPaymentAvatar)
//        tvUserPaymentUserId.text = user?.username
    }
}