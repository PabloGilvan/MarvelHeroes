package com.piratemonkeys.marvelheroes.core.request.dto

import java.util.*

/*    "path": "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784",
            "extension": "jpg"*/
data class HeroData(var id: Long?, var name: String?, var description: String,
                    var modified: Date?, var resourceURI: String?, var thumbnail: Map<String, String>)

