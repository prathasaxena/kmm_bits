//
//  Event+Wrapper.swift
//  iosApp
//
//  Created by Pratha Saxena on 14/03/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import Shared

extension Events {
    @MainActor
    class EventViewModelWrapper : ObservableObject {
        let eventsViewModel : EventViewModel
        @Published var eventState : EventState
        
        init() {
            eventsViewModel = EventViewModel()
            eventState = eventsViewModel.eventState.value
        }
        
        func startObserving() {
            Task {
                for await eventS in eventsViewModel.eventState {
                    self.eventState = eventS
                }
            }
        }
    }
}
