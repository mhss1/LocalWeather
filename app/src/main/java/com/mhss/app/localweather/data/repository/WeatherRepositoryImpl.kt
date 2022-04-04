package com.mhss.app.localweather.data.repository

import com.mhss.app.localweather.data.local.InternalStorageManager
import com.mhss.app.localweather.data.remote.WeatherApi
import com.mhss.app.localweather.data.remote.dto.WeatherResponseDto
import com.mhss.app.localweather.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor (
    private val weatherApi: WeatherApi,
    private val internalStorageManager: InternalStorageManager,
    private val ioDispatcher: CoroutineDispatcher
    ): WeatherRepository {

    override suspend fun getWeather(lat: Double, lon: Double): WeatherResponseDto {
        return withContext(ioDispatcher) {
            weatherApi.getWeather(lat, lon)
    }
}

    override suspend fun getWeatherJsonFromCache(): String  {
        return withContext(ioDispatcher){
            internalStorageManager.readFromInternalStorage()
        }
    }

    override suspend fun saveWeatherToCache(weatherJson: String) {
        withContext(ioDispatcher){
            internalStorageManager.writeToInternalStorage(weatherJson)
        }
    }
}