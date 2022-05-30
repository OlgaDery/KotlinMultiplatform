//
//  MetaphCardViewController.swift
//  prohappy
//
//  Created by Olga Deryabina on 2022-01-16.
//

import UIKit

class MetaphCardViewController: UIViewController {
    
    @IBOutlet weak var yourFeelingTextField: UITextField!
    
    @IBOutlet weak var yourMessageToFutureTextField: UITextField!
    
    @IBOutlet weak var yourDecisionTextField: UITextField!
    
    @IBOutlet weak var itemInYourLifeTextField: UITextField!
    
    
    @IBAction func onFinishSessionClick(_ sender: Any) {
        
        //return back to the first screen
        self.navigationController?.popToRootViewController(animated: true)
        appDelegate.sessionRepo?.saveMessageToFuture(message: yourMessageToFutureTextField.text ?? "", completionHandler: { data, err in
        
        })
    }
    
    let appDelegate = UIApplication.shared.delegate as! AppDelegate
  
    @IBOutlet weak var cardImageView: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let stringValue = String(appDelegate.sessionRepo?.session.sessionPatternCode ?? 1)
        let assetName = "card_" + stringValue
        cardImageView.image = UIImage(named: assetName)
    }
}
