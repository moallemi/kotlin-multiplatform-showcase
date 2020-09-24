import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.moallemi.kmpshowcase.shared.domain.model.App
import me.moallemi.kmpshowcase.shared.presentation.AppListViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject
import react.RProps
import react.dom.h1
import react.dom.li
import react.dom.ul
import react.functionalComponent
import react.useEffect
import react.useState

class Application : KoinComponent {

    private val appListViewModel: AppListViewModel by inject()

    private val scope = MainScope()

    fun createRootComponent() = functionalComponent<RProps> { _ ->

        val (apps, setApps) = useState(appListViewModel.apps.value)
        appListViewModel.load()
        useEffect(dependencies = listOf()) {
            appListViewModel.apps.onEach { setApps(it) }.launchIn(scope)
        }

        h1 {
            +"KMM Apps"
        }
        ul {
            apps.sortedByDescending(App::id).forEach { item ->
                li {
                    key = item.toString()
                    +"[${item.name}] ${item.summary} "
                }
            }
        }
    }

}