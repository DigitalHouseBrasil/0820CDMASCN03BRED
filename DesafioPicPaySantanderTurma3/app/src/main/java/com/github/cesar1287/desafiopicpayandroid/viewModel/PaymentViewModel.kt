package com.github.cesar1287.desafiopicpayandroid.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PaymentViewModel : ViewModel() {

    val onTextChange: MutableLiveData<String> = MutableLiveData()

    //onTextChange - blue
    //onTextChange - red
    //onTextChange - green
}