package com.piratemonkeys.marvelheroes.core.request.api

import com.piratemonkeys.marvelheroes.core.request.dto.MarvelResponse
import com.piratemonkeys.marvelheroes.core.request.dto.MarvelWrapper
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {


    @GET("characters")
    fun getHeroes(@Query("offset") page: Int,
                  @Query("apikey") key: String,
                  @Query("hash") hash: String,
                  @Query("ts") ts: Long): Single<MarvelWrapper>

}
