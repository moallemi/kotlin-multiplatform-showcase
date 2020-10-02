package me.moallemi.kmpshowcase.ui.home

import android.view.View
import me.moallemi.kmpshowcase.R
import me.moallemi.kmpshowcase.databinding.ItemAppItemBinding
import me.moallemi.kmpshowcase.shared.domain.model.App
import me.moallemi.kmpshowcase.ui.base.adapter.IdentifiableAdapter
import me.moallemi.kmpshowcase.util.load

class AppsListAdapter(
    private val onAppItemClickListener: OnAppItemClickListener
) : IdentifiableAdapter<App, ItemAppItemBinding>(R.layout.item_app_item) {

    override fun onBindData(itemView: View, model: App, position: Int) {
        with(ItemAppItemBinding.bind(itemView)) {
            title.text = model.name
            summary.text = model.summary
            banner.load(model.bannerUrl)

            googlePlay.setOnClickListener {
                onAppItemClickListener.onGooglePlayLinkClicked(model.links?.googlePlay)
            }
            appStore.setOnClickListener {
                onAppItemClickListener.onAppStoreLinkClicked(model.links?.appStore)
            }
            website.setOnClickListener {
                onAppItemClickListener.onWebsiteLinkClicked(model.links?.website)
            }
        }
    }
}