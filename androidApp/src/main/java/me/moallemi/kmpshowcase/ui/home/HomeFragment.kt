package me.moallemi.kmpshowcase.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.moallemi.kmpshowcase.R
import me.moallemi.kmpshowcase.databinding.FragmentHomeBinding
import me.moallemi.kmpshowcase.shared.presentation.AppListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

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
            }
        }

        appListViewModel.load()

    }

    override fun onDestroy() {
        fragmentBinding = null
        super.onDestroy()
    }
}