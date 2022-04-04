package com.mhss.app.localweather.presentation.weather.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mhss.app.localweather.domain.model.Hourly

@Composable
fun HourlyWeatherSection(
    items: List<Hourly>
) {
    WeatherItemCard {
        LazyRow(modifier = Modifier.padding(16.dp), horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            items(items) {
                HourlyWeatherItem(it)
            }
        }
    }
}