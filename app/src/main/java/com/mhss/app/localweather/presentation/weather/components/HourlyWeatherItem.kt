package com.mhss.app.localweather.presentation.weather.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mhss.app.localweather.domain.model.Hourly
import com.mhss.app.localweather.util.getFormattedTime
import com.mhss.app.localweather.R
import kotlin.math.roundToInt

@Composable
fun HourlyWeatherItem(
    hourly: Hourly
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = hourly.time.getFormattedTime(), style = MaterialTheme.typography.body2)
        Spacer(modifier = Modifier.height(4.dp))
        Image(painter = painterResource(id = hourly.weather[0].icon),
            contentDescription = "Weather Icon",
        modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "${hourly.temp.roundToInt()}°")
        Spacer(modifier = Modifier.height(12.dp))
        Row (verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.drop),
                contentDescription = "drop",
                modifier = Modifier.size(10.dp).alpha(0.7f))
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = "${hourly.rainProp}%", modifier = Modifier, style = MaterialTheme.typography.body2)
        }
    }
}