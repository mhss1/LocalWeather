package com.mhss.app.localweather.presentation.weather.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mhss.app.localweather.domain.model.Daily

@Composable
fun DailyWeatherSection(
    items: List<Daily>
) {
    WeatherItemCard {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items.forEach {
                DailyWeatherItem(it)
            }
        }
    }
}