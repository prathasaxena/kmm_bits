//
//  Login+Wrapper.swift
//  iosApp
//
//  Created by Pratha Saxena on 26/03/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import Shared

extension Login {
    @MainActor
    class LoginViewModelWrapper : ObservableObject {
        let loginViewModel : LoginViewModel
        @Published var loginState : LoginState
        
        init() {
            loginViewModel = LoginViewModel()
            loginState = loginViewModel.loginState.value
        }
        
        func startObserving() {
            Task {
                for await state in loginViewModel.loginState {
                    self.loginState = state
                }
            }
        }
    }
}
