package com.piratemonkeys.marvelheroes.core.request.dto

data class MarvelResponse(var offset: Int?, var limit: Int?, var total: Int?, var count: Int?,
                          var results: List<HeroData>?)
