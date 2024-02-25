package di

import data.viewModel.AuthViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get

actual fun getViewModelByPlatform() = module {
  viewModel {
      AuthViewModel()
  }
}

