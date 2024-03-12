package viewModels.login

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import utils.BaseViewModel
import viewModels.login.LoginState

class LoginViewModel : BaseViewModel() {
    private val _loginState : MutableStateFlow<LoginState> = MutableStateFlow(LoginState())
    val loginState : StateFlow<LoginState> = _loginState

    fun getLoginState() {
        scope.launch {
            _loginState.emit(LoginState())
        }
    }

}