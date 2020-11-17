package com.github.cesar1287.desafiopicpayandroid.view.activity

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import com.github.cesar1287.desafiopicpayandroid.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private var sharedPreferences: SharedPreferences? = null
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("picpay", MODE_PRIVATE)
//        val editor = sharedPreferences.edit()
//        editor.putBoolean("bool", true)
//        editor.putFloat("float", 1.0f)
//        editor.putInt("int", 10)
//        editor.apply()

        initComponents()
        setupObservables()
    }

    private fun setupObservables() {
        binding.scTest1.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences?.edit {
                putBoolean("dark_mode", isChecked)
            }
        }

        binding.scTest2.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences?.edit {
                putBoolean("teste1", isChecked)
            }
        }

        binding.scTest3.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences?.edit {
                putBoolean("teste2", isChecked)
            }
        }

        binding.slider.valueFrom = 0f
        binding.slider.valueTo = 100f
        binding.slider.stepSize = 10f
        binding.slider.addOnChangeListener { _, value, _ ->
            sharedPreferences?.edit{
                putFloat("value_slider", value)
            }
        }
    }

    private fun initComponents() {
        val darkMode = sharedPreferences?.getBoolean("dark_mode", true)
        val test1 = sharedPreferences?.getBoolean("teste1", false)
        val test2 = sharedPreferences?.getBoolean("teste2", false)
        val sliderValue = sharedPreferences?.getFloat("value_slider", 0f)
        binding.scTest1.isChecked = darkMode ?: false
        binding.scTest2.isChecked = test1 ?: false
        binding.scTest3.isChecked = test2 ?: false
        binding.slider.value = sliderValue ?: 0f
    }
}