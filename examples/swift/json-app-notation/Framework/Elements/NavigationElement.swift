//
//  NavigationElement.swift
//  json-app-notation
//
//  Created by Jason Nam on 24/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import Foundation

class NavigationElement: Element, Decodable {

    let elementId: String
    let initialScreenId: String
    let screens: [ScreenElement]

    enum CodingKeys: String, CodingKey {
        case elementId, initialScreenId, screens
    }

    required init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        elementId = try container.decode(String.self, forKey: .elementId)
        initialScreenId = try container.decode(String.self, forKey: .initialScreenId)
        screens = try (try container.decode([ElementData].self, forKey: .screens)).map {
            try ScreenElement(from: $0.data)
        }
    }
}
