
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
    val navigationTabBgColor = Color(MR.colors.themedBottomTab.getColor(LocalContext.current))

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = navigationTabBgColor),
                title = {
                    // implement KOIN
                    TopAppBarTitle(
                        navigationViewModel = navigationViewModel,
                        loginViewModel = authenticationViewModel)
                },
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = navigationTabBgColor,

            ) {
                // implement KOIN
                BottomTabBarNavigation(navController,
                    navigationViewModel = navigationViewModel,
                    authViewModel = authenticationViewModel
                )
            }
        },
        containerColor = navigationTabBgColor
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(
            top = innerPadding.calculateTopPadding(),
            bottom = innerPadding.calculateBottomPadding()
        )
        ) {
            Navigations(navController)
        }
    }
}

