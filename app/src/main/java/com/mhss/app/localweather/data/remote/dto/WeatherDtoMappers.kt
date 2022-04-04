package com.mhss.app.localweather.data.remote.dto

import com.mhss.app.localweather.domain.model.*
import com.mhss.app.localweather.util.getMoonPhase
import com.mhss.app.localweather.util.getMoonPhaseIcon
import com.mhss.app.localweather.util.getWeatherIcon

fun WeatherResponseDto.toWeather(): Weather {
    return Weather(
        alerts = alerts?.map { it.toAlert() } ?: emptyList(),
        current = current?.toCurrent() ,
        daily = daily?.map { it.toDaily() } ?: emptyList(),
        hourly = hourly?.map { it.toHourly() } ?: emptyList(),
    )
}

fun WeatherDto.toWeatherData(): WeatherData {
    return WeatherData(
        description = description.replaceFirstChar { it.uppercaseChar() },
        icon = id.getWeatherIcon(),
    )
}

fun AlertDto.toAlert(): Alert {
    return Alert(
        end = end ?: 0,
        title = event ?: "",
        source = sender_name ?: "",
        start = start ?: 0,
        description = description ?: "",
    )
}

fun CurrentDto.toCurrent(): Current {
    return Current(
        time = dt ?: 0,
        feelsLike = feels_like ?: 0.0,
        humidity = humidity ?: 0,
        sunrise = sunrise ?: 0,
        sunset = sunset ?: 0,
        temp = temp ?: 0.0,
        uvi = uvi ?: 0.0,
        weather = weather?.map { it.toWeatherData() } ?: emptyList(),
        windSpeed = if (wind_speed != null) wind_speed * 3.6 else 0.0
    )
}

fun DailyDto.toDaily(): Daily {
    return Daily(
        feelsLike = feels_like?.toFeelsLike() ?: FeelsLike(0.0, 0.0, 0.0),
        humidity = humidity ?: 0,
        pressure = pressure ?: 0,
        sunrise = sunrise ?: 0,
        sunset = sunset ?: 0,
        temp = temp?.toTemp() ?: Temp(0.0, 0.0),
        uvi = uvi ?: 0.0,
        weather = weather?.map { it.toWeatherData() } ?: emptyList(),
        rainProp = if (pop != null) (pop * 100).toInt() else 0,
        windSpeed = if (wind_speed != null) wind_speed * 3.6 else 0.0,
        date = dt ?: 0,
        moonPhase = MoonPhase(moon_phase?.getMoonPhase() ?: "",moon_phase?.getMoonPhaseIcon() ?: 0),
        moonSet = moonset ?: 0,
        moonRise = moonrise ?: 0,
    )
}
fun HourlyDto.toHourly(): Hourly {
    return Hourly(
        weather = weather?.map { it.toWeatherData() } ?: emptyList(),
        temp = temp ?: 0.0,
        rainProp = if (pop != null) (pop * 100).toInt() else 0,
        time = dt ?: 0,
    )
}
fun TempDto.toTemp(): Temp {
    return Temp(
        max = max,
        min = min,
    )
}
fun FeelsLikeDto.toFeelsLike(): FeelsLike {
    return FeelsLike(
        day = day,
        morn = morn,
        night = night
    )
}
