package com.mhss.app.localweather.domain.use_case

import android.location.Geocoder
import com.google.gson.Gson
import com.mhss.app.localweather.data.remote.dto.toWeather
import com.mhss.app.localweather.domain.repository.LocationRepository
import com.mhss.app.localweather.domain.repository.WeatherRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@Suppress("BlockingMethodInNonBlockingContext")
class RefreshWeather @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository,
    private val gson: Gson,
    private val geocoder: Geocoder
) {

    suspend operator fun invoke() {
        if (locationRepository.getLatLng().latitude == 0.0 && locationRepository.getLatLng().longitude == 0.0) {
            return
        }
        coroutineScope {
            val weather = async {
                weatherRepository
                    .getWeather(
                        locationRepository.getLatLng().latitude,
                        locationRepository.getLatLng().longitude
                    ).toWeather()
            }
            val city = async {
                val c = geocoder.getFromLocation(
                    locationRepository.getLatLng().latitude,
                    locationRepository.getLatLng().longitude,
                    1
                )
                if (c.isNotEmpty()) (c[0].locality ?: "") else ""
            }
            val weatherJson = gson.toJson(weather.await())
            weatherRepository.saveWeatherToCache(weatherJson)
            locationRepository.saveCityName(city.await())
        }
    }

}