package com.example.prohappymultiplatform.android

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cache.DatabaseDriverFactory
import com.example.testapp.SessionRepo
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomeViewModel: ViewModel(), CoroutineScope {

    var sessionRepo: SessionRepo? = null
        private set

    val numberOfSessions = MutableLiveData<Int>(-1)


    fun initRepo(context: Context) {
        if (sessionRepo == null) {
            launch {
                sessionRepo = SessionRepo(DatabaseDriverFactory(context))
                selectSessions(false)
            }
        }
    }

    fun selectSessions(clear: Boolean) {
        launch {
            val number = withContext(coroutineContext) {
                sessionRepo?.selectAllSessions(clear = clear)
            }
            numberOfSessions.postValue(number)
        }
    }

    fun createSession(selectedEmotion: Int, severity: Int, userResponsible: Boolean) {
        launch {
            withContext(coroutineContext) {
                sessionRepo?.saveSession(
                    selectedEmotion, severity, userResponsible
                )
                numberOfSessions.postValue(sessionRepo?.listOfSessionPatterns?.size)
            }
        }
    }

    fun saveMessageToFuture(message: String) {
        launch {
            withContext(coroutineContext) {
                sessionRepo?.saveMessageToFuture(message)
            }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

}