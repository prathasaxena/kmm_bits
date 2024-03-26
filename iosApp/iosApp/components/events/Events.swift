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


struct Events : View {
    @ObservedObject private(set) var viewModel : EventViewModelWrapper
    var body : some View {
        VStack {
            VStack {
                EventList(eventList: viewModel.eventState.eventList)
            }
            .padding(.vertical,10)
            Spacer()
        }.onAppear {
            self.viewModel.startObserving()
        }
    }
}

struct EventList : View {
    var eventList : [Shared.Events]
    var body: some View {
            List(eventList, id: \.self) { events in
                NavigationLink{
                    EventDetails()
                } label: {
                    EventListView(events: events)
                }
        }
    }
}

struct EventListView : View {
    var events : Shared.Events
    var body: some View {
        HStack(spacing: 10) {
            if #available(iOS 15.0, *) {
                AsyncImage(url: URL(string: events.posterImage),
                scale:4)
            } else {
                // Fallback on earlier versions
            }
            VStack(alignment: .leading) {
                Text(events.time)
                    .font(.caption2)
                Text(events.title)
                    .font(.subheadline)
              
            }
           
        }.listRowInsets(EdgeInsets())
    }
}

struct Events_previews : PreviewProvider {
    static var previews: some View {
        Events(viewModel: .init())

    }
}
