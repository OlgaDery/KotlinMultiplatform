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
    
    let appDelegate = UIApplication.shared.delegate as! AppDelegate
    
    @IBAction func onButtonClick(_ sender: Any, forEvent event: UIEvent) {
//        //this call allows a transition to the next view controller
//        let storyboard = UIStoryboard(name: "QuestionsStoryboard", bundle: nil).instantiateViewController(withIdentifier: "QuestionsStoryboard") as! QuestViewController
       // self.present(storyboard, animated: true, completion: nil)
        let vc = UIStoryboard(name: "QuestionsStoryboard", bundle: nil)
        let abc = vc.instantiateViewController(withIdentifier: "QuestionsStoryboard") as? QuestViewController
        
        self.navigationController?.pushViewController(abc!, animated: true)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loadSessions()
        startSessionQuestion.text = "Вам плохо?"
    }
    
    func loadSessions() {
        appDelegate.sessionRepo?.selectAllSessionsOnAppInit(handler: true, completionHandler: { sessions, err in
            sessions?.forEach{ sess in
                self.appDelegate.sessionRepo?.userRepo.listOfSessionPatterns.add(sess.sessionPatternCode)
            }
        })
    }


}

