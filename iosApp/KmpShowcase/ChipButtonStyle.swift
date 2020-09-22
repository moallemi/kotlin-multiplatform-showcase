//
//  ChipButtonStyle.swift
//  KmpShowcase
//
//  Created by Saeed Taheri on 9/21/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI

struct ChipButtonStyle: ButtonStyle {
	func makeBody(configuration: Self.Configuration) -> some View {
		configuration.label
			.padding(.vertical, 8)
			.padding(.horizontal)
			.background(Color.accentColor)
			.foregroundColor(Color(.systemBackground))
			.clipShape(Capsule())
			.scaleEffect(configuration.isPressed ? 0.95 : 1)
	}
}
