package com.github.cesar1287.desafiopicpayandroid.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.cesar1287.desafiopicpayandroid.api.ResponseApi
import com.github.cesar1287.desafiopicpayandroid.model.Users
import com.github.cesar1287.desafiopicpayandroid.model.home.HomeBusiness
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val usersLiveData: MutableLiveData<Users> = MutableLiveData()
    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()
    private val homeBusiness = HomeBusiness()

    fun getUsers() {
        viewModelScope.launch {
            when (val response = homeBusiness.getUsers()) {
                is ResponseApi.Success -> {
                    usersLiveData.postValue(
                        response.data as? Users
                    )
                }
                is ResponseApi.Error -> {
                    errorMessageLiveData.postValue(
                        response.message
                    )
                }
            }
        }
    }
}