package com.johnjeremih.mvvmwithkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    var number = 0

    val currentNumber : MutableLiveData<Int> by lazy {

        MutableLiveData<Int>()

    }




}