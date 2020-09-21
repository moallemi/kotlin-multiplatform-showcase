import SwiftUI
import shared

struct ContentView: View {
	@StateObject private var viewModel = AppListViewModelWrapper()

    var body: some View {
		NavigationView {
			List(viewModel.apps) { app in
				VStack(alignment: .leading, spacing: 8) {
					Text(app.name)
						.font(.title2)
						.fontWeight(.semibold)
					Text(app.summary)
						.font(.body)

					makeLinksButtons(using: app.links)
				}
				.padding(.vertical)
			}
			.listStyle(InsetGroupedListStyle())
			.navigationBarTitle("KMP Showcase")
			.onAppear {
				viewModel.load()
			}
		}
		.navigationViewStyle(StackNavigationViewStyle())
    }

	@ViewBuilder
	private func makeLinksButtons(using links: Links?) -> some View {
		if let links = links {
			ScrollView(.horizontal, showsIndicators: false) {
				HStack {
					links.appStore.map { link in
						Button("App Store") {
							didClickOn(link)
						}
					}
					links.googlePlay.map { link in
						Button("Google Play") {
							didClickOn(link)
						}
					}
					links.website.map { link in
						Button("Website") {
							didClickOn(link)
						}
					}
				}
			}
		} else {
			EmptyView()
		}
	}

	private func didClickOn(_ link: String) {
		guard let url = URL(string: link) else {
			return
		}
		UIApplication.shared.open(url, options: [:], completionHandler: nil)
	}
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
