
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import components.navigation.NavigationViewModel
import components.navigation.ui.TopAppBarTitle
import components.navigation.ui.BottomTabBarNavigation
import components.navigation.ui.Navigations
import org.pratha.bits.MR
import viewModels.login.LoginViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val navigationViewModel = NavigationViewModel()
    val authenticationViewModel = LoginViewModel()
    Scaffold(
        topBar = {
                 TopAppBar(title = {
                     TopAppBarTitle(navigationViewModel = navigationViewModel)
                 })
        },
        bottomBar = {
            BottomAppBar {
                BottomTabBarNavigation(navController,
                    navigationViewModel = navigationViewModel,
                    authViewModel = authenticationViewModel
                )
            }
        },
        containerColor = Color(MR.colors.screenBackgroundColor.getColor(LocalContext.current))

    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(
            top = innerPadding.calculateTopPadding(),
            bottom = innerPadding.calculateBottomPadding()
        )) {
            Navigations(navController)
        }
    }
}

