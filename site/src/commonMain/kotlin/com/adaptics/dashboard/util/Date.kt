package com.adaptics.dashboard.util

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun getCurrentTime() = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

fun getCurrentDateFormatted() = getCurrentTime().date.formatted()

fun timeStampToDate(timestamp: String) = LocalDateTime.parse(timestamp).date.formatted()

fun LocalDate.formatted(): String {
    val day = this.dayOfMonth.toString().padStart(2, '0')
    val month = this.monthNumber.toString().padStart(2, '0')
    val year = this.year

    return "$day/$month/$year"
}