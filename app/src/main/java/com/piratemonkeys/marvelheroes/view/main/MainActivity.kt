package com.piratemonkeys.marvelheroes.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.piratemonkeys.constructapp.presenter.main.MainActivityPresenter
import com.piratemonkeys.constructapp.view.main.MainView
import com.piratemonkeys.marvelheroes.R
import com.piratemonkeys.marvelheroes.core.request.dto.HeroData
import com.piratemonkeys.marvelheroes.main.MainController
import com.piratemonkeys.marvelheroes.view.adapters.HeroesAdapter
import com.piratemonkeys.marvelheroes.view.custom.picasso
import com.piratemonkeys.marvelheroes.view.patterns.InfinityScrollLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private var adapter: HeroesAdapter? = null

    private var presenter: MainActivityPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenter(this, MainController(this.applicationContext))
        createView()
    }

    private fun createView() {
        heroes_recycle_view.layoutManager = LinearLayoutManager(this)
        heroes_recycle_view.setHasFixedSize(true)
        heroes_recycle_view.setOnScrollListener(InfinityScrollLoader({ presenter?.loadData()},
                                                heroes_recycle_view.layoutManager as LinearLayoutManager))
        presenter?.loadData()
    }


    override fun showNoConnectionMessage(show: Boolean) {
        container_internet_msg.visibility = getState(show)
    }

    override fun showNoContentMessage(show: Boolean) {
        no_content_tv.visibility = getState(show)
    }

    override fun showLoader(show: Boolean) {
        loading_bar_container.visibility = getState(show)
    }

    override fun showHeroesList(show: Boolean) {
        heroes_recycle_view.visibility = getState(show)
    }

    override fun loadData(results: List<HeroData>) {
        if(this.adapter == null) {
            this.adapter = HeroesAdapter()
            heroes_recycle_view.adapter = this.adapter
        }
        this.adapter?.addData(results)
    }

    private fun getState(show: Boolean): Int = if(show) View.VISIBLE else View.INVISIBLE

}

