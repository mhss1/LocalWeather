package com.mhss.app.localweather.domain.repository

import com.mhss.app.localweather.data.remote.dto.WeatherResponseDto

interface WeatherRepository {

    suspend fun getWeather(lat: Double, lon: Double): WeatherResponseDto

    suspend fun getWeatherJsonFromCache(): String

    suspend fun saveWeatherToCache(weatherJson: String)
}