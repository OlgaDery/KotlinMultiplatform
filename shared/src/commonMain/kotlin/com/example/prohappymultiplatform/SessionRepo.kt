package com.example.testapp

class SessionRepo(val userRepo: UserRepo) {

    var selectedConviction = ""
    var selectedProtection = ""
    var shouldDecompose = true
    var taskTitle = "My first task title"
    var offenceDetection = -1
    var abuseDetection = -1
    var feelsLikeIamUnique = -1
    var userResponsible = -1
    var happenedInPast = -1
    var hiddenReason = -1
    var dangerousTriggerExists = -1
    var realSituationExistsValue = -1
    var session: Session
        private set

    init {
        //todo database call here
        session = Session(userRepo.user.id, userRepo.user.id, "")
    }

//    val weekCode: Int
//        get(){
//            return (userRepo.user.weeklyTasks.size-1)
//        }

//    private val currentScenarioCodeName: String
//        get() {
//            return user.allActiveProblems[0].calculateAssociatedPattern(appContext.resources)
//        }

    val protectionNames = mutableListOf<Pair<Int, String>>()

    fun addNewProtection(protectionType: Int, trigger: String) {
        protectionNames.add(Pair(protectionType, trigger))
    }

    fun updateSessionValue() {
        //todo update in database
    }

    fun calculateProtectionsTrend(): String {
        val stringBuilder = StringBuilder()
        if (protectionNames.size == 0) {
            return "Несмотря на то, что проблема вас беспокоит, вы воспринимаете ее очень адекватно. Вы понимаете свои слабые " +
                    "стороны и когнитивные ошибки в восприятии ситуации, и готовы меняться."
        }
        if (protectionNames.size <= 2) {
            stringBuilder.append("В целом вы понимаете свою проблему и особенности своей реакции. " +
                    "Тем не менее, вы держтесь за некоторые ложные представления, что может препятствовать изменениям.").append("\n")
        } else {
            stringBuilder.append("Сегодня вы не готовы к изменениям в своем восприятии себя и окружающих и работе над когнитивными ошибками." +
                    "Не очень продуктивная позиция!.").append("\n")
        }
        val protectionsCount = protectionNames.groupingBy { it.first }.eachCount().toMap()
        protectionNames.forEach {

        }

        try {
            stringBuilder.append("В ходе упражнения вы использовали следующие типы защит:").append("\n")
            protectionsCount.forEach{
                stringBuilder.append(StaticStrings.protectionType[it.key]).append(" - использовалась ").append(it.value).append(" раз").append("\n")
            }
        } catch (e: Exception) {}

        return stringBuilder.toString()
    }

    fun generateDecompositionPatternForDecomposableSession(isDefault: Boolean = false) {
        val value = setUpCurrentSessionDecompositionPattern(isDefault)
        value.apply {
            session.sessionPatternCode = this
           // activeScenario!!.listOfSessionPatterns.add(this)
        }
    }

