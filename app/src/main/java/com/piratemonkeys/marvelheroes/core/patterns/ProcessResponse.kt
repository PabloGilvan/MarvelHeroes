package com.piratemonkeys.marvelheroes.core.patterns

interface ProcessResponse<in Entity>{
    fun success(response: Entity)
    fun error(message : String)
}
