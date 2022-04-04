package com.mhss.app.localweather.domain.model


data class Daily(
    val date: Int,
    val feelsLike: FeelsLike,
    val humidity: Int,
    val moonPhase: MoonPhase,
    val moonRise: Int,
    val moonSet: Int,
    val rainProp: Int,
    val pressure: Int,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val uvi: Double,
    val weather: List<WeatherData>,
    val windSpeed: Double
)
