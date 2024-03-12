//
//  Events.swift
//  iosApp
//
//  Created by Pratha Saxena on 12/02/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
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

struct Events : View {
    @ObservedObject private(set) var viewModel : EventViewModelWrapper
    var body : some View {
        VStack {
            VStack {
                ForEach(viewModel.eventState.eventList, id: \.self) { events in
                    HStack {
                        VStack {
                            Text(events.title)
                            VStack {
                                
                            }
                        }
                    }
                }
      
            }
        }.onAppear {
            self.viewModel.startObserving()
        }
    }
}


//struct Events_previews : PreviewProvider {
//    static var previews: some View {
//        Events()
//
//    }
//}
