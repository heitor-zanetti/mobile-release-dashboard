package com.adaptics.dashboard

import kotlinx.serialization.Serializable

@Serializable
sealed class ApiResponse {
    @Serializable
    data class Success<T>(val data: T): ApiResponse()

    @Serializable
    data class Failure(val errorMessage: String): ApiResponse()
}