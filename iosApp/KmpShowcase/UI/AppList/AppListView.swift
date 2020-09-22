import SwiftUI
import FetchImage
import shared

struct AppListView: View {
	@StateObject private var viewModel = AppListViewModelWrapper()

	var body: some View {
		NavigationView {
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
					VStack(alignment: .leading, spacing: 8) {
						if let urlStr = app.bannerUrl,
						   let url = URL(string: urlStr) {
							ImageView(
								image: FetchImage(url: url),
								maxWidth: 300)
								.frame(height: 150)
								.clipped()
								.padding(.horizontal)
						}

						Text(app.name)
							.font(.title2)
							.fontWeight(.semibold)
							.padding(.horizontal)
						Text(app.summary)
							.foregroundColor(.secondary)
							.font(.body)
							.padding(.horizontal)

						makeLinksButtons(using: app.links)
					}
					.listRowInsets(EdgeInsets())
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
				HStack(spacing: 8) {
					links.appStore.map { link in
						Button(action: {
							didClickOn(link)
						}) {
							Label("App Store", image: "appstore")
						}
					}
					links.googlePlay.map { link in
						Button(action: {
							didClickOn(link)
						}) {
							Label("Google Play", systemImage: "g.circle")
						}
					}
					links.website.map { link in
						Button(action: {
							didClickOn(link)
						}) {
							Label("Website", systemImage: "globe")
						}
					}
				}
				.padding([.horizontal, .top])
				.buttonStyle(ChipButtonStyle())
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
		AppListView()
	}
}
