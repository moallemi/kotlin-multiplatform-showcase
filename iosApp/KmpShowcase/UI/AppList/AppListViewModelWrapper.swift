//
//  AppListViewModelWrapper.swift
//  KmpShowcase
//
//  Created by Saeed Taheri on 9/20/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import Combine
import shared

final class AppListViewModelWrapper: ObservableObject {

	@Published private(set) var apps = [App]()

	private let viewModel: AppListViewModel

	init() {
		viewModel = koin.get(objCClass: AppListViewModel.self, qualifier: nil) as! AppListViewModel
		viewModel.apps.collect(collector: self) { _, _ in }
	}

	func load() {
		viewModel.load()
	}
}

extension AppListViewModelWrapper: Kotlinx_coroutines_coreFlowCollector {
	public func emit(value: Any?, completionHandler: @escaping (KotlinUnit?, Error?) -> Void) {
		defer {
			completionHandler(nil, nil)
		}

		guard let items = value as? [App] else {
			return
		}

		apps = items
	}
}

extension App: Swift.Identifiable {
}
