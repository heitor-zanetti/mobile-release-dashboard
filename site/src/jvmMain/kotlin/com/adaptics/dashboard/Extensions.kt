package com.adaptics.dashboard

import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.json.Json

fun ApiContext.respondWithError(statusCode: Int, errorMessage: String) {
    with(this.res) {
        this.status = statusCode
        this.setBodyText(
            Json.encodeToString(ApiResponse.Failure.serializer(), ApiResponse.Failure(errorMessage))
        )
    }
}