package com.mhss.app.localweather.presentation.weather.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mhss.app.localweather.R

@Composable
fun NoWeatherDataSection(
    onClick: () -> Unit
) {
    WeatherItemCard {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable { onClick() }
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            Text(
                text = "No weather data available yet.\nNavigate to map to choose your location",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_gps),
                    contentDescription = "map icon",
                    modifier = Modifier.size(26.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Navigate to map", style = MaterialTheme.typography.body1)
            }
        }
    }
}

@Preview
@Composable
fun NoWeatherDataSectionPreview() {
    NoWeatherDataSection {}
}