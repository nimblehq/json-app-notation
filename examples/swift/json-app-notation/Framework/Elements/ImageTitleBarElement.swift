//
//  ImageTitleBarElement.swift
//  json-app-notation
//
//  Created by Jason Nam on 23/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import Foundation

class ImageTitleBarElement: TitleBarElement, Decodable {

    let elementId: String
    let image: ImageElement

    enum CodingKeys: String, CodingKey {
        case elementId, image
    }

    required init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        elementId = try container.decode(String.self, forKey: .elementId)
        let elementData = try container.decode(ElementData.self, forKey: .image)
        guard let image = try ElementParser().parseElement(from: elementData) as? ImageElement else {
            throw DecodingError.dataCorruptedError(forKey: .image, in: container, debugDescription: "Wrong Type")
        }
        self.image = image
    }
}
