package com.piratemonkeys.constructapp.presenter.main

import android.util.Log
import com.piratemonkeys.constructapp.view.main.MainView
import com.piratemonkeys.marvelheroes.core.patterns.ProcessResponse
import com.piratemonkeys.marvelheroes.core.request.dto.MarvelResponse
import com.piratemonkeys.marvelheroes.presenters.main.MainLoader
import com.piratemonkeys.marvelheroes.view.custom.ViewState

class MainActivityPresenter(var view: MainView, private var loader: MainLoader):
                                                                    ProcessResponse<MarvelResponse> {

    var page:Int = 0

    var viewState : ViewState = ViewState.CLEAR

    fun loadData(){

        if(viewState == ViewState.LOADING) return

        if(loader.hasConnection()){
            viewState = ViewState.LOADING
            loader.requestData(page = page, processResponse = this)
        } else {
            viewState = ViewState.NO_CONNECTION
        }

        renderView()
    }

    private fun renderView() {
        view.showLoader(viewState == ViewState.LOADING)
        view.showNoConnectionMessage(viewState == ViewState.NO_CONNECTION)
        view.showNoContentMessage(viewState == ViewState.NO_CONTENT)
        view.showHeroesList(viewState == ViewState.DONE || viewState == ViewState.LOADING)
    }

    override fun success(response: MarvelResponse) {
        this.page += response.count?: 0
        this.view.loadData(response.results?: arrayListOf())

        viewState = ViewState.DONE
        renderView()
    }

    override fun error(message: String) {
        Log.e("RESPONSE", message)
        viewState = ViewState.DONE
        renderView()
    }

}