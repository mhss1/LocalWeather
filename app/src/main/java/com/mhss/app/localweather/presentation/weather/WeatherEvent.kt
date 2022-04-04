package com.mhss.app.localweather.presentation.weather


sealed class WeatherEvent {
    object RefreshWeather : WeatherEvent()
    object GetLatestWeather: WeatherEvent()
}
