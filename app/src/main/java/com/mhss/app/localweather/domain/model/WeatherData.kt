package com.mhss.app.localweather.domain.model

import androidx.annotation.DrawableRes


data class WeatherData(
    val description: String,
    @DrawableRes val icon: Int
)
