import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.pratha.bits.MR
import viewModels.events.EventViewModel
import viewModels.events.Events


@Composable
fun EventsList(
    eventsViewModel: EventViewModel
) {
    val eventState by eventsViewModel.eventState.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        for (event in eventState.eventList) {
            EventBox(event)
        }
    }
}


@Composable
fun EventBox(event : Events) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
        ) {
        Row {

            // Image
            AsyncImage(model = event.posterImage,
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp))
            //
            Column(
                modifier = Modifier.padding(start = 5.dp)
            ) {
                Text(event.time,
                    modifier = Modifier.width(220.dp),
                    maxLines = 1,
                    color = Color(MR.colors.textColor.getColor(LocalContext.current))
                )
                Text(event.title,
                    modifier = Modifier.width(220.dp),
                    color = Color(MR.colors.textColor.getColor(LocalContext.current))
                )

            }

        }
    }
}
