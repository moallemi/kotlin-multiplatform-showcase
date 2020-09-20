package me.moallemi.kmpshowcase.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(urlStr: String?) {
    Glide.with(this)
        .load(urlStr)
        .into(this)
}