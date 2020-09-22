//
//  AppRowView.swift
//  KmpShowcase
//
//  Created by Saeed Taheri on 9/22/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI
import FetchImage
import shared

struct AppRowView: View {
	let app: shared.App

	var body: some View {
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
							Label("app_store", image: "appstore")
						}
					}
					links.googlePlay.map { link in
						Button(action: {
							didClickOn(link)
						}) {
							Label("google_play", systemImage: "g.circle")
						}
					}
					links.website.map { link in
						Button(action: {
							didClickOn(link)
						}) {
							Label("website", systemImage: "globe")
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

struct AppRowView_Previews: PreviewProvider {
    static var previews: some View {
		AppRowView(
			app: shared.App(
				id: UUID().uuidString,
				name: "Golchin",
				summary: "Golchin is the best app possible",
				links: Links(appStore: "",
							 googlePlay: "",
							 website: ""),
				bannerUrl: "")
		)
    }
}
