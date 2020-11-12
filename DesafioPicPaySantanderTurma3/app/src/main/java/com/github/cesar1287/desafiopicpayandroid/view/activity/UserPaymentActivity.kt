package com.github.cesar1287.desafiopicpayandroid.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.github.cesar1287.desafiopicpayandroid.R
import com.github.cesar1287.desafiopicpayandroid.model.User
import com.github.cesar1287.desafiopicpayandroid.view.activity.HomeActivity.Companion.KEY_INTENT_USER
import kotlinx.android.synthetic.main.activity_user_payment.*

class UserPaymentActivity : AppCompatActivity() {

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_payment)

        user = intent.getParcelableExtra(KEY_INTENT_USER)

        setupUser()
    }

    private fun setupUser() {
        Glide.with(this).load(user?.userProfileAvatar).into(ivUserPaymentAvatar)
        tvUserPaymentUserId.text = user?.userId
    }
}