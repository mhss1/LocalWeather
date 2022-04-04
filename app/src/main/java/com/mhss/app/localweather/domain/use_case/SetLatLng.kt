package com.mhss.app.localweather.domain.use_case

import com.google.android.gms.maps.model.LatLng
import com.mhss.app.localweather.domain.repository.LocationRepository
import javax.inject.Inject

class SetLatLng @Inject constructor(
    private val repository: LocationRepository
) {

    suspend operator fun invoke(latLng: LatLng) {
        repository.saveLatLng(latLng)
    }
}