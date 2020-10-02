package me.moallemi.kmpshowcase.util

import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri

fun Context.openUrl(url: String?) {
    val intent = Intent(ACTION_VIEW, Uri.parse(url))
    startActivity(intent)
}