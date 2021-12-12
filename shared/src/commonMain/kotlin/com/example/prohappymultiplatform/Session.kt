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
    var whenAdded: Long = Platform().date()
    var howStrong: Int = 0
    var irrationalConvictionCode: Int = -1
    var emotionCode = -1
    var homeworkName: String? = null

    var sessionPatternCode: Int = -1
    //TODO adding new fields

    var messageToFuture: String? = null
    var criticalConditionConfirmed = false
    var dangerousTriggerConfirmed = false
    var externalAbuseConfirmed = false
    var ownAggressionConfirmed = false
    var significantPersonInvolved = false
    var acceptOwnResponsibility = true
    var hiddenReasonCode = -1
    var feelsLikeUnique = false

}