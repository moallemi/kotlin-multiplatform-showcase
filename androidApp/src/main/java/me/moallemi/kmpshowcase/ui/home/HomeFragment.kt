package me.moallemi.kmpshowcase.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import com.google.android.material.appbar.AppBarLayout
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.moallemi.kmpshowcase.R
import me.moallemi.kmpshowcase.databinding.FragmentHomeBinding
import me.moallemi.kmpshowcase.shared.presentation.AppListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs

class HomeFragment : Fragment(R.layout.fragment_home) {

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

        viewLifecycleOwner.lifecycleScope.launch {
            appListViewModel.apps.collect { items ->
                val appsAdapter = AppsListAdapter().apply {
                    this.submitList(items)
                }
                adapter.addAdapter(appsAdapter)

                if (items.isNotEmpty()) {
                    fragmentBinding?.progressBar?.isVisible = false
                }
            }
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
}