    private fun setUpCurrentSessionDecompositionPattern(isDefault: Boolean = false): Int {
        if (isDefault) {
            return StaticStrings.DEFAULT
        }
        val lastSession: Int
        val sessionBeforeLast: Int
        val sessionBeforeBeforeLast: Int

        if (userRepo.listOfSessionPatterns.isNotEmpty()) {

            lastSession = userRepo.listOfSessionPatterns.last()
            sessionBeforeLast = try {
                userRepo.listOfSessionPatterns[userRepo.listOfSessionPatterns.size-2]
            } catch (e: Exception) {
                -1
            }
            sessionBeforeBeforeLast = try {
                userRepo.listOfSessionPatterns[userRepo.listOfSessionPatterns.size-3]
            } catch (e: Exception) {
                -1
            }
            when {
                offenceDetection == 1 -> {
                    if (!userRepo.listOfSessionPatterns.contains(StaticStrings.DECOMPOSIT_OFFENCE_DETECTED_HW)) {
                        return StaticStrings.DECOMPOSIT_OFFENCE_DETECTED_HW
                    }
                }

                abuseDetection == 1 -> {
                    //                   System.out.println("abuseDetection")
                    if (!userRepo.listOfSessionPatterns.contains(StaticStrings.DECOMPOSIT_ABUSE)) {
                        return StaticStrings.DECOMPOSIT_ABUSE
                    }
                }

                feelsLikeIamUnique == 1 -> {
                    //                  System.out.println("feelsLikeIamUnique")
                    if (!userRepo.listOfSessionPatterns.contains(StaticStrings.DECOMPOSIT_FEELS_LIKE_UNIQUE)) {
                        return StaticStrings.DECOMPOSIT_FEELS_LIKE_UNIQUE
                    }
                }
            }
            // check if there were enough metaph cards, so at 5 last patterns should have at least one metaphor cards
            if (userRepo.listOfSessionPatterns.size >= 5 &&
                (!userRepo.listOfSessionPatterns.contains(StaticStrings.BASIC_DECOMPOSIT_CARD)
                        && !userRepo.listOfSessionPatterns.contains(StaticStrings.DECOMPOSIT_ABUSE)
                        && !userRepo.listOfSessionPatterns.contains(StaticStrings.DECOMPOSIT_OFFENCE_DETECTED_HW)
                        && !userRepo.listOfSessionPatterns.contains(StaticStrings.NO_DECOMPOSIT_NO_TRIGGER_CARD)
                        && !userRepo.listOfSessionPatterns.contains(StaticStrings.NO_DECOMPOSIT_DISORDERS_DETECTED_HW)
                        && !userRepo.listOfSessionPatterns.contains(StaticStrings.NO_DECOMPOSIT_BAD_TRIGGER_DETECTED_HW))) {

                return StaticStrings.BASIC_DECOMPOSIT_CARD
            }
            if (userRepo.listOfSessionPatterns.size == 9 && (!userRepo.listOfSessionPatterns.subList(5, 8)
                    .contains(StaticStrings.BASIC_DECOMPOSIT_CARD)
                        && !userRepo.listOfSessionPatterns.subList(5, 8).contains(StaticStrings.DECOMPOSIT_ABUSE)
                        && !userRepo.listOfSessionPatterns.subList(5, 8).contains(StaticStrings.DECOMPOSIT_OFFENCE_DETECTED_HW)
                        && !userRepo.listOfSessionPatterns.subList(5, 8).contains(StaticStrings.NO_DECOMPOSIT_NO_TRIGGER_CARD)
                        && !userRepo.listOfSessionPatterns.subList(5, 8).contains(StaticStrings.NO_DECOMPOSIT_DISORDERS_DETECTED_HW)
                        && !userRepo.listOfSessionPatterns.subList(5, 8).contains(StaticStrings.NO_DECOMPOSIT_BAD_TRIGGER_DETECTED_HW))) {

                return StaticStrings.BASIC_DECOMPOSIT_CARD
            }
            if (userRepo.listOfSessionPatterns.size >= 4 && //&& sessionViewData!!.improvementProbability != 0
                !userRepo.listOfSessionPatterns.contains(StaticStrings.BASIC_DECOMPOSIT_POTENTIAL_IMPROV)) {
                return StaticStrings.BASIC_DECOMPOSIT_POTENTIAL_IMPROV
            }

            if (userRepo.listOfSessionPatterns.size >= 4
                && !userRepo.listOfSessionPatterns.contains(StaticStrings.DECOMPOSIT_POSITIVE_ASPECTS_OF_SITUATION)) {
                return StaticStrings.DECOMPOSIT_POSITIVE_ASPECTS_OF_SITUATION
            }

            when (userResponsible) {
                //false
                1 -> {
                    // check if the situation will happen in the future so exclude this pattern
                    if (lastSession != StaticStrings.BASIC_DECOMPOSIT_ME_TYPE
                        && sessionBeforeLast != StaticStrings.BASIC_DECOMPOSIT_ME_TYPE
                        && sessionBeforeBeforeLast != StaticStrings.BASIC_DECOMPOSIT_ME_TYPE
                        && happenedInPast == 1
                        && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.BASIC_DECOMPOSIT_ME_TYPE }.size < 2) {
                        // System.out.println("basic me type")
                        return StaticStrings.BASIC_DECOMPOSIT_ME_TYPE

                    } else {
                        when (hiddenReason) {
                            0 -> {
                                // System.out.println("narciss me type")
                                if (lastSession != StaticStrings.ALTER_NARCISS_DECOMPOSIT_ME_TYPE && sessionBeforeLast
                                    != StaticStrings.ALTER_NARCISS_DECOMPOSIT_ME_TYPE
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_NARCISS_DECOMPOSIT_ME_TYPE
                                    && userRepo.listOfSessionPatterns
                                        .filter{ it == StaticStrings.ALTER_NARCISS_DECOMPOSIT_ME_TYPE }.size < 2) {
                                    return StaticStrings.ALTER_NARCISS_DECOMPOSIT_ME_TYPE
                                }

                            }
                            1 -> {
                                // System.out.println("neurotic type")
                                if (lastSession != StaticStrings.ALTER_NEUROTIC_DECOMPOSIT
                                    && sessionBeforeLast != StaticStrings.ALTER_NEUROTIC_DECOMPOSIT
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_NEUROTIC_DECOMPOSIT
                                    && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.ALTER_NEUROTIC_DECOMPOSIT }.size < 2) {
                                    return StaticStrings.ALTER_NEUROTIC_DECOMPOSIT
                                }
                            }
                            2 -> {
                                // System.out.println("psychotic me type")
                                if (lastSession != StaticStrings.ALTER_PSYCHOTIC_DECOMPOSIT && sessionBeforeLast
                                    != StaticStrings.ALTER_PSYCHOTIC_DECOMPOSIT
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_PSYCHOTIC_DECOMPOSIT
                                    && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.ALTER_PSYCHOTIC_DECOMPOSIT}.size < 2) {
                                    return StaticStrings.ALTER_PSYCHOTIC_DECOMPOSIT
                                }
                            }
                            4 -> {
                                //System.out.println("narc they type")
                                if (lastSession != StaticStrings.ALTER_NARCISS_DECOMPOSIT_THEY_TYPE && sessionBeforeLast
                                    != StaticStrings.ALTER_NARCISS_DECOMPOSIT_THEY_TYPE
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_NARCISS_DECOMPOSIT_THEY_TYPE
                                    && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.ALTER_NARCISS_DECOMPOSIT_THEY_TYPE}.size < 2) {
                                    return StaticStrings.ALTER_NARCISS_DECOMPOSIT_THEY_TYPE
                                }
                            }
                            3 -> {
                                // System.out.println("ocd type")
                                if (lastSession != StaticStrings.ALTER_OCD_DECOMPOSIT && sessionBeforeLast
                                    != StaticStrings.ALTER_OCD_DECOMPOSIT
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_OCD_DECOMPOSIT
                                    && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.ALTER_OCD_DECOMPOSIT}.size < 2) {
                                    return StaticStrings.ALTER_OCD_DECOMPOSIT
                                }
                            }
                            5 -> {
                                //System.out.println("hysteric type")
                                if (lastSession != StaticStrings.ALTER_HYSTERIC_DECOMPOSIT && sessionBeforeLast
                                    != StaticStrings.ALTER_HYSTERIC_DECOMPOSIT
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_HYSTERIC_DECOMPOSIT
                                    && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.ALTER_HYSTERIC_DECOMPOSIT}.size < 2) {
                                    return StaticStrings.ALTER_HYSTERIC_DECOMPOSIT
                                }
                            }
                            6 -> {
                                //System.out.println("helpless type")
                                if (lastSession != StaticStrings.ALTER_HELPLESS_DECOMPOSIT && sessionBeforeLast
                                    != StaticStrings.ALTER_HELPLESS_DECOMPOSIT
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_HELPLESS_DECOMPOSIT
                                    && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.ALTER_HELPLESS_DECOMPOSIT}.size < 2) {
                                    return StaticStrings.ALTER_HELPLESS_DECOMPOSIT
                                }
                            }
                        }
                    }
                }
                0 -> {
                    // check if the situation will happen in the future so exclude this pattern (happenedInPast = 0)
                    if (lastSession != StaticStrings.BASIC_DECOMPOSIT_THEY_TYPE
                        && sessionBeforeBeforeLast != StaticStrings.BASIC_DECOMPOSIT_THEY_TYPE
                        && sessionBeforeLast != StaticStrings.BASIC_DECOMPOSIT_THEY_TYPE
                        && happenedInPast == 1
                        && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.BASIC_DECOMPOSIT_THEY_TYPE }.size < 2) {
                        return StaticStrings.BASIC_DECOMPOSIT_THEY_TYPE

                    } else {
                        when (hiddenReason) {
                            0 -> {
                                //System.out.println("narciss me type")
                                if (lastSession != StaticStrings.ALTER_NARCISS_DECOMPOSIT_ME_TYPE
                                    && sessionBeforeLast != StaticStrings.ALTER_NARCISS_DECOMPOSIT_ME_TYPE
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_NARCISS_DECOMPOSIT_ME_TYPE
                                    && userRepo.listOfSessionPatterns
                                        .filter{ it == StaticStrings.ALTER_NARCISS_DECOMPOSIT_ME_TYPE }.size < 2) {
                                    return StaticStrings.ALTER_NARCISS_DECOMPOSIT_ME_TYPE
                                }

                            }
                            1 -> {
                                // System.out.println("neurotic type")
                                if (lastSession != StaticStrings.ALTER_NEUROTIC_DECOMPOSIT && sessionBeforeLast
                                    != StaticStrings.ALTER_NEUROTIC_DECOMPOSIT
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_NEUROTIC_DECOMPOSIT
                                    && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.ALTER_NEUROTIC_DECOMPOSIT }.size < 2) {
                                    return StaticStrings.ALTER_NEUROTIC_DECOMPOSIT
                                }
                            }
                            2 -> {
                                //System.out.println("psychotic me type")
                                if (lastSession != StaticStrings.ALTER_PSYCHOTIC_DECOMPOSIT && sessionBeforeLast
                                    != StaticStrings.ALTER_PSYCHOTIC_DECOMPOSIT
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_PSYCHOTIC_DECOMPOSIT
                                    && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.ALTER_PSYCHOTIC_DECOMPOSIT}.size < 2) {
                                    return StaticStrings.ALTER_PSYCHOTIC_DECOMPOSIT
                                }
                            }
                            3 -> {
                                //System.out.println("narc they type")
                                if (lastSession != StaticStrings.ALTER_NARCISS_DECOMPOSIT_THEY_TYPE && sessionBeforeLast
                                    != StaticStrings.ALTER_NARCISS_DECOMPOSIT_THEY_TYPE
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_NARCISS_DECOMPOSIT_THEY_TYPE
                                    && userRepo.listOfSessionPatterns.filter{
                                        it == StaticStrings.ALTER_NARCISS_DECOMPOSIT_THEY_TYPE}.size < 2) {
                                    return StaticStrings.ALTER_NARCISS_DECOMPOSIT_THEY_TYPE
                                }
                            }
                            4 -> {
                                //System.out.println("ocd type")
                                if (lastSession != StaticStrings.ALTER_OCD_DECOMPOSIT && sessionBeforeLast != StaticStrings.ALTER_OCD_DECOMPOSIT
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_OCD_DECOMPOSIT
                                    && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.ALTER_OCD_DECOMPOSIT}.size < 2) {
                                    return StaticStrings.ALTER_OCD_DECOMPOSIT
                                }
                            }
                            5 -> {
                                //System.out.println("hysteric type")
                                if (lastSession != StaticStrings.ALTER_HYSTERIC_DECOMPOSIT && sessionBeforeLast
                                    != StaticStrings.ALTER_HYSTERIC_DECOMPOSIT
                                    && sessionBeforeBeforeLast != StaticStrings.ALTER_HYSTERIC_DECOMPOSIT
                                    && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.ALTER_HYSTERIC_DECOMPOSIT}.size < 2) {
                                    return StaticStrings.ALTER_HYSTERIC_DECOMPOSIT
                                }
                            }
                            6 -> {
                                //System.out.println("passive aggression type")
                                if (sessionBeforeBeforeLast != StaticStrings.ALTER_HELPLESS_DECOMPOSIT && lastSession
                                    != StaticStrings.ALTER_HELPLESS_DECOMPOSIT && sessionBeforeLast != StaticStrings.ALTER_HELPLESS_DECOMPOSIT
                                    && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.ALTER_HELPLESS_DECOMPOSIT}.size < 2) {
                                    return StaticStrings.ALTER_HELPLESS_DECOMPOSIT
                                }
                            }
                        }
                    }
                }
            }
            //&& sessionViewData!!.improvementProbability != 0
            if (lastSession != StaticStrings.BASIC_DECOMPOSIT_POTENTIAL_IMPROV && sessionBeforeLast
                != StaticStrings.BASIC_DECOMPOSIT_POTENTIAL_IMPROV
                && userRepo.listOfSessionPatterns
                    .filter{ it == StaticStrings.BASIC_DECOMPOSIT_POTENTIAL_IMPROV}.size < 2) {
                return StaticStrings.BASIC_DECOMPOSIT_POTENTIAL_IMPROV

            } else if (lastSession != StaticStrings.DECOMPOSIT_POSITIVE_ASPECTS_OF_SITUATION && sessionBeforeLast
                != StaticStrings.DECOMPOSIT_POSITIVE_ASPECTS_OF_SITUATION
                && userRepo.listOfSessionPatterns.filter{ it == StaticStrings.DECOMPOSIT_POSITIVE_ASPECTS_OF_SITUATION}.size < 2) {
                return StaticStrings.DECOMPOSIT_POSITIVE_ASPECTS_OF_SITUATION
            }
        } else {
            //The first session
            when (userResponsible) {
                1 -> {
                    if (happenedInPast == 1) {
                        return StaticStrings.BASIC_DECOMPOSIT_ME_TYPE
                    }
                }
                0 -> {
                    if (happenedInPast == 1) {
                        return StaticStrings.BASIC_DECOMPOSIT_THEY_TYPE
                    }
                }
            }
        }
        return StaticStrings.BASIC_DECOMPOSIT_CARD
    }

    fun generateSessionPatternCodeAfterScreening(): Int {
        //System.out.println("last session pattern: " + activeScenario!!.listOfSessionPatterns.last())
        shouldDecompose = true
        when {
           //  here should not be any variations
            dangerousTriggerExists == 1 -> {
                shouldDecompose = false
                session.sessionPatternCode = StaticStrings.NO_DECOMPOSIT_BAD_TRIGGER_DETECTED_HW
                userRepo.listOfSessionPatterns.add(session.sessionPatternCode)
                return session.sessionPatternCode

            }

            realSituationExistsValue == 0 -> {
                shouldDecompose = false

                if (userRepo.listOfSessionPatterns.isNotEmpty()) {
                    var threshold = 4
                    if (userRepo.listOfSessionPatterns.size > 3) {
                        threshold = userRepo.listOfSessionPatterns.size
                    }
                    when {
                        !userRepo.listOfSessionPatterns.subList((threshold - 4),
                            (userRepo.listOfSessionPatterns.size)).contains(StaticStrings.NO_DECOMPOSIT_NO_TRIGGER_3_STORIES) -> {

                            session.sessionPatternCode = StaticStrings.NO_DECOMPOSIT_NO_TRIGGER_3_STORIES

                        }
                        !userRepo.listOfSessionPatterns.subList((threshold - 4),
                            (userRepo.listOfSessionPatterns.size)).contains(StaticStrings.BASIC_DECOMPOSIT_POTENTIAL_IMPROV) -> {

                            session.sessionPatternCode = StaticStrings.BASIC_DECOMPOSIT_POTENTIAL_IMPROV

                        }
                        !userRepo.listOfSessionPatterns.subList((threshold - 4),
                            (userRepo.listOfSessionPatterns.size)).contains(StaticStrings.DECOMPOSIT_POSITIVE_ASPECTS_OF_SITUATION) -> {

                            session.sessionPatternCode = StaticStrings.DECOMPOSIT_POSITIVE_ASPECTS_OF_SITUATION

                        }
                        !userRepo.listOfSessionPatterns.subList((threshold - 4),
                            (userRepo.listOfSessionPatterns.size)).contains(StaticStrings.NO_DECOMPOSIT_WORK_WITH_EXPECTATIONS) -> {

                            session.sessionPatternCode = StaticStrings.NO_DECOMPOSIT_WORK_WITH_EXPECTATIONS
                        }

                        else -> {
                            session.sessionPatternCode = StaticStrings.NO_DECOMPOSIT_NO_TRIGGER_CARD
                        }
                    }
                } else {
                    session.sessionPatternCode = StaticStrings.NO_DECOMPOSIT_NO_TRIGGER_CARD
                }
                userRepo.listOfSessionPatterns.add(session.sessionPatternCode)
                return session.sessionPatternCode
            }
        }
        session.sessionPatternCode = StaticStrings.NO_DECOMPOSIT_NO_TRIGGER_CARD
        userRepo.listOfSessionPatterns.add(session.sessionPatternCode)
        return 5
    }

