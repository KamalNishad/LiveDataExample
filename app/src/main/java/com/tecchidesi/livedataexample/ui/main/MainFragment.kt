package com.tecchidesi.livedataexample.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tecchidesi.livedataexample.R
import com.tecchidesi.livedataexample.model.Temperature


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onStart() {
        super.onStart()

        viewModel.getTemperatureLiveData()!!.observe(this)
        { temperature ->
            // Update UI with the new temperature value
            val newTemp = temperature.value
            // Update TextView or other UI components

            Log.d("temp :: ", newTemp.toString())
        }

        var newTemp = 26;
        viewModel.updateTemperature(newTemp)
        Log.d("newTemp ::", viewModel.updateTemperature(newTemp).toString())
    }

}