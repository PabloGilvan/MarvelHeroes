package com.piratemonkeys.marvelheroes.view.custom

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.piratemonkeys.marvelheroes.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

public val Context.picasso: Picasso
    get() = Picasso.with(this)



fun ImageView.load(path: Int, request: (RequestCreator) -> RequestCreator){
    request(context.picasso.load(path).error(R.drawable.avatar_icon)).into(this)
}

fun ImageView.load(path: String, request: (RequestCreator) -> RequestCreator){
    request(context.picasso.load(path).error(R.drawable.avatar_icon)).into(this)
}

fun ImageView.load(path: Uri, request: (RequestCreator) -> RequestCreator){
    request(context.picasso.load(path).error(R.drawable.avatar_icon)).into(this)
}
