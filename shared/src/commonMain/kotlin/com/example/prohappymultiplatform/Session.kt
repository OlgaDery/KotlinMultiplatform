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
    val problemID: String)
{
    @SerialName("when_added")
    var whenAdded: Long = Platform().date()
    @SerialName("severity")
    var severity: Int = 0
    @SerialName("irrational_conviction_code")
    var irrationalConvictionCode: Int = -1
    @SerialName("emotion_code")
    var emotionCode = -1
    @SerialName("critical_condition_confirmed")
    var criticalConditionConfirmed = false
    @SerialName("dangerous_trigger_confirmed")
    var dangerousTriggerConfirmed = false
    @SerialName("abuse_confirmed")
    var abuseConfirmed = false
    @SerialName("own_aggression_confirmed")
    var ownAggressionConfirmed = false
    @SerialName("significant_person_involved")
    var significantPersonInvolved = false
    @SerialName("accept_responsibility")
    var acceptResponsibility = true
    @SerialName("hidden_reason_code")
    var hiddenReasonCode = -1
    @SerialName("session_pattern_code")
    var sessionPatternCode: Int = -1
    @SerialName("homework_name")
    var homeworkName: String? = null
    @SerialName("message_to_future")
    var messageToFuture: String? = null

}