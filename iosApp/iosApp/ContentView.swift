import SwiftUI
import MultiPlatformLibrary


struct ContentView: View {
    
    init() {
        KoinHelperKt.doInitKoin()
    }
    
    var body: some View {
        Navigation()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()

    }
}
