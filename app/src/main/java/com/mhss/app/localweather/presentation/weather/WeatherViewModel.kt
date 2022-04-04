package com.mhss.app.localweather.presentation.weather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhss.app.localweather.domain.model.Weather
import com.mhss.app.localweather.domain.use_case.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUseCases: WeatherUseCases,
    private val getCityName: GetCityName
) : ViewModel() {

    var uiState by mutableStateOf(UiState())
    private set

    private var refreshWeatherJob: Job? = null

    fun onEvent(event: WeatherEvent) {
        when (event) {
            is WeatherEvent.RefreshWeather -> refreshWeatherData()
            WeatherEvent.GetLatestWeather -> getLatestWeather()
        }
    }

    private fun refreshWeatherData() {
        refreshWeatherJob?.cancel()
        refreshWeatherJob = viewModelScope.launch {
            uiState = uiState.copy(
                isLoading = true
            )
            try {
                weatherUseCases.refreshWeather()
                val weather = weatherUseCases.getWeather()
                uiState = uiState.copy(
                    error = null,
                    weather = weather,
                    cityName = getCityName()
                )
            } catch (ioException: IOException) {
                uiState = uiState.copy(
                    error = "Could not refresh weather data. check your internet connection and try again.",
                )
            } catch (httpException: HttpException) {
                uiState = uiState.copy(
                    error = "Unexpected error occurred. Please try again."
                )
            } finally {
                uiState = uiState.copy(
                    isLoading = false
                )
            }
        }
    }

    private fun getLatestWeather(){
        viewModelScope.launch {
            val weather = weatherUseCases.getWeather()
            uiState = uiState.copy(
                    error = null,
                    weather = weather,
                    isLoading = false,
                    cityName = getCityName()
                )
        }
    }

    data class UiState(
        val isLoading: Boolean = true,
        val weather: Weather = Weather.empty(),
        val cityName: String = "",
        val error: String? = null,
    )
}
