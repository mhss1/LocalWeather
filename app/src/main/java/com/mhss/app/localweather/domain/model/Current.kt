package com.mhss.app.localweather.domain.model


data class Current(
    val time: Int,
    val feelsLike: Double,
    val humidity: Int,
    val sunrise: Int,
    val sunset: Int,
    val temp: Double,
    val uvi: Double,
    val weather: List<WeatherData>,
    val windSpeed: Double
)
