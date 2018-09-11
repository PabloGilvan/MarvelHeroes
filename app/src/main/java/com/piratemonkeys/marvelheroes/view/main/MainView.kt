package com.piratemonkeys.constructapp.view.main

import com.piratemonkeys.marvelheroes.core.request.dto.HeroData

interface MainView {

    fun showNoConnectionMessage(show: Boolean)
    fun showNoContentMessage(show: Boolean)
    fun showLoader(show: Boolean)
    fun showHeroesList(show: Boolean)
    fun loadData(results: List<HeroData>)
}