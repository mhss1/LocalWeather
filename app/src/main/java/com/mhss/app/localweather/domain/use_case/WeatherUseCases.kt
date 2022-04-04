package com.mhss.app.localweather.domain.use_case

import javax.inject.Inject

class WeatherUseCases @Inject constructor(
    val getWeather: GetWeather,
    val refreshWeather: RefreshWeather
)