package com.example.prohappymultiplatform.android

import android.content.Context
import androidx.lifecycle.ViewModel
import cache.DatabaseDriverFactory
import com.example.testapp.SessionRepo
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomeViewModel: ViewModel(), CoroutineScope {

    var sessionRepo: SessionRepo? = null
        private set

    fun initRepo(context: Context) {
        if (sessionRepo == null) {
            launch {
                sessionRepo = SessionRepo(DatabaseDriverFactory(context))
                withContext(coroutineContext) {
                    sessionRepo?.selectAllSessions(clear = false)
                }
            }
        }
    }

    fun createSession(selectedConviction: Int, selectedEmotion: Int,
                      criticalConditionConfirmed: Boolean, severity: Int,
                      triggerExists: Boolean, userResponsible: Boolean) {
        launch {
            withContext(coroutineContext) {
                sessionRepo?.saveSession(
                    selectedConviction, selectedEmotion, criticalConditionConfirmed, severity,
                    triggerExists, userResponsible
                )
            }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

}