//    val homeWorkRecord: HomeWork?
//        get()
//        {
//            try {
//                if (!newTaskShouldBeGenerated && user.currentWeeklyTask?.whenHomeworkSubmitted != null) {
//                    return null
//                }
//                val homeWork: HomeWork?
//                val homeWorkDetails: HomeWorkConfig?
//                var record: ExerciseBaseClass? = null
//                val indexOfNexthomework = user.weeklyTasks.size - 1//activeScenario!!.listOfSessionPatterns.size
//
//                val currentHomework: MutableList<String> = when (user.sortedListOfAccentuations.first().first) {
//                    StaticStrings.NARCISSIST -> {
//                        HomeWorkConfig.accessNarcissistTreatmentTask(appContext.resources)
//                    }
//                    StaticStrings.NEUROTIC -> {
//                        HomeWorkConfig.accessNeuroticTask(appContext.resources)
//                    }
//                    StaticStrings.MAZOCHIST -> {
//                        HomeWorkConfig.accessMazohistTreatmentTask(appContext.resources)
//                    }
//                    StaticStrings.PASSIVE_AGGRESSIVE -> {
//                        HomeWorkConfig.accessMazohistTreatmentTask(appContext.resources)
//                    }
//                    StaticStrings.DEPRESSIVE -> {
//                        HomeWorkConfig.accessDepressiveTreatmentTask(appContext.resources)
//                    }
//                    StaticStrings.PARANOID -> {
//                        HomeWorkConfig.accessParanoidTreatmentTask(appContext.resources)
//                    }
//                    StaticStrings.SCHIZOID -> {
//                        HomeWorkConfig.accessSchizoidTreatmentTask(appContext.resources)
//                    }
//                    StaticStrings.PSYCHOTIC -> {
//                        HomeWorkConfig.accessPsychoticTreatmentTask(appContext.resources)
//                    }
//                    else -> {
//                        HomeWorkConfig.accessHystericTreatmentTask(appContext.resources)
//                    }
//
//                }
//                homeWorkDetails = HomeWorkConfig(
//                    appContext.resources,
//                    currentHomework[indexOfNexthomework])
//                when (homeWorkDetails.className) {
//
//                    EmotionForRecord::class.java.canonicalName -> {
//                        record = EmotionForRecord(createdBy = user.id, problemID = activeScenario!!.id
//                            , description = homeWorkDetails.homeworkName.plus("")
//                                .plus(appContext.resources.getStringArray(R.array.emotions_negative)[sessionViewData!!.associatedEmotion ?: 0].toString())
//                            , stepsToComplete = homeWorkDetails.homeWorkSteps!!.parseIntoString()
//                            , isHomeWork = true, isCompleted = false)
//
//                    }
//                    RationalConviction::class.java.canonicalName -> {
//                        record = RationalConviction(createdBy = user.id, problemID = activeScenario!!.id
//                            , description = homeWorkDetails.homeworkName.plus(": ").plus(sessionViewData!!.badConviction)
//                            , stepsToComplete = homeWorkDetails.homeWorkSteps!!.parseIntoString()
//                            , isHomeWork = true, isCompleted = false)
//
//                    }
//                    Flashback::class.java.canonicalName -> {
//                        record = Flashback(createdBy = user.id, problemID = activeScenario!!.id
//                            , description = homeWorkDetails.homeworkName
//                            , stepsToComplete = homeWorkDetails.homeWorkSteps!!.parseIntoString()
//                            , isHomeWork = true, isCompleted = false)
//
//                    }
//                    Exercise::class.java.canonicalName -> {
//                        record = Exercise(createdBy = user.id, problemID = activeScenario!!.id
//                            , description = homeWorkDetails.homeworkName
//                            , stepsToComplete = homeWorkDetails.homeWorkSteps!!.parseIntoString()
//                            , isHomeWork = true, isCompleted = false)
//
//                    }
//                }
//                record?.apply {
//                    relatedToMythology = homeWorkDetails.symbolicLayerInvolved
//                }
//
//                homeWork = HomeWork(sessionID = sessionViewData!!.session.id, problemID = activeScenario!!.id, addedBy = user.id,
//                    type = record!!::class.java.canonicalName!!, recordName = record.description, scheduled = true)
//
//
//                homeWork.record = record
//                System.out.println("homework: " + homeWork.record?.description)
//                return homeWork
//
//            } catch (e: Exception) {
//                return null
//            }
//        }
//
//    private fun generateHomeWork(): HomeWork? {
//        return homeWorkRecord
//    }

    fun saveHomeWorkRecord() {

        generateSessionPatternCodeAfterScreening()
//        generateHomeWork()
//        homeWorkRecord?.apply {
//            GlobalScope.launch {
//                activeScenario!!.homeWork = this@apply
//                //System.out.println("homework: " + activeScenario!!.homeWork.toString())
//                databaseMethods.insertHomeWork(activeScenario!!.homeWork!!)
//
//                user.currentWeeklyTask?.associatedExerciseID = activeScenario!!.homeWork!!.record?.id
//                user.currentWeeklyTask?.let {
//                    databaseMethods.updateWeeklyTasks(it)
//                }
//
//                sessionViewData!!.session.homeworkName = activeScenario!!.homeWork!!.record!!.description
//                calculationCompleted.postValue(sessionViewData!!.session.homeworkName)
//
//                databaseMethods.updateSession(sessionViewData!!.session)
//                when (activeScenario!!.homeWork!!.record) {
//                    is RationalConviction -> {
//                        activeScenario!!.rationalConvictions.add(activeScenario!!.homeWork!!.record as RationalConviction)
//                        user.rationalConvictions.add(record as RationalConviction)
//                        databaseMethods.insertRationalConviction(activeScenario!!.homeWork!!.record as RationalConviction)
//                    }
//
//                    is Flashback -> {
//                        activeScenario!!.flashBacks.add(activeScenario!!.homeWork!!.record as Flashback)
//                        user.flashBacks.add(record as Flashback)
//                        databaseMethods.insertFlashback(activeScenario!!.homeWork!!.record as Flashback)
//                    }
//
//                    is EmotionForRecord -> {
//                        activeScenario!!.emotionsForRecords.add(activeScenario!!.homeWork!!.record as EmotionForRecord)
//                        user.processedEmotions.add(record as EmotionForRecord)
//                        databaseMethods.insertEmotionRecord(activeScenario!!.homeWork!!.record as EmotionForRecord)
//                    }
//
//                    is Exercise -> {
//                        activeScenario!!.tasks.add(activeScenario!!.homeWork!!.record as Exercise)
//                        user.exercises.add(record as Exercise)
//                        databaseMethods.insertExercise(activeScenario!!.homeWork!!.record as Exercise)
//                    }
//                }
//            }
//        } ?: run {  }
    }

    fun updateScenarioSetCompleted() {
//        val scenario = user.allActiveProblems[0]
//        scenario.isActive = false
//        scenario.completedDate = Date()
//        if (newProfile.email == "email") {
//            initNewProfile()
//        }
//        user.currentWeeklyTask = null
//        weeklyTaskSetup.value = true

    }

    fun generateStringsForConvictions(): MutableList<String> {
        val convictions = mutableListOf<String>()

//        when (sessionViewData!!.session.sessionPatternCode) {
//
//            StaticStrings.ALTER_HELPLESS_DECOMPOSIT -> {
//                appContext.resources.getStringArray(R.array.helpless_decomposition).forEach {
//                    convictions.add(it)
//                }
//
//            }
//            StaticStrings.ALTER_HYSTERIC_DECOMPOSIT -> {
//                appContext.resources.getStringArray(R.array.hysterical_decomposition).forEach {
//                    convictions.add(it)
//                }
//
//            }
//            StaticStrings.ALTER_OCD_DECOMPOSIT -> {
//                appContext.resources.getStringArray(R.array.ocd_decomposition).forEach {
//                    convictions.add(it)
//                }
//
//            }
//            StaticStrings.ALTER_NARCISS_DECOMPOSIT_THEY_TYPE -> {
//
//                appContext.resources.getStringArray(R.array.they_narciss_decomposition).forEach {
//                    convictions.add(it)
//                }
//
//            }
//            StaticStrings.ALTER_PSYCHOTIC_DECOMPOSIT -> {
//                appContext.resources.getStringArray(R.array.psychotic_decomposition).forEach {
//                    convictions.add(it)
//                }
//
//            }
//            StaticStrings.ALTER_NARCISS_DECOMPOSIT_ME_TYPE -> {
//                appContext.resources.getStringArray(R.array.me_narciss_decomposition).forEach {
//                    convictions.add(it)
//                }
//
//            }
//            StaticStrings.ALTER_NEUROTIC_DECOMPOSIT -> {
//                appContext.resources.getStringArray(R.array.neurothic_decomposition).forEach {
//                    convictions.add(it)
//                }
//
//            }
//            StaticStrings.BASIC_DECOMPOSIT_ME_TYPE -> {
//                appContext.resources.getStringArray(R.array.base_me_decomposition).forEach {
//                    convictions.add(it)
//                }
//            }
//            StaticStrings.BASIC_DECOMPOSIT_THEY_TYPE -> {
//                appContext.resources.getStringArray(R.array.base_they_decomposition).forEach {
//                    convictions.add(it)
//                }
//            }
//        }
        return convictions
    }

}