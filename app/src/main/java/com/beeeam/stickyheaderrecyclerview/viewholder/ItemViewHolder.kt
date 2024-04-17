package com.beeeam.stickyheaderrecyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.beeeam.stickyheaderrecyclerview.databinding.ItemRecyclerviewBinding
import com.beeeam.stickyheaderrecyclerview.model.Data

class ItemViewHolder(private val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Data) {
        binding.apply {
            tvTitle.text = item.title
            tvContent.text = item.content
            executePendingBindings()
        }
    }
}