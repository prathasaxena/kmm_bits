package components.auth

data class AuthenticationState (
    val isLoggedIn: Boolean,
    val isOrganiser: Boolean,
)