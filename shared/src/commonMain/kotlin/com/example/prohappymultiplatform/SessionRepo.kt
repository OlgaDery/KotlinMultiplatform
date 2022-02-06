package com.example.testapp

import cache.Database
import cache.DatabaseDriverFactory
import kotlinx.coroutines.*
import java.util.*
import kotlin.collections.List
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class SessionRepo(val userRepo: UserRepo, databaseDriverFactory: DatabaseDriverFactory?): CoroutineScope {

    private val database = databaseDriverFactory?.let { Database(it) }
    var session: Session
        private set

    init {
        session = Session(userRepo.user.id, userRepo.user.id, "")
    }

    @Throws(Exception::class) suspend fun selectAllSessionsOnAppInit(handler: Boolean = false): List<Session> {
        return database?.getAllSessions() ?: mutableListOf()
    }

    @Throws(Exception::class) suspend fun saveMessageToFuture(message: String) {
        database?.updateMessage(message, session.id)
    }

    @Throws(Exception::class) suspend fun generateSessionCodeAfterInitialScreening() {
        val value = generateRandomNumber()
        value.apply {
            session.sessionPatternCode = this
            userRepo.listOfSessionPatterns.add(this)
            database?.updateSessionCode(this, session.id)
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

            database?.createSession(this)
        }
    }

    fun generateMessageAfterScreening(): String {
        return ""
    }

    fun generateRandomNumber(): Int {
        var randomNumGenerated = false
        var randomNum = 0
        val listToCompareTo = mutableListOf<Int>()
        if (userRepo.listOfSessionPatterns.size <= 20) {
            listToCompareTo.addAll(userRepo.listOfSessionPatterns)
        } else {
            listToCompareTo.addAll(userRepo.listOfSessionPatterns.subList((userRepo.listOfSessionPatterns.size - 21),
                (userRepo.listOfSessionPatterns.size-1)))
        }
        while (!randomNumGenerated) {
            if (listToCompareTo.contains(randomNum)) {
                randomNum = nextInt(76)
            } else {
                randomNumGenerated = true
            }
        }
        return randomNum
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

}