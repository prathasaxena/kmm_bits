package viewModels.events

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import utils.BaseViewModel


class EventViewModel : BaseViewModel() {
    private val _eventState : MutableStateFlow<EventState> = MutableStateFlow(EventState())
    val eventState : StateFlow<EventState> = _eventState
    private val mockEventList = listOf(
        Events(
            "International Conference on Sustainable Urban Water Management for Fast Growing Cities",
            "Hyderabad",
            "21st March",
            listOf("Prof. Rajiv Gupta", "Prof. Anurag Malik"),
            "This is a three-day conference organized in collaboration with the BITS Pilani, Plani Campus, Aligarh Muslim University (AMU), and Amrita University as part of the Department of Science and Technology (DST) India sponsored project titled, *Structured Dialogue for Sustainable Urban Water Management*. Gather with experts and visionaries at our\n" +
                    "conference, where well chart the course for sustainable\n" +
                    "urban, water management\n" +
                    "evolving\n" +
                    "landscapes of the Global South's bustling cities.",
            "https://www.edwiseinternational.com/Admin/university/BITS-Pilani-FZ-LLC.jpg"
        ),
        Events(
            "International Conference on Sustainable Urban Water Management for Fast Growing Cities",
            "Hyderabad",
            "21st March",
            listOf("Prof. Rajiv Gupta", "Prof. Anurag Malik"),
            "This is a three-day conference organized in collaboration with the BITS Pilani, Plani Campus, Aligarh Muslim University (AMU), and Amrita University as part of the Department of Science and Technology (DST) India sponsored project titled, *Structured Dialogue for Sustainable Urban Water Management*. Gather with experts and visionaries at our\n" +
                    "conference, where well chart the course for sustainable\n" +
                    "urban, water management\n" +
                    "evolving\n" +
                    "landscapes of the Global South's bustling cities.",
            "https://www.edwiseinternational.com/Admin/university/BITS-Pilani-FZ-LLC.jpg"
        ),
        Events(
            "International Conference on Sustainable Urban Water Management for Fast Growing Cities",
            "Hyderabad",
            "21st March",
            listOf("Prof. Rajiv Gupta", "Prof. Anurag Malik"),
            "This is a three-day conference organized in collaboration with the BITS Pilani, Plani Campus, Aligarh Muslim University (AMU), and Amrita University as part of the Department of Science and Technology (DST) India sponsored project titled, *Structured Dialogue for Sustainable Urban Water Management*. Gather with experts and visionaries at our\n" +
                    "conference, where well chart the course for sustainable\n" +
                    "urban, water management\n" +
                    "evolving\n" +
                    "landscapes of the Global South's bustling cities.",
            "https://www.edwiseinternational.com/Admin/university/BITS-Pilani-FZ-LLC.jpg"
        )
    )

    init {
        getEventState()
    }
    private fun getEventState() {
        scope.launch {
            _eventState.emit(EventState(eventList = mockEventList, loading = false))
        }
    }




}