package com.tecchidesi.livedataexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tecchidesi.livedataexample.model.Item

class ItemViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Item>>()
    val items : LiveData<List<Item>> = _items

    init {
        val itemList = listOf(
            Item(1,"Item 1"),
            Item(2,"Item 2"),
            Item(3,"Item 3"),
        )
        _items.value = itemList
    }
}