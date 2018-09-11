package com.piratemonkeys.marvelheroes.core.request

import android.content.Context
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.piratemonkeys.marvelheroes.core.request.api.MarvelApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RequestFactory {

    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client : OkHttpClient
    private val retrofit : Retrofit
    private val gson = GsonBuilder().enableComplexMapKeySerialization()
            .serializeNulls()
            .setDateFormat("yyyy-MM-dd HH:mm:ss").create()

    constructor(context: Context){
        client = OkHttpClient.Builder().addInterceptor { chain ->
            chain.proceed(chain.request().newBuilder().build())
        }.build()
        retrofit = Retrofit.Builder().client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://gateway.marvel.com:443/v1/public/")
                .build()
    }

    constructor(){
        client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        retrofit = Retrofit.Builder().client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://gateway.marvel.com:443/v1/public/")
                .build()
    }


    fun createApi(): MarvelApi = retrofit.create(MarvelApi::class.java)
}
