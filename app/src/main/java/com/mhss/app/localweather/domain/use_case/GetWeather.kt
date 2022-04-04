package com.mhss.app.localweather.domain.use_case

import com.google.gson.Gson
import com.mhss.app.localweather.domain.model.Weather
import com.mhss.app.localweather.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeather
    @Inject constructor(
        private val weatherRepository: WeatherRepository,
        private val gson: Gson
        ) {

    suspend operator fun invoke(): Weather {
        val weatherJson = weatherRepository.getWeatherJsonFromCache()
        return if (weatherJson.isBlank()) {
            Weather.empty()
        } else
            gson.fromJson(weatherJson, Weather::class.java)
    }
}