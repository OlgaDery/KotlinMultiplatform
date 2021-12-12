package com.example.testapp

import com.example.prohappymultiplatform.Platform

data class User (var revisionID: Int) {

    var id: String = Platform().randomUUID()
    var email: String = "email"
    var basicDataSetUp: Boolean = false
    //var createdDate: Date = Date()
    var password: String = "password"
    var goal1: String = ""
    var goal2: String = ""
    var goal3: String = ""
    var goal4: String = ""
    var goal5: String = ""
    var goal6: String = ""
    var agreement1Accepted: Boolean = true
    var agreement2Accepted: Boolean = true
    var selfRejection: Int? = 0
    var abnormalConditionsDetected: Int? = 0
    var untreatedTrauma = false
   //var dateOfBirth: Date? = null
    var biologicGender: Int? = null
    var psychologicGender: Int? = null
    var allFieldsSetUp: Boolean = false
    val allProfileSetUp: Boolean
        get() {
            return allFieldsSetUp && !photoPath.isNullOrBlank() && goal1.isNotBlank() && goal2.isNotBlank() && goal3.isNotBlank()
        }

    val allExtrasSetUp: Boolean
        get() {
            return !photoPath.isNullOrBlank() && goal1.isNotBlank() && goal2.isNotBlank() && goal3.isNotBlank()
        }

    var psychoGender: String = ""
        private set
        get() {
            return when (psychologicGender) {
                0 -> {
                    "мужской"
                }
                1 -> {
                    "женский"
                }
                2 -> {
                    "другое"
                }
                else -> {
                    "не определено"
                }
            }
        }

    var bioGender: String? = null
        private set
        get() {
            return when (biologicGender) {
                0 -> {
                    "мужской"
                }
                1 -> {
                    "женский"
                }
                2 -> {
                    "другое"
                }
                else -> {
                    null
                }
            }
        }

    var nickName: String? = ""
    var personalType: String? = ""
    var inRelationshipsNow: Int? = null
    var sectionCheckCompleted: Boolean = false
    var sectionCharacterCompleted: Boolean = false
    var sectionResourceCompleted: Boolean = false
    var sectionParentalFamilyCompleted: Boolean = false
    var sectionMyFamilyCompleted: Boolean = false
    var sectionLocusOfControlCompleted: Boolean = false
    var sectionValuesCompleted: Boolean = false
    var sectionSatisfactionCompleted: Boolean = false
    var sectionWinnerCompleted: Boolean = false
    var sectionEmotionsControlCompleted: Boolean = false
    var sectionCommonProblemsCompleted: Boolean = false
    var sectionRelationshipsCompleted: Boolean = false
    var usersNeedOfTherapy: Int? = 0
    var needOfExternalChanges: Int? = 0
    // character
    //assuming anger, narcissic or hysterical pattern. Relaxing, attention
    var choleric: Int? = 0
    //assuming depression. More actions exercises. Low self esteem
    var melancholic: Int? = 0
    //understanding other people
    var sanguine: Int? = 0
    //assuming communications problem. Working with empathy and emotions differentiation, apathy
    var phlegmatic: Int? = 0
    //resource
    var selfDestructionLevel: Int? = 0
    var recoveryLevel: Int? = 0
    var fearsLevel: Int? = 0
    var panicAttacksLevel: Int? = 0
    //okr
    var obsessionLevel: Int? = 0
    //mazo/hysteric
    var hypochondriaLevel: Int? = 0
    //dependant
    var chemicalAddictionLevel: Int? = 0
    //dependant
    var chemicalAddiction1_Level: Int? = 0
    var emotionsAddictionLevel: Int? = 0
    //dependant
    var otherAddictionLevel: Int? = 0
    var addictedParentalFamily: Boolean = false
    var addictedFamilyNow: Boolean = false
    //my family and parental family
    var parentalFamilyEmotionsDevaluationLevel: Int? = 0
    //neurotic
    var currentFamilyEmotionsDevaluationLevel: Int? = 0
    var parentalFamilyIntellectualDevaluationLevel: Int? = 0
    //dependant
    var currentFamilyIntellectualDevaluationLevel: Int? = 0
    var parentalFamilyValuesDevaluationLevel: Int? = 0
    //existential/narcissic
    var currentFamilyValuesDevaluationLevel: Int? = 0
    var parentalFamilyAppearanceDevaluationLevel: Int? = 0
    var parentalFamilyGeneralHappinessLevel: Int? = 0
    var currentFamilyGeneralHappinessLevel: Int? = 0
    var currentFamilyAppearanceDevaluationLevel: Int? = 0
    var currentFamilySuccessDevaluationLevel: Int? = 0
    //neurotic
    var parentalFamilySuccessDevaluationLevel: Int? = 0
    //neurotic
    var parentalFamilyPhysicalPunishmentLevel: Int? = 0
    var currentFamilyPhysicalViolenceLevel: Int? = 0
    var parentalFamilyGuiltPunishmentLevel: Int? = 0
    //neurotic
    var currentFamilyGuiltPunishmentLevel: Int? = 0
    var parentalFamilyNeedsDevaluationLevel: Int? = 0
    var currentFamilyNeedsDevaluationLevel: Int? = 0
    //neurotic, mazohism
    var parentalFamilySocialIsolationLevel: Int? = 0
    var currentFamilySocialIsolationLevel: Int? = 0
    //mazohism
    var currentFamilyChronicalDeceptionLevel: Int? = 0
    //very bad schizoid/psychopatia/psychotic/anxiesty depending on the character or phobias
    var parentalFamilyChronicalDeceptionLevel: Int? = 0
    //mazo
    var parentalFamilyPrivacyOffenceLevel: Int? = 0
    var currentFamilyPrivacyOffenceLevel: Int? = 0
    var parentalFamilySexualAbuseLevel: Int? = 0
    //psychotic, neurotic
    var currentFamilySexualAbuseLevel: Int? = 0
    var parentalFamilyFinancialAbuseLevel: Int? = 0
    //okr mazohism
    var currentFamilyFinancialAbuseLevel: Int? = 0
    var currentFamilyNeglectanceLevel: Int? = 0
    //psychopatia, schizophrenia, depression
    var parentalFamilyNeglectanceLevel: Int? = 0
    var currentFamilyConfidenceLevel: Int? = 0
    var parentalFamilyConfidenceLevel: Int? = 0
    var parentalFamilyComparisonLevel: Int? = 0
    var currentFamilyComparisonLevel: Int? = 0
    var currentFamilyDemonstrativeIgnoranceLevel: Int? = 0
    var meDefinitionDifficultiesLevel: Int? = 0
    var currentFamilyEmotionalAggressionLevel: Int? = 0
    var parentalFamilyDemonstrativeIgnoranceLevel: Int? = 0
    var parentalFamilyEmotionalAggressionLevel: Int? = 0
    //locus
    var myCommitmentInSuccessLevel: Int? = 0
    var myCommitmentInFailsLevel: Int? = 0
    var otherSideCommitmentInSuccessLevel: Int? = 0
     var otherSideCommitmentInFailsLevel: Int? = 0

