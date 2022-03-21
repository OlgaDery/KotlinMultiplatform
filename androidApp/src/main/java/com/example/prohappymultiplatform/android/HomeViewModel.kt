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
                val sessions = withContext(coroutineContext) {
                    sessionRepo?.selectAllSessionsOnAppInit()
                }
                sessions?.let{
                    sessionRepo?.listOfSessionPatterns?.addAll(it.map { it.sessionPatternCode })
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

    fun computeCardCode() {
        launch {
            withContext(coroutineContext) {
                sessionRepo?.generateSessionCodeAfterInitialScreening()
            }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

}