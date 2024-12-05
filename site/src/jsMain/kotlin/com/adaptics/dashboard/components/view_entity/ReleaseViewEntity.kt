package com.adaptics.dashboard.components.view_entity

import com.adaptics.dashboard.model.Release
import com.adaptics.dashboard.model.ReleaseStatus
import com.adaptics.dashboard.util.timeStampToDate

class ReleaseViewEntity(
    val date: String,
    val platformData: ReleasePlatformViewEntity,
    val organization: String,
    val version: String,
    val status: String
)

sealed class ReleasePlatformViewEntity(
    val platformLogo: String
) {
    data object Android: ReleasePlatformViewEntity(
        "https://img.icons8.com/fluency/48/android-os.png"
    )

    data object Ios: ReleasePlatformViewEntity(
        "https://img.icons8.com/?size=100&id=QQuxmZUdQp4s&format=png&color=1c1c1c"
    )

    data object Unsupported: ReleasePlatformViewEntity(
        "https://img.icons8.com/help?size=100&format=png&color=1c1c1c"
    )
}

fun Release.toReleaseCardViewEntity() = ReleaseViewEntity(
    date = timeStampToDate(this.createdAt),
    platformData = this.platform.platformToReleaseCardPlatform(),
    organization = this.organization.organizationToUiString(),
    version = this.version,
    status = this.status.toUiString()
)

private fun ReleaseStatus.toUiString() = when(this) {
    ReleaseStatus.InProgress -> "IN PROGRESS"
    ReleaseStatus.Drafted -> "DRAFTED"
    ReleaseStatus.Deployed -> "DEPLOYED"
}

private fun String.platformToReleaseCardPlatform() = when(this) {
    "android" -> ReleasePlatformViewEntity.Android
    "ios" -> ReleasePlatformViewEntity.Ios
    else -> ReleasePlatformViewEntity.Unsupported
}

private fun String.organizationToUiString() = when(this) {
    "aga" -> "Aga"
    "cookidoo" -> "Cookidoo"
    "hestan" -> "Hestan"
    "instantbrands" -> "Instant Brands"
    "kenwood" -> "Kenwood"
    "panasonic" -> "Panasonic"
    "viking" -> "Viking"
    "zenkitchen" -> "Zenkitchen"
    else -> this
}