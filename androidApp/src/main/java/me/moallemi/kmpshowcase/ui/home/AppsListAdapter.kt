package me.moallemi.kmpshowcase.ui.home

import android.view.View
import me.moallemi.kmpshowcase.R
import me.moallemi.kmpshowcase.databinding.ItemAppItemBinding
import me.moallemi.kmpshowcase.shared.domain.model.App
import me.moallemi.kmpshowcase.ui.base.adapter.IdentifiableAdapter
import me.moallemi.kmpshowcase.util.load

class AppsListAdapter : IdentifiableAdapter<App, ItemAppItemBinding>(R.layout.item_app_item) {

    override fun onBindData(itemView: View, model: App, position: Int) {
        val binding = ItemAppItemBinding.bind(itemView)
        with(binding) {
            title.text = model.name
            summary.text = model.summary
            banner.load(model.bannerUrl)
        }
    }
}