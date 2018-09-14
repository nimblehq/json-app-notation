//
//  ScreenFactory.swift
//  json-app-notation
//
//  Created by Jason Nam on 24/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import UIKit

class ScreenFactory {

    func screen(forElement screenElement: ScreenElement) -> UIViewController {
        let screenView = ScreenView()
        screenView.apply(screenElement)
        if screenElement.title == nil {
            return screenView
        } else {
            return UINavigationController(rootViewController: screenView)
        }
    }
}
