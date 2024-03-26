import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        Surface(
            modifier = Modifier.background(Color.Black)
        ) {
            MainScreen(navController = navController)
        }
    }
}

@Preview
@Composable
fun preview_App() {
    App()
}