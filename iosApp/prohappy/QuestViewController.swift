//
//  QuestViewController.swift
//  prohappy
//
//  Created by Olga Deryabina on 2021-10-11.
//

import UIKit

//currently this subclass can be created only manyally, should create a swift class and make it implementing UIViewController
class QuestViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate {
    
    
    @IBOutlet weak var emotionsPicker: UIPickerView!
    
    
    @IBOutlet weak var convictionsPicker: UIPickerView!
    
    
    @IBOutlet weak var triggerExistsButton: UISegmentedControl!
    
    @IBAction func onTriggerExistsControlValueChange(_ sender: UISegmentedControl) {
        print(sender.selectedSegmentIndex)
    }
    
    
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
        print(pickerView.tag)
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        self.emotionsPicker.delegate = self
        self.emotionsPicker.dataSource = self
        self.convictionsPicker.delegate = self
        self.convictionsPicker.dataSource = self
        
//        DispatchQueue.main.asyncAfter(deadline: .now() + .seconds(4), execute: {
//            self.emotionsPicker.reloadAllComponents()
//        })
    
    }

    
    func feelsLikeIamUnigue() {
        
    }
    
    
}
