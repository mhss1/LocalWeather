package com.mhss.app.localweather.presentation.map

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mhss.app.localweather.domain.use_case.LocationUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.mhss.app.localweather.domain.use_case.RefreshWeather
import kotlinx.coroutines.launch
import java.io.IOException

@HiltViewModel
class MapScreenViewModel @Inject constructor(
    private val locationUseCases: LocationUseCases,
    private val refreshWeather: RefreshWeather
) : ViewModel() {

    var uiState by mutableStateOf(UiState())
    private set

    init {
        viewModelScope.launch {
            uiState = UiState(
                latLng = locationUseCases.getLatLng(),
            )
        }
    }

    fun onEvent(event: MapEvent) {
        when (event) {
            is MapEvent.UpdateLatLng -> {
                viewModelScope.launch {
                    try {
                        uiState = uiState.copy(isLoading = true, error = null)
                        locationUseCases.setLatLng(uiState.latLng)
                        refreshWeather()
                        uiState = uiState.copy(isLoading = false, refreshed = true)
                    }catch (e: IOException){
                        uiState = uiState.copy(
                            isLoading = false,
                            refreshed = false,
                            error = "Location Update Failed. Check your internet connection and try again."
                        )
                    }
                }
            }
            is MapEvent.UpdateCurrentLatLng -> {
                uiState = uiState.copy(
                    latLng = event.latLng
                )
            }
        }
    }

    data class UiState(
        val latLng : LatLng = LatLng(0.0, 0.0),
        val isLoading: Boolean = false,
        val refreshed: Boolean = false,
        val error: String? = null,
    )
}