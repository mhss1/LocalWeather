package com.mhss.app.localweather.presentation.weather.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MoreWeatherInfoSection(
    weatherInfos: List<WeatherInfo>
) {
    WeatherItemCard {
        Row(modifier = Modifier.padding(vertical = 16.dp)) {
            weatherInfos.forEach {
                WeatherInfoItem(Modifier.weight(1f), weatherInfo = it)
            }
        }
    }
}