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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mhss.app.localweather.R
import com.mhss.app.localweather.domain.model.Daily
import com.mhss.app.localweather.util.getFormattedDay
import com.mhss.app.localweather.util.isToday
import kotlin.math.roundToInt

@Composable
fun DailyWeatherItem(
    daily: Daily
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = if (daily.date.isToday()) "Today"
            else
                daily.date.getFormattedDay(),
            fontWeight = if (daily.date.isToday()) FontWeight.Bold
            else FontWeight.Normal,
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.drop),
                    contentDescription = "drop",
                    modifier = Modifier.size(10.dp).alpha(0.7f)
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(text = "${daily.rainProp}%", style = MaterialTheme.typography.body2)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = daily.weather[0].icon),
                contentDescription = "Weather icon",
                modifier = Modifier.size(26.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.defaultMinSize(minWidth = 50.dp)
            ) {
                Text(text = "${daily.temp.max.roundToInt()}°")
                Text(text = "${daily.temp.min.roundToInt()}°")
            }
        }
    }
}