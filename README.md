# Local Weather
Beautiful & Simple weather app that provides Information about the current weather, national weather alerts, moon information and more.

- 100% Kotlin-only.
- Following Clean Architecture approach.
- Following MVVM Architectural Design Pattern.
- Made Using Jetpack Compose.

## Features 🕹
- Current Weather
- National weather alerts
- Hourly forecast for 48 hours
- Daily forecast for 7 days
- Sunset and Sunrise
- Moon Information
- Auto weather data sync

Screenshot             |  Long screenshot with all items and ongoing alert
:-------------------------:|:-------------------------:
<img src="https://user-images.githubusercontent.com/58703865/161605345-a4c2be01-3ad0-4915-8bb3-38deee539d22.jpg" width="200">  |  <img src="https://user-images.githubusercontent.com/58703865/161607328-3b3665e3-3b91-4179-a391-2fc08157c2a3.jpg" width="200">

## Used in the app:
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Retrofit](https://square.github.io/retrofit)
- [WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Kotlin coroutines](https://developer.android.com/kotlin/coroutines)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Google Maps](https://developers.google.com/maps/documentation/android-sdk/maps-compose)

To run it, you'll have to:
1. Get a [Google Maps API key][map-api-key]
2. Get a [OpenWeather API key][weather-api-key]
3. Add an entry in `local.properties` that looks like `MAPS_API_KEY=YOUR_KEY`
4. Add an entry in `local.properties` that looks like `OPEN_WEATHER_API_KEY=YOUR_KEY `
7. Build and run

[map-api-key]: https://developers.google.com/maps/documentation/android-sdk/get-api-key
[weather-api-key]: https://home.openweathermap.org/api_keys


