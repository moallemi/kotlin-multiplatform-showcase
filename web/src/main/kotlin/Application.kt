import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.moallemi.kmpshowcase.shared.presentation.AppListViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject

class Application : KoinComponent {

    private val appListViewModel: AppListViewModel by inject()

    fun load(result: (String) -> Unit) {
        GlobalScope.launch {
            appListViewModel.apps.collect {
                result(it.toString())
            }
        }
        appListViewModel.load()
    }

}