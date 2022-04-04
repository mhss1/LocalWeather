package com.mhss.app.localweather.domain.use_case

import com.mhss.app.localweather.domain.repository.LocationRepository
import javax.inject.Inject

class GetCityName @Inject constructor(
    private val repository: LocationRepository
) {

    suspend operator fun invoke(): String {
        return repository.getCityName()
    }
}