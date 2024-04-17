package com.beeeam.stickyheaderrecyclerview.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.beeeam.stickyheaderrecyclerview.databinding.HeaderRecyclerviewBinding
import com.beeeam.stickyheaderrecyclerview.model.Data

class HeaderViewHolder(private val binding: HeaderRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Data) {
        binding.apply {
            tvHeaderTitle.text = item.title
            tvHeaderContent.text = item.content
            executePendingBindings()
        }
    }
}