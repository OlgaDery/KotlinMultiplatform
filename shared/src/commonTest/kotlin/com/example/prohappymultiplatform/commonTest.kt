package com.example.prohappymultiplatform

import com.example.testapp.SessionRepo
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SessionRepoTest {

    @Test
    fun test_RandomNumberGeneration_20AndLessItemsInList() {
        val sessionRepo = SessionRepo(null)
        var count = 0
        while (count <= 20) {
            val randonInt = sessionRepo.generateRandomNumber(sessionRepo.listOfSessionPatterns)
            assertFalse(sessionRepo.listOfSessionPatterns.contains(randonInt))
            sessionRepo.listOfSessionPatterns.add(randonInt)
            count++
        }
    }

    @Test
    fun test_RandomNumberGeneration_MoreThan20ItemsInList() {
        val sessionRepo = SessionRepo(null)
        var count = 0
        while (count <= 100) {
            val randomNum = sessionRepo.generateRandomNumber(sessionRepo.listOfSessionPatterns)
            if (count > 20) {
                assertFalse(sessionRepo.listOfSessionPatterns.subList((sessionRepo.listOfSessionPatterns.size - 21),
                    (sessionRepo.listOfSessionPatterns.size-1)).contains(randomNum))

            }
            sessionRepo.listOfSessionPatterns.add(randomNum)
            count++
        }
    }

}