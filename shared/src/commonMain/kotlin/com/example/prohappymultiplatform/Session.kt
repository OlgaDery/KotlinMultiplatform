package com.example.testapp

import com.example.prohappymultiplatform.Platform
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Session(
    @SerialName("id")
    var id: String = Platform().randomUUID(),
    @SerialName("added_by")
    val addedBy: String,
    @SerialName("when_added")
    var whenAdded: Int = Platform().date().toInt(),
    @SerialName("severity")
    var severity: Int = 0,
    @SerialName("emotion_code")
    var emotionCode: Int = -1,
    @SerialName("accept_responsibility")
    var acceptResponsibility: Boolean = true,
    @SerialName("session_pattern_code")
    var sessionPatternCode: Int = -1,
    @SerialName("message_to_future")
    var messageToFuture: String? = null
)