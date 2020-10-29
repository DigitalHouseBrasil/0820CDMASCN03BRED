package com.github.cesar1287.exercicioandroid1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.cesar1287.exercicioandroid1.model.Socio

class MainViewModel : ViewModel() {

    val socioAtualizado: MutableLiveData<Socio> = MutableLiveData()
    val onDataSaved: MutableLiveData<Boolean> = MutableLiveData()

    fun setNovoSocio(socio: Socio) {
        socioAtualizado.postValue(socio)
    }

    fun goToSocio(value: Boolean) {
        onDataSaved.postValue(value)
    }
}