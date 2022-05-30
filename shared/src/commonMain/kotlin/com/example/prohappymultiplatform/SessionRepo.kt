package com.example.testapp

import cache.Database
import cache.DatabaseDriverFactory
import kotlinx.coroutines.*
import kotlin.collections.List
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random.Default.nextInt

class SessionRepo(databaseDriverFactory: DatabaseDriverFactory?) {

    var numberOfCards = 30

    private val database = databaseDriverFactory?.let { Database(it) }
    var session: Session
        private set

    val listOfSessionPatterns = mutableListOf<Int>()

    init {
        session = Session(addedBy = "someone")
    }

    @Throws(Exception::class) suspend fun selectAllSessions(clear: Boolean = false): Int {
        listOfSessionPatterns.clear()
        if (clear) {
            database?.deleteAllRecords()
        } else {
            listOfSessionPatterns.addAll(database?.getAllSessions()?.map { it.sessionPatternCode }?: mutableListOf())
        }
        return listOfSessionPatterns.size
    }

    @Throws(Exception::class) suspend fun saveMessageToFuture(message: String) {
        database?.updateMessage(message, session.id)
    }

    @Throws(Exception::class) suspend fun saveSession(selectedEmotion: Int, severity: Int,
                                                      userResponsible: Boolean) {
        session.apply {
            this.severity = severity
            this.emotionCode = selectedEmotion
            this.acceptResponsibility = userResponsible

            val value = generateRandomNumber(listOfSessionPatterns)
            value.apply {
                session.sessionPatternCode = this
                listOfSessionPatterns.add(this)
            }
            database?.createSession(this)
        }
    }

    fun generateRandomNumber(listOfPatterns: MutableList<Int>): Int {
        var randomNumGenerated = false
        var randomNum = 1
        val listToCompareTo = mutableListOf<Int>()
        if (listOfPatterns.size <= 20) {
            listToCompareTo.addAll(listOfPatterns)
        } else {
            listToCompareTo.addAll(listOfPatterns.subList((listOfPatterns.size - 21),
                (listOfPatterns.size-1)))
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

}