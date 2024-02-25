package di

import data.viewModel.AuthViewModel
import org.koin.dsl.module

actual fun getViewModelByPlatform() = module {
    single {
        AuthViewModel()
    }
}