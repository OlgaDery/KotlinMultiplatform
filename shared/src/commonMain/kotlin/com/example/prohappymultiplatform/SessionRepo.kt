package com.example.testapp

import cache.Database
import cache.DatabaseDriverFactory
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SessionRepo(val userRepo: UserRepo, databaseDriverFactory: DatabaseDriverFactory): CoroutineScope {

    private val database = Database(databaseDriverFactory)
    var session: Session
        private set
    var cardSelected = false

    init {
        session = Session(userRepo.user.id, userRepo.user.id, "")
    }

    @Throws(Exception::class) suspend fun selectAllSessionsOnAppInit(handler: Boolean = false): List<Session> {
        return database.getAllSessions()
    }

    @Throws(Exception::class) suspend fun saveMessageToFuture(message: String) {
        return database.updateMessage(message, session.id)
    }

    @Throws(Exception::class) suspend fun generateSessionCodeAfterInitialScreening() {
        val value = generateSessionPatternCodeAfterScreening()
        value.apply {
            session.sessionPatternCode = this
            userRepo.listOfSessionPatterns.add(this)
            database.updateSessionCode(this, session.id)
        }
    }

    @Throws(Exception::class) suspend fun saveSession(selectedConviction: Int, selectedEmotion: Int,
                                                      criticalConditionConfirmed: Boolean, severity: Int,
                                                      triggerExists: Boolean, userResponsible: Boolean) {
        session.apply {
            this.severity = severity
            this.irrationalConvictionCode = selectedConviction
            this.emotionCode = selectedEmotion
            this.dangerousTriggerConfirmed = triggerExists
            this.acceptResponsibility = userResponsible
            this.criticalConditionConfirmed = criticalConditionConfirmed

            database.createSession(this)
        }
    }

    private fun generateSessionPatternCodeAfterScreening(): Int {
        //System.out.println("last session pattern: " + activeScenario!!.listOfSessionPatterns.last())
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

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

}