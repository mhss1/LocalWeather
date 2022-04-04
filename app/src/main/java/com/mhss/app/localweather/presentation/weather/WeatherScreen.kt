package com.mhss.app.localweather.presentation.weather

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.mhss.app.localweather.R
import com.mhss.app.localweather.presentation.util.Screen
import com.mhss.app.localweather.presentation.weather.components.*
import com.mhss.app.localweather.util.getUviString
import com.mhss.app.localweather.util.didNotEnd
import kotlin.math.roundToInt

@Composable
fun WeatherScreen(
    navController: NavController,
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val weather = viewModel.uiState.weather

    LaunchedEffect(key1 = viewModel.uiState){
        viewModel.uiState.error?.let {
            scaffoldState.snackbarHostState.showSnackbar(
                message = it,
            )
        }
    }
    LaunchedEffect(true){viewModel.onEvent(WeatherEvent.GetLatestWeather)}
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            if (weather.current != null)
            Row(Modifier.fillMaxWidth().wrapContentHeight(), horizontalArrangement = Arrangement.End){
                IconButton(
                    onClick = { navController.navigate(Screen.MapScreen.route)},
                ) {
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Location")
                }
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        SwipeRefresh(
            state = rememberSwipeRefreshState(viewModel.uiState.isLoading),
            onRefresh = { viewModel.onEvent(WeatherEvent.RefreshWeather) },
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // if weather.current is null, it means that there is not weather data cached yet
                if (weather.current != null) {
                    item {
                        CurrentWeatherSection(
                            temp = weather.current.temp,
                            feelsLike = weather.current.feelsLike,
                            time = weather.current.time,
                            weather.current.weather[0].description,
                            icon = weather.current.weather[0].icon,
                            cityName = viewModel.uiState.cityName
                        )
                    }
                    // Alerts section is only shown if there are ongoing alerts
                    if (weather.alerts.isNotEmpty() && weather.alerts.any {it.didNotEnd()}) item {
                        AlertsSection(alerts = weather.alerts)
                    }
                    if (weather.hourly.isNotEmpty()) item {
                        HourlyWeatherSection(items = weather.hourly)
                    }
                    if (weather.daily.isNotEmpty()) item {
                        DailyWeatherSection(items = weather.daily)
                    }
                    item {
                        MoreWeatherInfoSection(
                            weatherInfos = listOf(
                                WeatherInfo(
                                    title = "Humidity",
                                    value = "${weather.current.humidity}%",
                                    icon = R.drawable.humidity
                                ),
                                WeatherInfo(
                                    title = "UV Index",
                                    value = weather.current.uvi.getUviString(),
                                    icon = R.drawable.clear
                                ),
                                WeatherInfo(
                                    title = "Wind speed",
                                    value = "${weather.current.windSpeed.roundToInt()} km/h",
                                    icon = R.drawable.wind
                                )
                            )
                        )
                    }
                    item {
                        SunSection(
                            sunrise = weather.current.sunrise,
                            sunset = weather.current.sunset
                        )
                    }
                    if(weather.daily.isNotEmpty()) item {
                        MoonSection(
                            moonPhase = weather.daily[0].moonPhase,
                            moonRise = weather.daily[0].sunrise,
                            moonSet = weather.daily[0].sunset
                        )
                    }
                    item { Spacer(modifier = Modifier.height(8.dp))}
                } else item {
                        if (!viewModel.uiState.isLoading)
                            NoWeatherDataSection { navController.navigate(Screen.MapScreen.route) }
                    }
            }
        }
    }

}