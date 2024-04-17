package com.beeeam.stickyheaderrecyclerview.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.beeeam.stickyheaderrecyclerview.databinding.HeaderRecyclerviewBinding
import com.beeeam.stickyheaderrecyclerview.databinding.ItemRecyclerviewBinding
import com.beeeam.stickyheaderrecyclerview.model.Data
import com.beeeam.stickyheaderrecyclerview.viewholder.HeaderViewHolder
import com.beeeam.stickyheaderrecyclerview.viewholder.ItemViewHolder

class RecyclerViewAdapter : ListAdapter<Data, RecyclerView.ViewHolder>(RecyclerViewDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("onCreateViewHolder", "onCreateViewHolder")
        return if (viewType == 0) {
            HeaderViewHolder(
                HeaderRecyclerviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                )
            )
        } else {
            ItemViewHolder(
                ItemRecyclerviewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("onBindViewHolder", "onBindViewHolder")
        if(holder is ItemViewHolder) {
            holder.bind(currentList[position])
        } else if (holder is HeaderViewHolder) {
            holder.bind(currentList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(currentList[position].title == "Title 2") 0 else 1
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    fun isHeader(position: Int) = currentList[position].title == "Title 2"

    fun getHeaderView(list: RecyclerView, position: Int): View? {
        val lastPosition = if (position < currentList.size) position else currentList.size - 1
        Log.d("last Position", "last Position: $lastPosition")
        for (pos in lastPosition downTo 0) {
            Log.d("pos", "pos: $pos")
            if (currentList[pos].title == "Title 2") {
                return HeaderRecyclerviewBinding.inflate(LayoutInflater.from(list.context), list, false).root
            }
        }
        return null
    }
}

class RecyclerViewDiffCallback : DiffUtil.ItemCallback<Data>() {

    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.content == newItem.content
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}
