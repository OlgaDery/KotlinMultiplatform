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
//        let nextVC = QuestViewController()
//        //this call allows a transition to the next view controller
        let storyboard = UIStoryboard(name: "QuestionsStoryboard", bundle: nil).instantiateViewController(withIdentifier: "QuestionsStoryboard") as! QuestViewController
        self.present(storyboard, animated: true, completion: nil)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loadSessions()
        startSessionQuestion.text = "Вам плохо?"
    }
    
    func loadSessions() {
        appDelegate.sessionRepo?.selectAllSessionsOnAppInit(handler: true, completionHandler: { sessions, err in
            print("found sessions: ")
            sessions?.forEach{ sess in
                print(sess)
                self.appDelegate.sessionRepo?.userRepo.listOfSessionPatterns.add(sess.sessionPatternCode)
            }
        })
    }


}

