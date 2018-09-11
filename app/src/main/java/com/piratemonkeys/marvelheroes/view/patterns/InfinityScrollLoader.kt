package com.piratemonkeys.marvelheroes.view.patterns

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.OnScrollListener

class InfinityScrollLoader(val func : () -> Unit, val layoutManager : LinearLayoutManager) : OnScrollListener() {

    override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        val countItems = layoutManager.itemCount
        if(countItems == layoutManager.findLastVisibleItemPosition() + 1) func()
    }
}

