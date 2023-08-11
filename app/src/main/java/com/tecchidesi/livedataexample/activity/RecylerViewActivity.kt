package com.tecchidesi.livedataexample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tecchidesi.livedataexample.R
import com.tecchidesi.livedataexample.adapter.ItemAdapter
import com.tecchidesi.livedataexample.databinding.ActivityRecylerViewBinding
import com.tecchidesi.livedataexample.viewmodel.ItemViewModel

class RecylerViewActivity : AppCompatActivity() {

    private lateinit var itemViewModel : ItemViewModel
    private lateinit var mBinding: ActivityRecylerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_recyler_view)


        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        itemViewModel.items.observe(this) { items ->
            val adapter = ItemAdapter(items)
            mBinding.recyclerView.adapter = adapter
        }
    }

}