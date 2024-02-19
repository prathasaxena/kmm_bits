package components.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class AuthenticationViewModel : ViewModel() {
    var authenticationState by mutableStateOf(AuthenticationState(isLoggedIn = false, isOrganiser = false))
        private set


}