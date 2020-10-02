package me.moallemi.kmpshowcase.util

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun <T> Fragment.collect(
    item: StateFlow<T>,
    block: (T) -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        item.collect {
            block(it)
        }
    }
}