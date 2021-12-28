package com.example.testapp

import cache.Database
import cache.DatabaseDriverFactory

class SessionRepo(val userRepo: UserRepo, databaseDriverFactory: DatabaseDriverFactory) {

    private val database = Database(databaseDriverFactory)
    var selectedConviction = ""
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
//        GlobalScope.launch {
//            withContext(Dispatchers.Default) {
//                previousSessions.addAll(selectAllSessionsOnAppInit())
//            }
//        }
    }

    @Throws(Exception::class) suspend fun selectAllSessionsOnAppInit(): List<Session> {
        return database.getAllSessions()
    }

    @Throws(Exception::class) suspend fun saveMessageToFuture(message: String) {
        return database.updateMessage(message, session.id)
    }

    @Throws(Exception::class) suspend fun generateDecompositionPatternForDecomposableSession(isDefault: Boolean = false) {
        val value = setUpCurrentSessionDecompositionPattern(isDefault)
        value.apply {
            session.sessionPatternCode = this
            database.updateSessionCode(this, session.id)
            userRepo.listOfSessionPatterns.add(this)
        }
    }

    @Throws(Exception::class) suspend fun generateSessionCodeAfterInitialScreening() {
        val value = generateSessionPatternCodeAfterScreening()
        value.apply {
            session.sessionPatternCode = this
            userRepo.listOfSessionPatterns.add(this)
            database.updateSessionCode(this, session.id)
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
                return StaticStrings.NO_DECOMPOSIT_BAD_TRIGGER_DETECTED_HW
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
                            return StaticStrings.NO_DECOMPOSIT_NO_TRIGGER_3_STORIES

                        }
                        !userRepo.listOfSessionPatterns.subList((threshold - 4),
                            (userRepo.listOfSessionPatterns.size)).contains(StaticStrings.BASIC_DECOMPOSIT_POTENTIAL_IMPROV) -> {
                            return StaticStrings.BASIC_DECOMPOSIT_POTENTIAL_IMPROV

                        }
                        !userRepo.listOfSessionPatterns.subList((threshold - 4),
                            (userRepo.listOfSessionPatterns.size)).contains(StaticStrings.DECOMPOSIT_POSITIVE_ASPECTS_OF_SITUATION) -> {
                            return StaticStrings.DECOMPOSIT_POSITIVE_ASPECTS_OF_SITUATION

                        }
                        !userRepo.listOfSessionPatterns.subList((threshold - 4),
                            (userRepo.listOfSessionPatterns.size)).contains(StaticStrings.NO_DECOMPOSIT_WORK_WITH_EXPECTATIONS) -> {
                            return StaticStrings.NO_DECOMPOSIT_WORK_WITH_EXPECTATIONS
                        }

                        else -> {
                            return StaticStrings.NO_DECOMPOSIT_NO_TRIGGER_CARD
                        }
                    }
                } else {
                    return StaticStrings.NO_DECOMPOSIT_NO_TRIGGER_CARD
                }
            }
        }
        return StaticStrings.NO_DECOMPOSIT_NO_TRIGGER_CARD
    }

}