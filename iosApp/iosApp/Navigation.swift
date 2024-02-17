//
//  Navigation.swift
//  iosApp
//
//  Created by Pratha Saxena on 12/02/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import Shared


struct Navigation : View {
    var body: some View {
        TabView {
            CreateEvent().tabItem {
                Label(
                    Strings().get(id: MR.strings().bottom_tab_create_events, args: [])
                    , systemImage: "pencil.circle")
            }
            Events().tabItem {
                Label(Strings().get(id: MR.strings().bottom_tab_events, args: []),
                      systemImage: "calendar.circle")
            }
            Messages().tabItem {
                Label( Strings().get(id: MR.strings().bottom_tab_create_messages, args: [])
                      , systemImage: "message.circle")
            }
            Profile().tabItem {
                Label(Strings().get(id: MR.strings().bottom_tab_create_profile, args: []),
                      systemImage: "person")
            }
        }.background(Color.blue)
        
    }
}


struct Navigation_Previews: PreviewProvider {
    static var previews: some View {
        Navigation()
    }
}


