import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import components.createEvent.CreateEvent
import dev.icerock.moko.resources.StringResource
import org.pratha.bits.MR


sealed class NavigationItem(var route: String, var icon: ImageVector?, var title: StringResource) {
    object Event : NavigationItem("Event", Icons.Rounded.AccountCircle, title = MR.strings.bottom_tab_events)
    object CreateEvent : NavigationItem("CreateEvent", Icons.Rounded.Add, title = MR.strings.bottom_tab_create_events)
    object Messages : NavigationItem("Messages", Icons.Rounded.Call, title = MR.strings.bottom_tab_create_messages)
    object Profile: NavigationItem("Profile", Icons.Rounded.Person, title = MR.strings.bottom_tab_create_profile)
}

@Composable
fun Navigations(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Event.route ) {
        composable(NavigationItem.Event.route) {
            Events()
        }
        composable(NavigationItem.CreateEvent.route) {
            CreateEvent()
        }
        composable(NavigationItem.Messages.route) {
            Messages()
        }
        composable(NavigationItem.Profile.route) {
            Profile()
        }
    }

}