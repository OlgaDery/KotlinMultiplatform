package com.example.testapp

import cache.Database
import cache.DatabaseDriverFactory
import kotlinx.coroutines.*
import kotlin.collections.List
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random.Default.nextInt

class SessionRepo(databaseDriverFactory: DatabaseDriverFactory?): CoroutineScope {

    var numberOfCards = 30

    private val database = databaseDriverFactory?.let { Database(it) }
    var session: Session
        private set

    val listOfSessionPatterns = mutableListOf<Int>()

    init {
        session = Session(addedBy = "someone", problemID = "default")
    }

    @Throws(Exception::class) suspend fun selectAllSessions(clear: Boolean = false): Int {
        listOfSessionPatterns.clear()
        if (clear) {
            database?.deleteAllRecords()
        } else {
            listOfSessionPatterns.addAll(database?.getAllSessions()?.map { it.sessionPatternCode }?: mutableListOf())
            println("selected: " + database?.getAllSessions()?.size)
        }
        return listOfSessionPatterns.size
    }

    @Throws(Exception::class) suspend fun saveMessageToFuture(message: String) {
        database?.updateMessage(message, session.id)
    }

    @Throws(Exception::class) suspend fun generateSessionCodeAfterInitialScreening() {

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

            val value = generateRandomNumber()
            value.apply {
                session.sessionPatternCode = this
                listOfSessionPatterns.add(this)
            }
            database?.createSession(this)
        }
    }

    fun generateRandomNumber(): Int {
        var randomNumGenerated = false
        var randomNum = 1
        val listToCompareTo = mutableListOf<Int>()
        if (listOfSessionPatterns.size <= 20) {
            listToCompareTo.addAll(listOfSessionPatterns)
        } else {
            listToCompareTo.addAll(listOfSessionPatterns.subList((listOfSessionPatterns.size - 21),
                (listOfSessionPatterns.size-1)))
        }
        while (!randomNumGenerated) {
            if (listToCompareTo.contains(randomNum) || randomNum == 0) {
                randomNum = nextInt(numberOfCards)
            } else {
                randomNumGenerated = true
            }
        }
        return randomNum
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

}