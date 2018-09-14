package com.example.jsonnotation.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(source: String) {
    Glide.with(this)
        .load(source)
        .apply(RequestOptions().centerCrop())
        .into(this)
}
