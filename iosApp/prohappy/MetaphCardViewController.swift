//
//  MetaphCardViewController.swift
//  prohappy
//
//  Created by Olga Deryabina on 2022-01-16.
//

import UIKit

class MetaphCardViewController: UIViewController {
    
    @IBAction func onFinishSessionClick(_ sender: Any) {
        appDelegate.sessionRepo?.saveMessageToFuture(message: "abc", completionHandler: { data, err in
        
        })
        //return back to the first screen
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
