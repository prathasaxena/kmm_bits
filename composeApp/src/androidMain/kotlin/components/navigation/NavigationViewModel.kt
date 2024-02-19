package components.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import components.common.stringResource
import org.pratha.bits.MR

class NavigationViewModel : ViewModel() {
  var navigationState by mutableStateOf(NavigationState(topBarTitle =  MR.strings.bottom_tab_events))
      private set


   fun onEventAction (actions: NavigationActions) {
       when(actions) {
           is NavigationActions.onTabChange -> {
                navigationState = navigationState.copy(
                    topBarTitle = actions.title
                )
           }
       }

   }

}