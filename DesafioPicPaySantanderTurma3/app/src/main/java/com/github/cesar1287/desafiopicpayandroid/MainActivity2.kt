package com.github.cesar1287.desafiopicpayandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.i("Tela 2", "onCreate")

        loadFragment(NaoSocioFragment())

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        loadFragment(NaoSocioFragment())
                    }
                    1 -> {
                        loadFragment(SocioFragment())
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) { /** não uso */ }

            override fun onTabReselected(tab: TabLayout.Tab?) { /** não uso*/ }

        })
    }

    private fun loadFragment(fragment: Fragment, bundle: Bundle = Bundle()) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.container, fragment)
        ft.commit()
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