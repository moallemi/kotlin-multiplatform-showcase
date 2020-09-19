package me.moallemi.kmmshowcase.shared.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

internal actual val applicationDispatcher: CoroutineContext = Dispatchers.IO