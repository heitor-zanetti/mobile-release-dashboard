package com.adaptics.dashboard.pages

import androidx.compose.runtime.*
import com.adaptics.dashboard.components.ReleasePage
import com.adaptics.dashboard.components.view_entity.ReleaseViewEntity
import com.adaptics.dashboard.components.view_entity.toReleaseCardViewEntity
import com.adaptics.dashboard.model.Release
import com.varabyte.kobweb.browser.api
import com.varabyte.kobweb.core.Page
import kotlinx.browser.window
import kotlinx.serialization.json.Json

@Page
@Composable
fun HomePage() {
    val releases = remember { mutableStateListOf<ReleaseViewEntity>() }

    ReleasePage(releaseCardItems = releases)

    LaunchedEffect(Unit) {
        releases.clear()
        releases.addAll(getReleases().map { it.toReleaseCardViewEntity() })
    }
}

private suspend fun getReleases(): List<Release> {
    return window.api.get("release").let { listBytes ->
        Json.decodeFromString(listBytes.decodeToString())
    }
}