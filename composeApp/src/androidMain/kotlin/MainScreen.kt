
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import org.koin.androidx.compose.koinViewModel
import components.navigation.NavigationViewModel
import components.navigation.ui.TopAppBarTitle
import components.navigation.ui.BottomTabBarNavigation
import components.navigation.ui.Navigations
import data.viewModel.AuthViewModel
import org.koin.androidx.compose.viewModel
import org.pratha.bits.MR


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val navigationViewModel = NavigationViewModel()
    val authViewModel = AuthViewModel()
    println("erewrwerewr ${authViewModel.isLoggedIn.collectAsState()}")
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
                    authViewModel = authViewModel
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

