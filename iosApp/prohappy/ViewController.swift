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
    
    @IBAction func onButtonClick(_ sender: Any, forEvent event: UIEvent) {
//        let nextVC = QuestViewController()
//        //this call allows a transition to the next view controller
        let storyboard = UIStoryboard(name: "QuestionsStoryboard", bundle: nil).instantiateViewController(withIdentifier: "QuestionsStoryboard") as! QuestViewController
        self.present(storyboard, animated: true, completion: nil)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        startSessionQuestion.text = "Вам плохо?"
    }


}

