package viewModels.events

data class EventState (
    var eventList: List<Events> = emptyList(),
    var loading : Boolean = false
)