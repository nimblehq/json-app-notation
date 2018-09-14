//
//  ContainerView.swift
//  json-app-notation
//
//  Created by Jason Nam on 24/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import UIKit

class ContainerView: UIStackView, ElementApplicable {

    func apply(_ element: ContainerElement) {
        axis = .vertical
        distribution = .equalSpacing
        let viewFactory = ViewFactory()
        for childElement in element.elements {
            if let labelElement = childElement as? LabelElement {
                addArrangedSubview(viewFactory.view(forElement: labelElement))
            } else if let imageElement = childElement as? ImageElement {
                addArrangedSubview(viewFactory.view(forElement: imageElement))
            } else if let textButtonElement = childElement as? TextButtonElement {
                addArrangedSubview(viewFactory.view(forElement: textButtonElement))
            } else if let imageButtonElement = childElement as? ImageButtonElement {
                addArrangedSubview(viewFactory.view(forElement: imageButtonElement))
            } else if let containerElement = childElement as? ContainerElement {
                addArrangedSubview(viewFactory.view(forElement: containerElement))
            }
        }
    }
}
