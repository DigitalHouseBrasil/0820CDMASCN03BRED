package com.github.cesar1287.exercicioandroid1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val tabLayout by lazy {
        findViewById<TabLayout>(R.id.tabLayout)
    }

    private val viewPager by lazy {
        findViewById<ViewPager>(R.id.viewPager)
    }

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
        //callFragment(naoSocioFragment)

        //tabLayout.addOnTabSelectedListener(this)

        viewPager.adapter = RegisterAdapter(
            listOf(
                getString(R.string.nao_socio),
                getString(R.string.socio),
                getString(R.string.socio)
            ),
            listOf(
                NaoSocioFragment(),
                SocioFragment(),
                SocioFragment()
            ),
            supportFragmentManager
        )
        tabLayout.setupWithViewPager(viewPager)

        viewModel.onDataSaved.observe(this, Observer {
            if (it == true) {
                tabLayout.getTabAt(1)?.select()
            }
        })

//        viewModel.socioAtualizado.observe(this, {
//            nomeSocio = it
//        })
    }
}