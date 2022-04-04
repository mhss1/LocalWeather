package com.mhss.app.localweather.presentation.weather.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mhss.app.localweather.R
import com.mhss.app.localweather.util.getFormattedDate
import com.mhss.app.localweather.util.getFormattedTimeWithMinutes
import com.mhss.app.localweather.util.isToday
import kotlin.math.roundToInt

@Composable
fun CurrentWeatherSection(
    temp: Double,
    feelsLike: Double,
    time: Int,
    weatherDescription: String,
    cityName: String,
    @DrawableRes icon: Int,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Column(Modifier.weight(1f), horizontalAlignment = Alignment.Start) {
            Text(text = "${temp.roundToInt()}°", style = MaterialTheme.typography.h2)
            if (cityName.isNotBlank()){
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = cityName,
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = buildAnnotatedString {
                append("Feels like ")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("${feelsLike.roundToInt()}°")
                }
            }, style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = buildAnnotatedString {
                    append("Last updated:\n")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(if (time.isToday()) time.getFormattedTimeWithMinutes() else time.getFormattedDate())
                    }
                },
                style = MaterialTheme.typography.body2
            )

        }
        Column(
            Modifier
                .weight(1f)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Weather icon",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = weatherDescription,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun CurrentWeatherSectionPreview() {
    CurrentWeatherSection(20.0, 15.0, 1618317040, "Clear","Mansoura", R.drawable.clear)
}