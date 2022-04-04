package com.mhss.app.localweather.data.remote

import com.mhss.app.localweather.BuildConfig.OPEN_WEATHER_API_KEY
import com.mhss.app.localweather.data.remote.dto.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("onecall")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String = "minutely",
        @Query("units") units: String = "metric",
        @Query("appid") appId: String = OPEN_WEATHER_API_KEY
    ): WeatherResponseDto
}