package com.piratemonkeys.marvelheroes.utils

import android.content.Context
import java.security.MessageDigest

class AppConfigUtils(context: Context) {

    fun getKey(): String {
        return "6db22d6421c652290bab9ef5efdc2743"
    }

    fun getMD5(ts: Long): String {
        var bytes = MessageDigest.getInstance("MD5")
                                 .digest((ts.toString() + "3e3e4b247ad26cf5bf9783a4a72d5df4be80a860" + getKey())
                                 .toByteArray())
        return bytes.fold("") { str, it -> str + "%02x".format(it) }
    }

}
