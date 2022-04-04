package com.mhss.app.localweather.util

import android.text.format.DateUtils
import com.mhss.app.localweather.R
import java.text.SimpleDateFormat
import java.util.*

fun Double.getUviString(): String {
    return when (this) {
        in 0.0..2.9 -> "Low"
        in 3.0..5.9 -> "Moderate"
        in 6.0..7.9 -> "High"
        in 8.0..10.0 -> "Very High"
        else -> "Extreme"
    }
}

fun Int.getWeatherIcon(): Int {
    return when (this) {
        in 200..299 -> R.drawable.thunder
        in 300..399 -> R.drawable.drizzle
        in 500..599 -> R.drawable.rain
        in 600..699 -> R.drawable.snow
        in 700..799 -> R.drawable.fog
        in 801..804 -> R.drawable.clouds
        else -> R.drawable.clear
    }
}

fun Double.getMoonPhase(): String {
    return when (this) {
        in 0.0..0.1 -> "New Moon"
        in 0.1..0.25 -> "Waxing Crescent"
        in 0.25..0.5 -> "First Quarter"
        in 0.5..0.75 -> "Waxing Gibbous"
        in 0.75..1.0 -> "Full Moon"
        else -> "New Moon"
    }
}
fun Double.getMoonPhaseIcon() : Int {
    return when(this) {
        in 0.0..0.1 -> R.drawable.new_moon
        in 0.1..0.25 -> R.drawable.first_quarter_moon
        in 0.25..0.5 -> R.drawable.half_moon
        in 0.5..0.75 -> R.drawable.last_quarter_moon
        in 0.75..1.0 -> R.drawable.full_moon
        else -> R.drawable.full_moon
    }
}