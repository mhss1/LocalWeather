package com.mhss.app.localweather.presentation.map

import com.google.android.gms.maps.model.LatLng

sealed class MapEvent {
    object UpdateLatLng : MapEvent()
    data class UpdateCurrentLatLng(val latLng: LatLng) : MapEvent()
}
