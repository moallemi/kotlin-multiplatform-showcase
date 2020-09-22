//
//  ImageView.swift
//  KmpShowcase
//
//  Created by Saeed Taheri on 9/21/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI
import FetchImage

public struct ImageView: View {
	@ObservedObject var image: FetchImage

	public var body: some View {
		ZStack {
			Rectangle()
				.fill(Color(.systemFill))
				.cornerRadius(12.0)
			image.view?
				.resizable()
				.aspectRatio(contentMode: .fit)
				.padding()
		}
		.animation(.default)
		.onAppear {
			image.priority = .normal
			image.fetch()
		}
		.onDisappear {
			image.priority = .low
		}
	}
}
