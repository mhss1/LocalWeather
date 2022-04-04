package com.mhss.app.localweather.domain.model


data class Weather(
    val alerts: List<Alert>,
    val current: Current?,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
){
    companion object {
        fun empty() = Weather(emptyList(), null, emptyList(), emptyList())
    }
}