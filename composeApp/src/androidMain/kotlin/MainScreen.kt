
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import components.common.stringResource


@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomAppBar {
                BottomTabBarNavigation(navController)
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(
            top = innerPadding.calculateTopPadding(),
            bottom = innerPadding.calculateBottomPadding()
        )) {
            Navigations(navController)
        }
    }
}

@Composable
fun BottomTabBarNavigation(navController: NavHostController) {
    BottomNavigation {
        val navCurrentEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navCurrentEntry?.destination?.route
        val listOfBottomNavigator = listOf(
            NavigationItem.CreateEvent,
            NavigationItem.Event,
            NavigationItem.Messages,
            NavigationItem.Profile
        )
        listOfBottomNavigator.forEach {
            BottomNavigationItem(
                selected = currentRoute == it.route,
                onClick = {
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = { it.icon?.let { it1 -> Icon(it1, contentDescription = null) } } ,
                label = { it.title?.let { it1 -> Text(stringResource(id = it1)) } }
            )
        }
    }
}