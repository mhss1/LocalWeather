package com.mhss.app.localweather.presentation.weather.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mhss.app.localweather.domain.model.Alert
import com.mhss.app.localweather.ui.theme.AlertColor
import com.mhss.app.localweather.ui.theme.AlertColorLight
import com.mhss.app.localweather.util.getFormattedDateWithTime

@Composable
fun AlertsSection(
    alerts: List<Alert>
) {
    WeatherItemCard(backgroundColor = AlertColor) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Alerts",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            alerts.forEach { alert ->
                AlertCard(alert)
            }
        }
    }
}

@Composable
fun AlertCard(
    alert: Alert
) {
    var expanded by remember { mutableStateOf(false) }
    WeatherItemCard(
        elevation = 2.dp,
        backgroundColor = AlertColorLight
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded }
                .padding(12.dp)
        ) {
            Text(text = alert.title, style = MaterialTheme.typography.h6, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = alert.description,
                style = MaterialTheme.typography.body2,
                maxLines = if (expanded) Int.MAX_VALUE else 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Starts: ${alert.start.getFormattedDateWithTime()}",
                style = MaterialTheme.typography.caption
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Ends: ${alert.end.getFormattedDateWithTime()}",
                style = MaterialTheme.typography.caption
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Source: ${alert.source}",
                style = MaterialTheme.typography.caption,
                modifier = Modifier.align(Alignment.End)
            )
        }

    }
}