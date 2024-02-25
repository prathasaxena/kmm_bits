package utils

import data.viewModel.AuthViewModel
import di.getSharedModules
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(getSharedModules())
    }
}
class KoinHelper : KoinComponent {
    fun getAuthViewModel() = get<AuthViewModel>()
}