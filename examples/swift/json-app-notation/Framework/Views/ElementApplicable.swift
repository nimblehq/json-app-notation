//
//  ElementApplicable.swift
//  json-app-notation
//
//  Created by Jason Nam on 13/9/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import Foundation

protocol ElementApplicable {

    associatedtype T: Element

    func apply(_ element: T)
}
