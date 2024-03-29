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
    @EnvironmentObject var viewModel : Login.LoginViewModelWrapper
    
//    init() {
//        UITabBar.appearance().backgroundColor =  MR.colors().themedBottomTab.getUIColor()
//    }
    
    var body: some View {
        NavigationView {
            TabView {
                if(viewModel.loginState.isOrganiser) {
                    CreateEvent()
                        .tabItem {
                        Label(
                            Strings().get(id: MR.strings().bottom_tab_create_events, args: [])
                            , systemImage: "pencil.circle")
                    }
                } else {
                    Connections()
                        .tabItem {
                            Label(Strings().get(id: MR.strings().bottom_tab_connections, args: []), systemImage: "person.crop.circle.fill.badge.plus" )
                        }
                }
                Events(viewModel: .init()).tabItem {
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
            .navigationBarTitleDisplayMode(.inline)
            .navigationBarTitle(Strings().get(id: MR.strings().bottom_tab_create_events, args: []))
            .toolbar(content: {
                if(!viewModel.loginState.isLoggedIn) {
                    Text(Strings().get(id: MR.strings().login, args: []))
                        .underline()
                }
            })
        }
    }
}


struct Navigation_Previews: PreviewProvider {
    static var previews: some View {
        Navigation()
    }
}


