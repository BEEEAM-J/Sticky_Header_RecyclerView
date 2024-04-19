package com.beeeam.stickyheaderrecyclerview.ui

import StickyHeaderItemDecoration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.beeeam.stickyheaderrecyclerview.R
import com.beeeam.stickyheaderrecyclerview.SectionCallBack
import com.beeeam.stickyheaderrecyclerview.adapter.RecyclerViewAdapter
import com.beeeam.stickyheaderrecyclerview.databinding.ActivityMainBinding
import com.beeeam.stickyheaderrecyclerview.model.Data

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val data = mutableListOf<Data>()
    private val adapter = RecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        for(i in 1..20) {
            data.add(
                Data(title = "Title $i", content = "Content $i")
            )
        }

        binding.recyclerview.adapter = adapter
        Log.d("데이터 리스트", data.toString())
        adapter.submitList(data)
        binding.recyclerview.addItemDecoration(StickyHeaderItemDecoration(getSectionCallback()))
    }

    private fun getSectionCallback(): SectionCallBack {
        return object : SectionCallBack {
            override fun getHeaderView(list: RecyclerView, position: Int): View? {
                return adapter.getHeaderView(list, position)
            }
        }
    }
}