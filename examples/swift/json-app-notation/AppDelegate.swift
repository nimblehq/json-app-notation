//
//  AppDelegate.swift
//  json-app-notation
//
//  Created by Jason Nam on 14/9/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?

    func application(_ application: UIApplication,
                     didFinishLaunchingWithOptions launchOptions: [UIApplicationLaunchOptionsKey: Any]?) -> Bool {
        let data = try! Data(contentsOf: Bundle.main.url(forResource: "screen", withExtension: "json")!)
        window = UIWindow(frame: UIScreen.main.bounds)
        window?.rootViewController = try! JSONAppNotation.screen(forData: data)
        window?.makeKeyAndVisible()
        return true
    }
}
