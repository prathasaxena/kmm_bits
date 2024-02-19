import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun Events() {
    Column {
        Box(modifier = Modifier.border(border = BorderStroke(1.dp, Color.White))) {
            Row {
                Column {
                    Text("DAY 1 : Meet your seniors")
                    Text("Ahemdabad")
                    Text("Guests")
                    Text(text = "John Doe")
                    Text(text = "Jack Smith")
                }
                Column {
                    Text("Time")
                    Text("Programs : 3")
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Check Details")
                    }
                }
            }
        }
    }
}

