package com.mhss.app.localweather.domain.model


data class Hourly(
    val time: Int,
    val rainProp: Int,
    val temp: Double,
    val weather: List<WeatherData>,
)
