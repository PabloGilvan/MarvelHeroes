package com.piratemonkeys.marvelheroes.main

import android.content.Context
import android.net.ConnectivityManager

import com.piratemonkeys.marvelheroes.core.patterns.ProcessResponse
import com.piratemonkeys.marvelheroes.core.request.RequestFactory
import com.piratemonkeys.marvelheroes.core.request.api.MarvelApi
import com.piratemonkeys.marvelheroes.core.request.dto.MarvelResponse
import com.piratemonkeys.marvelheroes.utils.AppConfigUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainController(private val context: Context) {


    private val api: MarvelApi = RequestFactory().createApi()
    private val utils: AppConfigUtils = AppConfigUtils(context)

    fun hasConnection(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }

    fun requestData(page: Int, size: Int = 20, processResponse: ProcessResponse<MarvelResponse>) {

        val ts = System.currentTimeMillis()/1000
        api.getHeroes(page, utils.getKey(), utils.getMD5(ts), ts).subscribeOn(Schedulers.io())
                                             .observeOn(AndroidSchedulers
                                                      .mainThread())
                                             .subscribe({ response -> processResponse.success(response.data) },
                                                        { error -> processResponse.error( "Erro") })
    }
}
