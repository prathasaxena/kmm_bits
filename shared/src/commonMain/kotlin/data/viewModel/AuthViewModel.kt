package data.viewModel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _isLoggedIn : MutableStateFlow<Boolean> = MutableStateFlow(value = false)
    val isLoggedIn = _isLoggedIn.asStateFlow()

     fun getIsLoggedIn() {
        viewModelScope.launch {
            _isLoggedIn.value = false
        }
    }
}