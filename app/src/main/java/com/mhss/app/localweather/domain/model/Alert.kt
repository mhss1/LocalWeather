package com.mhss.app.localweather.domain.model


data class Alert(
    val description: String,
    val end: Int,
    val title: String,
    val source: String,
    val start: Int,
)