    //TODO check in authviewmodel if setting up
    var myRelationshipsWithWorldPattern: Int? = 0
    var myRightToControlOtherPeopleLifeLevel: Int? = 0
    var iHaveToControlOtherPeopleLifeLevel: Int? = 0
    var peopleAlwaysConfrontMe: Int? = 0
    var problemsObservabilityLevel: Int? = 0
    var beliefInFateLevel: Int? = 0
    var mostCommonAttitude: Int? = 0

    //values
    var healthImportanceLevel: Int? = 0
    var financesImportanceLevel: Int? = 0
    var balanceImportanceLevel: Int? = 0
    var emotionsImportanceLevel: Int? = 0
    var actualizationImportanceLevel: Int? = 0
    var socialSuccessImportanceLevel: Int? = 0
    var significantPeopleImportanceLevel: Int? = 0
    var socialLifeImportanceLevel: Int? = 0
    var appearanceImportanceLevel: Int? = 0
    var beingExceptionalImportanceLevel: Int? = 0
    //satisfaction
    var healthSatisfactionLevel: Int? = 0
    var financesSatisfactionLevel: Int? = 0
    var balanceSatisfactionLevel: Int? = 0
    var emotionsSatisfactionLevel: Int? = 0
    var actualizationSatisfactionLevel: Int? = 0
    var socialLifeSatisfactionLevel: Int? = 0
    var socialSuccessSatisfactionLevel: Int? = 0
    var significantPeopleSatisfactionLevel: Int? = 0
    var generalSatisfactionLevel: Int? = 0
    var appearanceSatisfactionLevel: Int? = 0
    var personalTraitsSatisfactionLevel: Int? = 0
    //winner
    var idealPersonalityMatchLevel: Int? = 0
    //TODO maybe reformulate?
    var hiddenPotentialLevel: Int? = 0
    var willingnessToUsePotentialLevel: Int? = 0
    var lifeMeaningfulnessLevel: Int? = 0
    var iKnowWhatICanLevel: Int? = 0
    var fulfillingGoalsLevel: Int? = 0
    var obstaclesEvaluationLevel: Int? = 0
    var avoidingChangesLevel: Int? = 0
    var learningFromMistakes: Int? = 0
    //emotions
    var emotionsIndicating: Int? = 0
    var otherPeopleEmotionsIndicating: Int? = 0
    var commonNegativeEmotion1: Int? = 0
    var commonNegativeEmotion1Level: Int? = 0
    var commonNegativeEmotion2: Int? = 0
    var commonNegativeEmotion2Level: Int? = 0
    var commonNegativeEmotion3: Int? = 0
    var commonNegativeEmotion3Level: Int? = 0
    var uncontrolledEmotion1: Int? = 0
    var uncontrolledEmotion1Level: Int? = 0
    var uncontrolledEmotion2: Int? = 0
    var uncontrolledEmotion2Level: Int? = 0
    var uncontrolledEmotion3: Int? = 0
    var uncontrolledEmotion3Level: Int? = 0
    var uncommonNegativeEmotion2: Int? = 0
    var uncommonNegativeEmotion1: Int? = 0
    var uncommonNegativeEmotion3: Int? = 0
    var wantedEmotion2: Int? = 0
    var wantedEmotion1: Int? = 0
    var wantedEmotion3: Int? = 0
    var unwantedEmotion2: Int? = 0
    var unwantedEmotion1: Int? = 0
    var unwantedEmotion3: Int? = 0
    var punishedEmotion2: Int? = 0
    var punishedEmotion1: Int? = 0
    var punishedEmotion3: Int? = 0
    var commonNegativeChildhoodEmotion2: Int? = 0
    var commonNegativeChildhoodEmotion1: Int? = 0
    var commonNegativeChildhoodEmotion3: Int? = 0

