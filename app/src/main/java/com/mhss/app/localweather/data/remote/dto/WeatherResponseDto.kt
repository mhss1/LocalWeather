package com.mhss.app.localweather.data.remote.dto

data class WeatherResponseDto(
    val alerts: List<AlertDto>?,
    val current: CurrentDto?,
    val daily: List<DailyDto>?,
    val hourly: List<HourlyDto>?,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)