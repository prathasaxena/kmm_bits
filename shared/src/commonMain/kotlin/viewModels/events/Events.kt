package viewModels.events

import kotlin.time.TimedValue

data class Events (
    val title : String,
    val location: String,
    val time : String,
    val guestSpeakers : List<String>,
    val details : String,
    val posterImage: String
)