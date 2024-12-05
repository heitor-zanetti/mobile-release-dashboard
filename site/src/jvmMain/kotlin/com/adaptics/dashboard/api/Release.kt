package com.adaptics.dashboard.api

import com.adaptics.dashboard.model.Release
import com.adaptics.dashboard.model.ReleaseStatus
import com.adaptics.dashboard.respondWithError
import com.adaptics.dashboard.source.ReleaseDataSource
import com.adaptics.dashboard.util.getCurrentDateFormatted
import com.adaptics.dashboard.util.getCurrentTime
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.http.HttpMethod
import com.varabyte.kobweb.api.http.readBodyText
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import java.util.UUID

@Api(routeOverride = "release")
suspend fun get(context: ApiContext) {
    if (context.req.method != HttpMethod.GET) {
        context.respondWithError(500, "Error: Only GET supported")
        return
    }

    val requestParams = context.req.params
    val requestedId= requestParams["id"]
    val requestedPlatform = requestParams["platform"]
    val requestedOrganization = requestParams["organization"]
    val requestedTrack = requestParams["track"]
    val requestedIsDraft = requestParams["isDraft"]
    val requestedVersion = requestParams["version"]
    val requestedStatus = requestParams["status"]

    val results = ReleaseDataSource.releases.filter { release ->
        val idFilter = requestedId?.let { release.id == it } ?: true
        val platformFilter = requestedPlatform?.let { release.platform == it } ?: true
        val organizationFilter = requestedOrganization?.let { release.organization == it } ?: true
        val trackFilter = requestedTrack?.let { release.track == it } ?: true
        val isDraftFilter = requestedIsDraft?.let { release.isDraft == it.toBoolean() } ?: true
        val versionFilter = requestedVersion?.let { release.version == it } ?: true
        val statusFilter = requestedStatus?.let { release.status == ReleaseStatus.withValue(it) } ?: true

        idFilter
                && platformFilter
                && organizationFilter
                && trackFilter
                && isDraftFilter
                && versionFilter
                && statusFilter

    }.sortedByDescending { it.createdAt }

    try {
        val body = Json.encodeToString(ListSerializer(Release.serializer()), results)
        context.res.setBodyText(body)

        context.res.status = 200
    } catch (e: Exception) {
        context.respondWithError(500, "Error: ${e.message}")
    }
}

@Api(routeOverride = "release/create")
suspend fun createRelease(context: ApiContext) {
    if (context.req.method != HttpMethod.POST) {
        return
    }

    val body = context.req.readBodyText() ?: run {
        context.respondWithError(400, "Release not provided in request body.")
        return
    }

    try {
        val release = Json.decodeFromString<Release>(body)
        ReleaseDataSource
            .releases
            .add(
                release.copy(
                    id = UUID.randomUUID().toString(),
                    createdAt = getCurrentTime().toString()
                )
            )

        context.res.status = 200
    } catch (e: Exception) {
        context.respondWithError(400, "${e.message}")
    }
}