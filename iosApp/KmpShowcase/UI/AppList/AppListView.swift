import SwiftUI

struct AppListView: View {
	@StateObject private var viewModel = AppListViewModelWrapper()

	var body: some View {
		NavigationView {
			if viewModel.apps.isEmpty {
				ProgressView("Loading…")
			} else {
				List {
					Image("kmp-artwork")
						.resizable()
						.aspectRatio(contentMode: .fit)
						.padding()
						.frame(height: 200)
						.frame(maxWidth: .infinity)
						.background(Color.accentColor)
						.listRowInsets(EdgeInsets())
					ForEach(viewModel.apps) { app in
						AppRowView(app: app)
							.listRowInsets(EdgeInsets())
					}
					.padding(.vertical)
				}
				.listStyle(InsetGroupedListStyle())
				.navigationBarTitle("KMP Showcase")
			}
		}
		.onAppear(perform: viewModel.load)
		.navigationViewStyle(StackNavigationViewStyle())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		AppListView()
	}
}
