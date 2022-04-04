package com.mhss.app.localweather.data.repository

import com.google.android.gms.maps.model.LatLng
import com.mhss.app.localweather.data.local.PreferenceManager
import com.mhss.app.localweather.domain.repository.LocationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor (
    private val preferenceManager: PreferenceManager,
    private val ioDispatcher: CoroutineDispatcher
): LocationRepository {

    override suspend fun getLatLng(): LatLng {
        return withContext(ioDispatcher){
            preferenceManager.getLatLng()
        }
    }

    override suspend fun saveLatLng(latLng: LatLng) {
        withContext(ioDispatcher){
            preferenceManager.saveLatLng(latLng)
        }
    }

    override suspend fun getCityName(): String {
        return withContext(ioDispatcher){
            preferenceManager.getCityName()
        }
    }

    override suspend fun saveCityName(cityName: String) {
        withContext(ioDispatcher){
            preferenceManager.saveCityName(cityName)
        }
    }
}