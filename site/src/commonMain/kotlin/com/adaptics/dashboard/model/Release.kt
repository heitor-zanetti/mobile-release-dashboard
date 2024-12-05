package com.adaptics.dashboard.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Release(
    @SerialName("id")
    val id: String = "",

    @SerialName("date_created")
    val createdAt: String = "",

    @SerialName("platform")
    val platform: String,

    @SerialName("organization")
    val organization: String,

    @SerialName("track")
    val track: String,

    @SerialName("is_draft")
    val isDraft: Boolean = false,

    @SerialName("version")
    val version: String,

    @SerialName("status")
    val status: ReleaseStatus
)

@Serializable
enum class ReleaseStatus(val value: String) {
    @SerialName("in_progress")
    InProgress("in_progress"),

    @SerialName("drafted")
    Drafted("drafted"),

    @SerialName("deployed")
    Deployed("deployed");

    companion object {
        fun withValue(value: String) = ReleaseStatus.entries.find {
            it.value == value
        } ?: throw IllegalArgumentException("ReleaseStatus $value not recognized.")
    }
}
