//
//  QuestViewController.swift
//  prohappy
//
//  Created by Olga Deryabina on 2021-10-11.
//

import UIKit

class QuestViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate {
    
    @IBOutlet weak var emotionsPicker: UIPickerView!
    
    @IBOutlet weak var responsibilityControl: UISegmentedControl!
    
    @IBOutlet var scrollView: UIScrollView!
    
    @IBOutlet weak var getCardButton: UIButton!
    
    @IBAction func onGetCardButtonClick(_ sender: Any) {
        appDelegate.sessionRepo?.saveSession(selectedConviction: 0, selectedEmotion: 5, criticalConditionConfirmed: true, severity: 2, triggerExists: true, userResponsible: false, completionHandler: { ktlnUnit, err in

            let storyboard = UIStoryboard(name: "MetaphoricCardStoryboard", bundle: nil).instantiateViewController(withIdentifier: "MetaphCardStoryboard") as! MetaphCardViewController
            self.navigationController?.pushViewController(storyboard, animated: true)
        })
    }
    
    var severity: Int = 0
    var emotionCode: Int = -1

    let appDelegate = UIApplication.shared.delegate as! AppDelegate
    
    
    //Constant. Let may be used as a constant or as a 'val' equivalent in Kotlin
    
    let emotions = ["не выбрано", "тревога", "страх", "ужас", "разочарование", "сожаление", "обида", "печаль", "тоска", "отчаяние", "смущение", "стыд", "вина", "презрение", "зависть", "отвращение", "пустота", "раздражение", "гнев"]
    
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return emotions.count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return emotions[row]
    }
    

    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if (pickerView.tag == 1) {
            
            appDelegate.sessionRepo?.session.irrationalConvictionCode = Int32(row)
            return
        }
        appDelegate.sessionRepo?.session.emotionCode = Int32(row)
    }
    
    override func viewDidLoad() {
        self.emotionsPicker.delegate = self
        self.emotionsPicker.dataSource = self
    }
}
