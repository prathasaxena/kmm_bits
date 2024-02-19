package components.navigation

import dev.icerock.moko.resources.StringResource

sealed class NavigationActions {
    data class onTabChange(val title: StringResource) : NavigationActions()
}