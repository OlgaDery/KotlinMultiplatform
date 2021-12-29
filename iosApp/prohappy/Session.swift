//
//  Session.swift
//  prohappy
//
//  Created by Olga Deryabina on 2021-10-30.
//

import Foundation

struct Session {
    
    var irrationalConvictionCode: Int = -1
    var howStrong: Int = 0
    var emotionCode: Int = -1
    var criticalConditionConfirmed = false
    var dangerousTriggerConfirmed = false
    var significantPersonInvolved = false
    var triggerConfirmed = false
    
    func displayMoreSessionQuestions() -> Bool {
        return triggerConfirmed
    }
    
//    @TypeConverters(DateConverter::class)
//       @ColumnInfo (name = "when_added") var whenAdded: Date = Date()
//       @ColumnInfo (name = "how_strong")
//       @ColumnInfo (index = true, name = "situation_id") var situationID: String? = null
//       @ColumnInfo (index = true, name = "metaphor_id") var metaphorID: String? = null
//       @ColumnInfo (index = true, name = "flashback_id") var flashbackID: String? = null
//       @ColumnInfo (index = true, name = "irrational_conviction_id") var : String? = null
//       @ColumnInfo (index = true, name = "rational_conviction_id") var rationalConvictionId: String? = null
//       @ColumnInfo (name = "assigned_homework_name") var homeworkName: String? = null
//
//       @ColumnInfo(name = "physical_condition_1") var physicalCondition1: Int? = null
//       @ColumnInfo(name = "physical_condition_2") var physicalCondition2: Int? = null
//       @ColumnInfo(name = "physical_condition_3") var physicalCondition3: Int? = null
//       @ColumnInfo(name = "session_pattern_code") var sessionPatternCode: Int = StaticStrings.DEFAULT
//       //TODO adding new fields
//
//       @ColumnInfo(name = "message_to_future") var messageToFuture: String? = null
//       @ColumnInfo(name = "critical_condition_confirmed") var criticalConditionConfirmed = false
//       @ColumnInfo(name = "dangerous_trigger_confirmed") var dangerousTriggerConfirmed = false
//       @ColumnInfo(name = "external_abuse_confirmed") var externalAbuseConfirmed = false
//       @ColumnInfo(name = "own_aggression_confirmed") var ownAggressionConfirmed = false
//       @ColumnInfo(name = "significant_person_involved") var significantPersonInvolved = false
//       @ColumnInfo(name = "accept_own_responsibility") var acceptOwnResponsibility = true
//       @ColumnInfo(name = "hidden_reason_code") var hiddenReasonCode = -1
//       @ColumnInfo(name = "feels_like_unique") var feelsLikeUnique = false
//
//       @Ignore var situation: CommonSituations? = null
//      // @Ignore var flashback: Flashback? = null
//       @Ignore var irrationalConviction: IrrationalConviction? = null
//
//       @Ignore val emotionsList = mutableSetOf<EmotionToSession>()
//       @Ignore var emotionsNames: String = ""
//           get() {
//               val builder = StringBuilder()
//               if (emotionsList.isNotEmpty()) {
//                   emotionsList.forEach {
//                       builder.append(it.emotionCodeInCommonChart).append(", ")
//                   }
//                   return builder.toString().substring(0, builder.toString().length-2)
//               }
//               return ""
//           }
//
//
//       @Ignore var severity: String = ""
//           get() {
//               return when (howStrong) {
//                   0 -> "эмоциональный дискомфорт"
//                   1 -> "существенный эмоциональный дискомфорт, переживания в течение нескольких часов"
//                   2 -> "существенный дискомфорт на эмоц и физическом уровне, влияющий на социальную" +
//                           " и эмоциональную жизнедеятельность"
//                   else -> "неизвестно"
//               }
//           }

    
}
