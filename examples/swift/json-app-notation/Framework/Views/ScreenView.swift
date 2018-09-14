//
//  ScreenView.swift
//  json-app-notation
//
//  Created by Jason Nam on 24/8/18.
//  Copyright © 2018 json-app-notation. All rights reserved.
//

import UIKit
import SnapKit

class ScreenView: UIViewController, ElementApplicable {

    override func viewDidLoad() {
        super.viewDidLoad()
        view.backgroundColor = .white
    }

    func apply(_ element: ScreenElement) {
        let viewFactory = ViewFactory()
        if let textTitleBarElement = element.title as? TextTitleBarElement {
            title = textTitleBarElement.text
        } else if let imageTitleBarElement = element.title as? ImageTitleBarElement {
            let image = viewFactory.view(forElement: imageTitleBarElement.image)
            image.frame = CGRect(x: 0, y: 0, width: 44, height: 44)
            navigationItem.titleView = image
        }

        let scrollView = UIScrollView(frame: .zero)
        scrollView.alwaysBounceVertical = true
        view.addSubview(scrollView)
        scrollView.snp.makeConstraints {
            $0.edges.equalToSuperview()
        }

        let body = viewFactory.view(forElement: element.body)
        scrollView.addSubview(body)
        body.snp.makeConstraints {
            $0.width.equalToSuperview()
            $0.leading.top.trailing.equalToSuperview()
            $0.bottom.equalToSuperview().priority(.low)
        }
    }
}
