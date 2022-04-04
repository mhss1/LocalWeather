@file:Suppress("RedundantSuspendModifier")

package com.mhss.app.localweather.data.local

import android.content.Context
import com.google.android.gms.maps.model.LatLng
import com.mhss.app.localweather.util.Constants

class PreferenceManager(
    context: Context
) {
    private val preferences = context.getSharedPreferences(
        Constants.LAT_LNG_PREFERENCE,
        Context.MODE_PRIVATE
    )

    suspend fun getLatLng (): LatLng {
        val lat = Double.fromBits(preferences.getLong(Constants.LAT, 0))
        val lng = Double.fromBits(preferences.getLong(Constants.LNG, 0))
        return LatLng(lat, lng)
    }

    suspend fun saveLatLng (latLng: LatLng) {
        preferences.edit().apply {
            putLong(Constants.LAT, latLng.latitude.toBits())
            putLong(Constants.LNG, latLng.longitude.toBits())
            apply()
        }
    }

    suspend fun getCityName (): String {
        return preferences.getString(Constants.CITY_NAME, "") ?: ""
    }

    suspend fun saveCityName (cityName: String) {
        preferences.edit().apply {
            putString(Constants.CITY_NAME, cityName)
            apply()
        }
    }

}