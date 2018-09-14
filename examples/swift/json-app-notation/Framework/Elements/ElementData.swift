//
//  ElementData.swift
//  json-app-notation
//
//  Created by Jason Nam on 23/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import Foundation

class ElementData: Decodable {

    let type: ElementType
    let data: Decoder

    enum CodingKeys: String, CodingKey {
        case type, data
    }

    required init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        let typeRawValue = try container.decode(String.self, forKey: .type)
        guard let type = ElementType(rawValue: typeRawValue) else {
            throw DecodingError.dataCorruptedError(forKey: .type, in: container, debugDescription: "Unsupported")
        }
        self.type = type
        data = try container.superDecoder(forKey: .data)
    }
}
