//
//  ViewController.swift
//  prohappy
//
//  Created by Olga Deryabina on 2021-06-19.
//

import UIKit

class ViewController: UIViewController {

    //outlet annotates the variable reference
    //action annotates the function mapped to the UI components
    
    @IBOutlet weak var sunIcon: UIImageView!
    
    @IBOutlet weak var startSessionButton: UIButton!
    
    @IBOutlet weak var startSessionQuestion: UILabel!
    
    @IBAction func onClearSessionClick(_ sender: UIButton) {
        //clear sessions and reload the view
        loadSessions(clear: true)
        
    }
    
    let appDelegate = UIApplication.shared.delegate as! AppDelegate
    
    @IBAction func onButtonClick(_ sender: Any, forEvent event: UIEvent) {
        //this call allows a transition to the next view controller
        let vc = UIStoryboard(name: "QuestionsStoryboard", bundle: nil)
        let abc = vc.instantiateViewController(withIdentifier: "QuestionsStoryboard") as? QuestViewController
        
        self.navigationController?.pushViewController(abc!, animated: true)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        loadSessions(clear: false)
    }
    
    func loadSessions(clear: Bool) {
        appDelegate.sessionRepo?.selectAllSessions(clear: clear, completionHandler: {
            sess, err in
            print(sess!)
            self.startSessionQuestion.text = "Sessions completed: " + "\(sess ?? 0)"
        })
    }

}

