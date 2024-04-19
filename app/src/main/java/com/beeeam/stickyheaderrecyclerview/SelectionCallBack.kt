package com.beeeam.stickyheaderrecyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

interface SectionCallBack {
    fun getHeaderView(list: RecyclerView, position: Int): View?   // Sticky Header로 표현할 뷰를 가져옴
}