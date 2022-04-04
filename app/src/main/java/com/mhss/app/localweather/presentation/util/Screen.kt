package com.mhss.app.localweather.presentation.util

sealed class Screen(val route: String) {
    object WeatherScreen : Screen("weather_screen")
    object MapScreen : Screen("map_screen")
}