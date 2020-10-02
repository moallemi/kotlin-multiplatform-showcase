package me.moallemi.kmpshowcase.ui.home

interface OnAppItemClickListener {

    fun onGooglePlayLinkClicked(url: String?)

    fun onAppStoreLinkClicked(url: String?)

    fun onWebsiteLinkClicked(url: String?)
}