//
//  ViewFactory.swift
//  json-app-notation
//
//  Created by Jason Nam on 24/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import UIKit

class ViewFactory {

    func view(forElement labelElement: LabelElement) -> LabelView {
        let label = LabelView()
        label.apply(labelElement)
        return label
    }

    func view(forElement imageElement: ImageElement) -> ImageView {
        let image = ImageView()
        image.apply(imageElement)
        return image
    }

    func view(forElement textButtonElement: TextButtonElement) -> TextButtonView {
        let textButtonView = TextButtonView(type: .system)
        textButtonView.apply(textButtonElement)
        return textButtonView
    }

    func view(forElement imageButtonElement: ImageButtonElement) -> ImageButtonView {
        let imageButtonView = ImageButtonView(type: .system)
        imageButtonView.apply(imageButtonElement)
        return imageButtonView
    }

    func view(forElement containerElement: ContainerElement) -> ContainerView {
        let containerView = ContainerView()
        containerView.apply(containerElement)
        return containerView
    }

    func view(forElement screenElement: ScreenElement) -> ScreenView {
        let screenView = ScreenView()
        screenView.apply(screenElement)
        return screenView
    }
}
