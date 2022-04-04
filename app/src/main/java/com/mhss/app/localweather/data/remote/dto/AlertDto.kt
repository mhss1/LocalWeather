package com.mhss.app.localweather.data.remote.dto

data class AlertDto(
    val description: String?,
    val end: Int?,
    val event: String?,
    val sender_name: String?,
    val start: Int?,
    val tags: List<String>?
)