package com.mhss.app.localweather.presentation.weather.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mhss.app.localweather.domain.model.MoonPhase
import com.mhss.app.localweather.R
import com.mhss.app.localweather.util.getFormattedTimeWithMinutes

@Composable
fun MoonSection(
    moonPhase: MoonPhase,
    moonRise: Int,
    moonSet: Int
) {
    WeatherItemCard {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Moon", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.moonrise),
                        contentDescription = "moonrise",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(text = moonRise.getFormattedTimeWithMinutes(), style = MaterialTheme.typography.body2)
                }
                Image(
                    painter = painterResource(id = moonPhase.icon),
                    contentDescription = "moon phase",
                    modifier = Modifier.size(85.dp)
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.moonset),
                        contentDescription = "moonrise",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(text = moonSet.getFormattedTimeWithMinutes(), style = MaterialTheme.typography.body2)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = moonPhase.phase, style = MaterialTheme.typography.body1, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}