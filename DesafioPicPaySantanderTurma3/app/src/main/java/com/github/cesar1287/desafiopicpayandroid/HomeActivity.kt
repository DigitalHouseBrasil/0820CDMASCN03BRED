package com.github.cesar1287.desafiopicpayandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), MainAdapterListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val users = mutableListOf<User>()

        val user1 = User("teste", "@cesar.rodrigues", "César Rodrigues", 10.0)
        val user2 = User("teste", "@edu.misina", "Eduardo Misina")
        val user3 = User("teste", "@vinicius.trapia", "Vinicius Trápia")
        val user4 = User("teste", "@jonatas", "Jonatas")
        val user5 = User("teste", "@lincoln", "Lincoln")
        val user11 = User("teste", "@cesar.rodrigues", "César Rodrigues")
        val user21 = User("teste", "@edu.misina", "Eduardo Misina", 20.0)
        val user31 = User("teste", "@vinicius.trapia", "Vinicius Trápia")
        val user41 = User("teste", "@jonatas", "Jonatas")
        val user51 = User("teste", "@lincoln", "Lincoln", 100.0)
        val user12 = User("teste", "@cesar.rodrigues", "César Rodrigues")
        val user22 = User("teste", "@edu.misina", "Eduardo Misina")
        val user32 = User("teste", "@vinicius.trapia", "Vinicius Trápia")
        val user42 = User("teste", "@jonatas", "Jonatas")
        val user52 = User("teste", "@lincoln", "Lincoln")

        users.addAll(listOf(user1, user2, user3, user4, user5, user11, user21,
            user31, user41, user51, user12, user22, user32, user42, user52))

        findViewById<RecyclerView>(R.id.rvHomeUserList).apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = MainAdapter(users, this@HomeActivity)
        }
    }

    override fun onItemClicked(position: Int) {
        Log.i("HomeActivity", "Cliquei na posição ${position + 1}")
    }
}