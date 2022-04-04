package com.mhss.app.localweather.domain.repository

import com.google.android.gms.maps.model.LatLng

interface LocationRepository {

    suspend fun getLatLng(): LatLng

    suspend fun saveLatLng(latLng: LatLng)

    suspend fun getCityName(): String

    suspend fun saveCityName(cityName: String)
}