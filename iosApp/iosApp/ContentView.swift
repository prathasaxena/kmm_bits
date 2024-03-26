import SwiftUI
import Shared

struct ContentView: View {
    @State private var showContent = false
    @StateObject var loginViewModel = Login.LoginViewModelWrapper()
    var body: some View {
        Navigation()
            .environmentObject(loginViewModel)
          
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()

    }
}
