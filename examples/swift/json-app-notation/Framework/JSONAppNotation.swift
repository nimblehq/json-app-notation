//
//  JSONAppNotation.swift
//  json-app-notation
//
//  Created by Jason Nam on 23/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import UIKit

class JSONAppNotation {

    static func screen(forData data: Data) throws -> UIViewController {
        let elementData = try JSONDecoder().decode(ElementData.self, from: data)
        let screen = try ScreenElement(from: elementData.data)
        return ScreenFactory().screen(forElement: screen)
    }
}
