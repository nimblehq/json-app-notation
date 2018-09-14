//
//  ElementParser.swift
//  json-app-notation
//
//  Created by Jason Nam on 23/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import Foundation

class ElementParser {

    func parseElement(from elementData: ElementData) throws -> Element {
        switch elementData.type {
        case .image:
            return try ImageElement(from: elementData.data)
        case .label:
            return try LabelElement(from: elementData.data)
        case .textButton:
            return try TextButtonElement(from: elementData.data)
        case .imageButton:
            return try ImageButtonElement(from: elementData.data)
        case .list:
            return try ListElement(from: elementData.data)
        case .container:
            return try ContainerElement(from: elementData.data)
        case .textTitleBar:
            return try TextTitleBarElement(from: elementData.data)
        case .imageTitleBar:
            return try ImageTitleBarElement(from: elementData.data)
        case .screen:
            return try ScreenElement(from: elementData.data)
        case .navigation:
            return try NavigationElement(from: elementData.data)
        }
    }
}
