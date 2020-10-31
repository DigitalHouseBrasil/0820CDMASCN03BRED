package com.github.cesar1287.exercicioandroid1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewModel: MainViewModel

    private val socioFragment = SocioFragment()
    private val naoSocioFragment = NaoSocioFragment()

    //private var nomeSocio = ""

    //fragment A para o Fragment B
    //fragment A serializar Socio -> Fragment B deserializar Socio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        initComponents()
    }

    private fun initComponents() {
        callFragment(naoSocioFragment)

        tabLayout = findViewById(R.id.tabLayout)

        tabLayout.addOnTabSelectedListener(this)

        viewModel.onDataSaved.observe(this, Observer {
            if (it == true) {
                tabLayout.getTabAt(1)?.select()
            }
        })

//        viewModel.socioAtualizado.observe(this, {
//            nomeSocio = it
//        })
    }

    private fun callFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()

//        val bundle = Bundle()
//        bundle.putString("socio", nomeSocio)
//        fragment.arguments = bundle

        ft.replace(R.id.container, fragment)
        ft.commit()
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when (tab?.position) {
            0 -> {
                callFragment(naoSocioFragment)
            }
            1 -> {
                callFragment(socioFragment)
            }
        }
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        /** não uso */
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
        /** não uso */
    }
}