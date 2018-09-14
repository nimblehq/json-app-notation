//
//  ImageButtonView.swift
//  json-app-notation
//
//  Created by Jason Nam on 24/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import UIKit
import AlamofireImage

class ImageButtonView: UIButton, ElementApplicable {

    func apply(_ element: ImageButtonElement) {
        af_setImage(for: .normal, url: element.source)
    }
}
