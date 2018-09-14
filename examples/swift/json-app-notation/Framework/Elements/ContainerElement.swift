//
//  ContainerElement.swift
//  json-app-notation
//
//  Created by Jason Nam on 23/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import Foundation

class ContainerElement: Element, Decodable {

    let elementId: String
    let elements: [Element]

    enum CodingKeys: String, CodingKey {
        case elementId, elements
    }

    required init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        elementId = try container.decode(String.self, forKey: .elementId)
        let elementParser = ElementParser()
        elements = try (try container.decode([ElementData].self, forKey: .elements)).map {
            try elementParser.parseElement(from: $0)
        }
    }
}
