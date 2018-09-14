//
//  TextButtonView.swift
//  json-app-notation
//
//  Created by Jason Nam on 24/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import UIKit

class TextButtonView: UIButton, ElementApplicable {

    func apply(_ element: TextButtonElement) {
        setTitle(element.text, for: .normal)
    }
}
