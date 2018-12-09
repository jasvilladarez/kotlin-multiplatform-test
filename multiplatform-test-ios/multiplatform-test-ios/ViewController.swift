//
//  ViewController.swift
//  multiplatform-test-ios
//
//  Created by Jasmine on 12/9/18.
//  Copyright © 2018 Jasmine. All rights reserved.
//

import UIKit
import multiplatform_test_shared

class ViewController: UIViewController {

    @IBOutlet weak var helloLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        helloLabel.text = CommonKt.createAppMessage()
    }

}
