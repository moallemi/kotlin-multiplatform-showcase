package me.moallemi.kmpshowcase.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import com.google.android.material.appbar.AppBarLayout
import me.moallemi.kmpshowcase.R
import me.moallemi.kmpshowcase.databinding.FragmentHomeBinding
import me.moallemi.kmpshowcase.shared.domain.model.App
import me.moallemi.kmpshowcase.shared.presentation.AppListViewModel
import me.moallemi.kmpshowcase.shared.presentation.AppListViewModelNavigation
import me.moallemi.kmpshowcase.shared.presentation.AppListViewModelNavigation.NavigateToUrl
import me.moallemi.kmpshowcase.util.collect
import me.moallemi.kmpshowcase.util.openUrl
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs

class HomeFragment : Fragment(R.layout.fragment_home), OnAppItemClickListener {

    private val appListViewModel: AppListViewModel by viewModel()

    private var fragmentBinding: FragmentHomeBinding? = null

    private val adapter = ConcatAdapter(
        ConcatAdapter.Config.Builder()
            .setIsolateViewTypes(true)
            .build()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBinding = FragmentHomeBinding.bind(view)
        fragmentBinding?.rootRecyclerView?.adapter = adapter

        appListViewModel.apply {
            collect(apps, ::collectApps)
            collect(navigation, ::collectNavigation)
        }

        appListViewModel.load()

        fragmentBinding?.appBarLayout?.addOnOffsetChangedListener(
            AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                val percentage = abs(verticalOffset).toFloat() / appBarLayout.totalScrollRange

                val textColor = ColorUtils.setAlphaComponent(
                    ContextCompat.getColor(requireContext(), R.color.onPrimaryColor),
                    (percentage * 255).toInt()
                )
                fragmentBinding?.toolbar?.setTitleTextColor(textColor)
            }
        )

    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }

    private fun collectApps(items: List<App>) {
        val appsAdapter = AppsListAdapter(this).apply {
            this.submitList(items)
        }
        adapter.addAdapter(appsAdapter)

        if (items.isNotEmpty()) {
            fragmentBinding?.progressBar?.isVisible = false
        }
    }

    private fun collectNavigation(navigation: AppListViewModelNavigation?) {
        if (navigation is NavigateToUrl) {
            context?.openUrl(navigation.url)
        }
    }

    override fun onGooglePlayLinkClicked(url: String?) {
        appListViewModel.onGooglePlayLinkClicked(url)
    }

    override fun onAppStoreLinkClicked(url: String?) {
        appListViewModel.onAppStoreLinkClicked(url)
    }

    override fun onWebsiteLinkClicked(url: String?) {
        appListViewModel.onWebsiteLinkClicked(url)
    }
}