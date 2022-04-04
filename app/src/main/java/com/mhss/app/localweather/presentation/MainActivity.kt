package com.mhss.app.localweather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mhss.app.localweather.presentation.map.MapScreen
import com.mhss.app.localweather.presentation.util.Screen
import com.mhss.app.localweather.presentation.weather.WeatherScreen
import com.mhss.app.localweather.ui.theme.LocalWeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocalWeatherTheme {
                this.window.statusBarColor = MaterialTheme.colors.background.toArgb()
                this.window.navigationBarColor = MaterialTheme.colors.background.toArgb()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.WeatherScreen.route){
                        composable(route = Screen.WeatherScreen.route) {
                            WeatherScreen(navController)
                        }
                        composable(route = Screen.MapScreen.route) {
                            MapScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}