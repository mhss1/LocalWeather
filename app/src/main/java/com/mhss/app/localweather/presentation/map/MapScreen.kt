package com.mhss.app.localweather.presentation.map

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.mhss.app.localweather.presentation.map.components.FloatingConfirmationCard

@Composable
fun MapScreen(
    navController: NavController,
    viewModel: MapScreenViewModel = hiltViewModel()
) {
    val currentPosition = viewModel.uiState.latLng
    val scaffoldState = rememberScaffoldState()
    val cameraPositionState = rememberCameraPositionState()

    LaunchedEffect(key1 = viewModel.uiState){
        if (viewModel.uiState.refreshed)
            navController.navigateUp()
        if (viewModel.uiState.error != null)
            scaffoldState.snackbarHostState.showSnackbar(viewModel.uiState.error!!)
//        cameraPositionState.position = CameraPosition
//            .fromLatLngZoom(
//                currentPosition,
//                if (currentPosition.latitude != 0.0 || currentPosition.longitude != 0.0)
//                    10f
//                else
//                    1f
//            )
        cameraPositionState.animate(
            CameraUpdateFactory.newCameraPosition(
                CameraPosition
                    .fromLatLngZoom(
                        currentPosition,
                        if (currentPosition.latitude != 0.0 || currentPosition.longitude != 0.0)
                            10f
                        else
                            1f
                    )
            )
        )
    }
    Scaffold(Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
        Box(Modifier.fillMaxSize()) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                onMapClick = {
                    viewModel.onEvent(MapEvent.UpdateCurrentLatLng(it))
                },
            ){
                Marker(position = currentPosition)
            }
            FloatingConfirmationCard(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 16.dp),
                title = "Click on map to choose your location",
                subtitle = "Latitude: ${currentPosition.latitude}\nLongitude: ${currentPosition.longitude}") {
                viewModel.onEvent(MapEvent.UpdateLatLng)
            }
            if (viewModel.uiState.isLoading)
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
        }
    }
}