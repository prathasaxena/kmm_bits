package components.navigation.ui


import EventsList
import Messages
import Profile
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import components.connections.Connections
import components.createEvent.CreateEvent
import components.events.EventDetails
import dev.icerock.moko.resources.StringResource
import org.pratha.bits.MR
import viewModels.events.EventViewModel


sealed class NavigationItem(var route: String, var icon: ImageVector?, var title: StringResource) {

    object CreateEvent : NavigationItem("createEvent", Icons.Rounded.Add, title = MR.strings.bottom_tab_create_events)

    object Event : NavigationItem("event", Icons.Rounded.DateRange, title = MR.strings.bottom_tab_events)

    object Connections : NavigationItem("connections", Icons.Rounded.Search, title = MR.strings.bottom_tab_connections)
    object Messages : NavigationItem("messages", Icons.Rounded.Email, title = MR.strings.bottom_tab_create_messages)
    object Profile: NavigationItem("profile", Icons.Rounded.Person, title = MR.strings.bottom_tab_create_profile)

}

sealed class NavigationView(var route: String) {
    object EventDetails : NavigationView("eventDetails")
}

@Composable
fun Navigations(navController: NavHostController) {
    val eventViewModel = EventViewModel()
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Event.route) {
        composable(NavigationItem.CreateEvent.route) {
            CreateEvent()
        }
        composable(NavigationItem.Event.route) {
            EventsList(eventViewModel)
        }
        composable(NavigationItem.Connections.route) {
            Connections()
        }

        composable(NavigationItem.Messages.route) {
            Messages()
        }
        composable(NavigationItem.Profile.route) {
            Profile()
        }
        composable(NavigationView.EventDetails.route) {
            EventDetails()
        }
    }

}