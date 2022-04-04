package com.mhss.app.localweather.presentation.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun WeatherInfoItem(
    modifier: Modifier = Modifier,
    weatherInfo: WeatherInfo,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource(id = weatherInfo.icon),
            contentDescription = weatherInfo.title,
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .aspectRatio(1f, matchHeightConstraintsFirst = false)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(weatherInfo.title, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(weatherInfo.value)
    }
}
