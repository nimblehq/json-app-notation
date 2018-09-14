//
//  ImageView.swift
//  json-app-notation
//
//  Created by Jason Nam on 24/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import UIKit
import AlamofireImage

class ImageView: UIImageView, ElementApplicable {

    func apply(_ element: ImageElement) {
        af_setImage(withURL: element.source)
    }
}
