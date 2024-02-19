import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        MainScreen(navController = navController)
    }
}

@Preview
@Composable
fun preview_App() {
    App()
}