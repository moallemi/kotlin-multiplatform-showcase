package me.moallemi.kmpshowcase.shared.presentation

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

actual abstract class BaseViewModel actual constructor(
    viewModelContext: CoroutineContext
) : CoroutineScope {
    actual override val coroutineContext: CoroutineContext = viewModelContext
}