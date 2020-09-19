package me.moallemi.kmmshowcase.shared.presentation

import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import me.moallemi.kmmshowcase.shared.utils.log
import kotlin.coroutines.CoroutineContext

actual abstract class BaseViewModel actual constructor(
    viewModelContext: CoroutineContext,
) : CoroutineScope {

    private val context: CoroutineContext = viewModelContext

    private var _job: CompletableJob? = null
    private val job: CompletableJob
        get() {
            if (_job == null) {
                _job = Job()
            }
            return _job ?: Job()
        }

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        log(throwable.message)
    }

    actual override val coroutineContext: CoroutineContext
        get() = context + job + exceptionHandler
}