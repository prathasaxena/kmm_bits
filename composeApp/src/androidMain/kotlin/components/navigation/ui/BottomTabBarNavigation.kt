package components.navigation.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import components.auth.AuthenticationViewModel
import components.common.stringResource
import components.navigation.NavigationActions
import components.navigation.NavigationViewModel
import org.pratha.bits.MR

@Composable
fun BottomTabBarNavigation(
    navController: NavHostController,
    // add KOIN
    navigationViewModel: NavigationViewModel = NavigationViewModel(),
    authViewModel : AuthenticationViewModel = AuthenticationViewModel()
   ) {
    NavigationBar(
        containerColor =  Color(MR.colors.themedBottomTab.getColor(LocalContext.current)),
        contentColor = Color(MR.colors.textColor.getColor(LocalContext.current)),
        tonalElevation = 0.dp
    ) {
        val navCurrentEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navCurrentEntry?.destination?.route
        val listOfBottomNavigator = mutableListOf(
            NavigationItem.CreateEvent,
            NavigationItem.Event,
            NavigationItem.Connections,
            NavigationItem.Messages,
            NavigationItem.Profile
        )

        if (authViewModel.authenticationState.isOrganiser) {
            listOfBottomNavigator.removeAt(2)
        } else {
            listOfBottomNavigator.removeAt(0)
        }

        listOfBottomNavigator.forEach {
            NavigationBarItem(
                selected = currentRoute == it.route,
                onClick = {
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                        navigationViewModel.onEventAction(NavigationActions.onTabChange(title = it.title))
                    }
                },
                icon = { it.icon?.let { it1 -> Icon(it1, contentDescription = null) } } ,
                label = { it.title?.let { it1 -> Text(stringResource(id = it1)) } }
            )
        }
    }
}