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
    @SerialName("problem_id")
    val problemID: String,
    @SerialName("when_added")
    var whenAdded: Int = Platform().date().toInt(),
    @SerialName("severity")
    var severity: Int = 0,
    @SerialName("irrational_conviction_code")
    var irrationalConvictionCode: Int = -1,
    @SerialName("emotion_code")
    var emotionCode: Int = -1,
    @SerialName("critical_condition_confirmed")
    var criticalConditionConfirmed: Boolean = false,
    @SerialName("dangerous_trigger_confirmed")
    var dangerousTriggerConfirmed: Boolean = false,
    @SerialName("abuse_confirmed")
    var abuseConfirmed: Boolean = false,
    @SerialName("own_aggression_confirmed")
    var ownAggressionConfirmed: Boolean = false,
    @SerialName("significant_person_involved")
    var significantPersonInvolved: Boolean = false,
    @SerialName("accept_responsibility")
    var acceptResponsibility: Boolean = true,
    @SerialName("hidden_reason_code")
    var hiddenReasonCode: Int = -1,
    @SerialName("session_pattern_code")
    var sessionPatternCode: Int = -1,
    @SerialName("homework_name")
    var homeworkName: String? = null,
    @SerialName("message_to_future")
    var messageToFuture: String? = null
)