    //common problems
    var iCanNotRelaxReason: Int? = 0
    var iCanNotRelaxLevel: Int? = 0
    var iCanNotSayNoReason: Int? = 0
    var iCanNotSayNoLevel: Int? = 0
    var iProcrastinateReason: Int? = 0
    var iProcrastinateLevel: Int? = 0
    var iCanNotApproachPeopleReason: Int? = 0
    var iCanNotApproachPeopleLevel: Int? = 0
    var iAmFeelingBoredWithMyselfReason: Int? = 0
    var iAmFeelingBoredWithMyselfLevel: Int? = 0
    var iAmAfraidOfFutureReason: Int? = 0
    var iAmAfraidOfFutureLevel: Int? = 0
    var iAmAfraidOfCompetitionReason: Int? = 0
    var iAmAfraidOfCompetitionLevel: Int? = 0
    var iAmNotOpenReason: Int? = 0
    var iAmNotOpenLevel: Int? = 0
    var iAmConflictProneReason: Int? = 0
    var iAmConflictProneLevel: Int? = 0
    var iAmAfraidOfLostReason: Int? = 0
    var iAmAfraidOfLostLevel: Int? = 0
    var relationshipAvoidanceReason: Int? = 0
    var relationshipAvoidanceLevel: Int? = 0
    var photoPath: String? = null
    var deviceOwner: Boolean = true
    var loggedIn: Boolean = false

//    var actualProblems = mutableListOf<Scenario>()
//    val fastAccessExercises = mutableListOf<FastAccessExersice>()
//    val abilities = mutableListOf<Ability>()
//    val favoriteThings = mutableListOf<FavoriteThing>()
//    val goals = mutableListOf<Goal>()
//    var allActiveProblems: MutableList<Scenario> = mutableListOf()
//        get() {
//            return actualProblems.filter { it.isActive }.toMutableList()
//        }
//
//    var allCompletedProblems: MutableList<Scenario> = mutableListOf()
//        get() {
//            return actualProblems.filter { it.completedDate != null }.toMutableList()
//        }
//
//    var cancelledProblems: MutableList<Scenario> = mutableListOf()
//        get() {
//            return actualProblems.filter { it.completedDate == null && !it.isActive && it.activationDate != null}.toMutableList()
//        }
//
//    var processedEmotions = mutableListOf<EmotionForRecord>()
//    var flashBacks = mutableListOf<Flashback>()
//    var exercises = mutableListOf<Exercise>()
//
//    var habits = mutableListOf<HabitBaseClass>()
//        get() {
//            field.clear()
//            field.addAll(abilities.filter { it.addedToHabits })
//            field.addAll(favoriteThings.filter { it.addedToHabits })
//            field.addAll(fastAccessExercises.filter { it.addedToHabits })
//            return field
//        }
//
//    var weeklyTasks = mutableListOf<WeeklyTask>()
//
//    var rationalConvictions = mutableListOf<RationalConviction>()
//
//    var situations = mutableListOf<CommonSituations>()
//    val protectionRecords = mutableListOf<ProtectionForRecord>()
//
//    val helpers = mutableListOf<ExerciseBaseClass>()
//    var hasHomeWork: Boolean = false
//        get() {
//            actualProblems.forEach {
//                if (it.homeWork != null) {
//                    return true
//                }
//            }
//            return false
//        }
//
//    var image: Bitmap? = null
//
//    var currentWeeklyTask: WeeklyTask? = null
//
//    var listOfAllRecords = mutableListOf<ExerciseBaseClass>()
//        get(){
//            return mutableListOf<ExerciseBaseClass>().apply {
//                addAll(flashBacks)
//                addAll(rationalConvictions)
//                addAll(exercises)
//                addAll(processedEmotions)
//                addAll(protectionRecords)
//            }.sortedByDescending { it.whenAdded }.toMutableList()
//        }
//
//    var listOfAllPersonalityCoreProps = mutableListOf<PersonalCoreBaseClass>()
//        get(){
//            return mutableListOf<PersonalCoreBaseClass>().apply {
//                favoriteThings.forEach {
//                    add(it)
//                }
//                abilities.forEach {
//                    add(it)
//                }
//                goals.forEach {
//                    add(it)
//                }
//            }
 //       }

}