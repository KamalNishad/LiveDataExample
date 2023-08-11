package com.tecchidesi.livedataexample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tecchidesi.livedataexample.model.Temperature


class MainViewModel : ViewModel() {
    private val temperatureLiveData = MutableLiveData<Temperature>()

    fun getTemperatureLiveData(): LiveData<Temperature>? {
        return temperatureLiveData
    }

    fun updateTemperature(newTemperature: Int) {
        temperatureLiveData.value = Temperature(newTemperature)
    }
}