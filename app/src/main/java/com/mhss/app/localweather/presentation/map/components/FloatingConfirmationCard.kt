package com.mhss.app.localweather.presentation.map.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mhss.app.localweather.presentation.weather.components.WeatherItemCard

@Composable
fun FloatingConfirmationCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    onConfirm: () -> Unit
) {
    WeatherItemCard(modifier, elevation = 12.dp) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.body1, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Text(subtitle, style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = onConfirm, modifier = Modifier.align(Alignment.End), shape = RoundedCornerShape(12.dp)) {
                Text("Save")
            }

        }
    }
}
