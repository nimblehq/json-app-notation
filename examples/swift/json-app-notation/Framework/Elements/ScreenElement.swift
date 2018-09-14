//
//  ScreenElement.swift
//  json-app-notation
//
//  Created by Jason Nam on 23/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import Foundation

class ScreenElement: Element, Decodable {

    let elementId: String
    let title: TitleBarElement?
    let body: ContainerElement

    enum CodingKeys: String, CodingKey {
        case elementId, title, body
    }

    required init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        elementId = try container.decode(String.self, forKey: .elementId)
        let elementParser = ElementParser()
        if let titleBarElementData = try container.decodeIfPresent(ElementData.self, forKey: .title) {
            guard let titleBar = try elementParser.parseElement(from: titleBarElementData) as? TitleBarElement else {
                throw DecodingError.dataCorruptedError(forKey: .title, in: container, debugDescription: "Wrong Type")
            }
            self.title = titleBar
        } else {
            title = nil
        }
        let bodyElementData = try container.decode(ElementData.self, forKey: .body)
        guard let body = try elementParser.parseElement(from: bodyElementData) as? ContainerElement else {
            throw DecodingError.dataCorruptedError(forKey: .body, in: container, debugDescription: "Wrong Type")
        }
        self.body = body
    }
}
