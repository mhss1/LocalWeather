package com.mhss.app.localweather.presentation.weather.components

import androidx.annotation.DrawableRes

data class WeatherInfo(
    @DrawableRes val icon: Int,
    val title: String,
    val value: String
)
