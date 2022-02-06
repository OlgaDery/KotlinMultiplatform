package com.example.prohappymultiplatform

import com.example.testapp.SessionRepo
import com.example.testapp.User
import com.example.testapp.UserRepo
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() {
        assertTrue(Greeting().greeting().contains("Hello"), "Check 'Hello' is mentioned")
    }

    @Test
    fun testRandomNumberGeneration() {
        val sessionRepo = SessionRepo(UserRepo(User(1)), null)
        mutableListOf<Int>().apply {
            this.add(4)
            this.add(16)
            this.add(0)
            this.add(7)
            sessionRepo.userRepo.listOfSessionPatterns.addAll(this)
            assertFalse(this.contains(sessionRepo.generateRandomNumber()))
        }


    }
}