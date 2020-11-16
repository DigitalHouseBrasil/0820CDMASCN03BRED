package com.github.cesar1287.desafiopicpayandroid.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.cesar1287.desafiopicpayandroid.model.Users
import com.github.cesar1287.desafiopicpayandroid.model.home.HomeBusiness

class HomeViewModel : ViewModel() {

    val usersLiveData: MutableLiveData<Users> = MutableLiveData()
    private val homeBusiness = HomeBusiness()

    fun getUsers() {
        val users = homeBusiness.getUsers()
        usersLiveData.postValue(users)
    }


}