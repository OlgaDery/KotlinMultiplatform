//
//  QuestViewController.swift
//  prohappy
//
//  Created by Olga Deryabina on 2021-10-11.
//

import UIKit

class QuestViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate {
    
    @IBOutlet weak var emotionsPicker: UIPickerView!
    @IBOutlet weak var convictionsPicker: UIPickerView!
    @IBOutlet weak var triggerExistsButton: UISegmentedControl!
    @IBOutlet weak var getCardButton: UIButton!
    @IBOutlet weak var amIresponsibleControl: UISegmentedControl!
    
    @IBAction func onGetCardButtonClick(_ sender: UIButton) {
        appDelegate.sessionRepo?.generateSessionCodeAfterInitialScreening(
            completionHandler: { data, err in
                
            }
        )
        
        let storyboard = UIStoryboard(name: "MetaphoricCardStoryboard", bundle: nil).instantiateViewController(withIdentifier: "MetaphCardStoryboard") as! MetaphCardViewController
      //  self.present(storyboard, animated: true, completion: nil)
        self.navigationController?.pushViewController(storyboard, animated: true)
    }
    
    var irrationalConvictionCode: Int = -1
    var severity: Int = 0
    var emotionCode: Int = -1
    var criticalConditionConfirmed = false
    var dangerousTriggerConfirmed = false
    var significantPersonInvolved = false
    var triggerConfirmed = false
    
    func displayMoreSessionQuestions() -> Bool {
        return triggerConfirmed
    }
    
    @IBAction func onTriggerExistsControlValueChange(_ sender: UISegmentedControl) {
        print(sender.selectedSegmentIndex)
        appDelegate.sessionRepo?.session.dangerousTriggerConfirmed = Int32(sender.selectedSegmentIndex) == 1
        createSession()
    }

    let appDelegate = UIApplication.shared.delegate as! AppDelegate
    
    
    //Constant. Let may be used as a constant or as a 'val' equivalent in Kotlin
    let convictions = ["Я глупый", "Я ненадежный", "Я бесполезный", "Я уязвимый", "Я беспомощный", "Я брошенный", "Я подавленный", "Я уставший", "Я плохой", "Я никчемный", "Я недооцененный", "Я разочарованный", "Я преданный", "Я омерзительный", "Я отвратительный"]
    
    let emotions = ["не выбрано", "тревога", "страх", "ужас", "разочарование", "сожаление", "обида", "печаль", "тоска", "отчаяние", "смущение", "стыд", "вина", "презрение", "зависть", "отвращение", "пустота", "раздражение", "гнев"]
    
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if (pickerView.tag == 1) {
            return convictions.count
        }
        return emotions.count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if (pickerView.tag == 1) {
            return convictions[row]
        }
        return emotions[row]
    }
    

    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if (pickerView.tag == 1) {
            
            appDelegate.sessionRepo?.session.irrationalConvictionCode = Int32(row)
            return
        }
        appDelegate.sessionRepo?.session.emotionCode = Int32(row)
    }
    
    func createSession() {
        appDelegate.sessionRepo?.saveSession(selectedConviction: (appDelegate.sessionRepo?.session.irrationalConvictionCode)!, selectedEmotion: 5, criticalConditionConfirmed: true, severity: 2, triggerExists: true, userResponsible: false, completionHandler: { ktlnUnit, err in
        })
    }
    
    override func viewDidLoad() {
      //  super.viewDidLoad
        self.emotionsPicker.delegate = self
        self.emotionsPicker.dataSource = self
        self.convictionsPicker.delegate = self
        self.convictionsPicker.dataSource = self
    }
}
