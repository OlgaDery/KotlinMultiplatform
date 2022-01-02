package com.example.prohappymultiplatform.android

import android.content.Context
import androidx.lifecycle.ViewModel
import cache.DatabaseDriverFactory
import com.example.testapp.SessionRepo
import com.example.testapp.User
import com.example.testapp.UserRepo
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomeViewModel: ViewModel(), CoroutineScope {

    var sessionRepo: SessionRepo? = null

    fun initRepo(context: Context) {
        if (sessionRepo == null) {
            launch {
                sessionRepo = SessionRepo(UserRepo(User(1)), DatabaseDriverFactory(context))
                val sessions = withContext(this.coroutineContext) {
                    sessionRepo?.selectAllSessionsOnAppInit()
                }
                sessions?.let{
                    sessionRepo?.userRepo?.listOfSessionPatterns?.addAll(it.map { it.sessionPatternCode })
                }
            }
        }
    }

    fun createSession(selectedConviction: Int, selectedEmotion: Int,
                      criticalConditionConfirmed: Boolean, severity: Int,
                      triggerExists: Boolean, userResponsible: Boolean) {
        launch {
            sessionRepo?.saveSession(
                selectedConviction, selectedEmotion, criticalConditionConfirmed, severity,
                triggerExists, userResponsible
            )
        }
    }

    fun proceedToExercise() {
        launch {
            sessionRepo?.generateSessionCodeAfterInitialScreening()
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

}