import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import viewModels.events.EventViewModel
import viewModels.events.Events


@Composable
fun EventsList(
    eventsViewModel: EventViewModel
) {
    val eventState by eventsViewModel.eventState.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (event in eventState.eventList) {
            EventBox(event)
            Divider()
        }
    }
}
@Composable
fun EventBox(event : Events) {
    Box(
        modifier = Modifier
            .border(border = BorderStroke(1.dp, Color.White))
            .fillMaxWidth()
            .padding(10.dp)
            .background(Color.Green),
        ) {
        Row {

            // Image
            AsyncImage(model = event.posterImage,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp))
            Box(modifier = Modifier
                .width(100.dp)
                .height(100.dp)) {
                Column {

                }
            }
            //
            Column {
                Text(event.title,
                    modifier = Modifier.width(220.dp),
                    maxLines = 1
                )
                Row {
                    Column {
                        Text(event.location)
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
}
