package com.mhss.app.localweather.domain.use_case

import com.mhss.app.localweather.domain.repository.LocationRepository
import javax.inject.Inject

class SaveCityName @Inject constructor(
    private val repository: LocationRepository
) {
    suspend operator fun invoke(cityName: String) {
        repository.saveCityName(cityName)
    }
}