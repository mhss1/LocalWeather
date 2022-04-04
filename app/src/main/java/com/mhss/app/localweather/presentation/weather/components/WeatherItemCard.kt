package com.mhss.app.localweather.presentation.weather.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun WeatherItemCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(24.dp),
    elevation: Dp = 4.dp,
    backgroundColor: Color = MaterialTheme.colors.surface,
    content: @Composable () -> Unit
) {
    Card(
        modifier =
        modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        elevation = elevation,
        shape = shape,
        backgroundColor = backgroundColor
    ) {
        content()
    }
}

@Preview
@Composable
fun WeatherItemCardPreview() {
    WeatherItemCard(
        content = { })
}