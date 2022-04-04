package com.mhss.app.localweather.domain.use_case

import javax.inject.Inject

class LocationUseCases @Inject constructor(
    val getLatLng: GetLatLng,
    val setLatLng: SetLatLng,
    val getCityName: GetCityName,
)