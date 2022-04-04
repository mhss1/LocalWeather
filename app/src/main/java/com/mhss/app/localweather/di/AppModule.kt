package com.mhss.app.localweather.di

import android.content.Context
import android.location.Geocoder
import com.google.gson.Gson
import com.mhss.app.localweather.data.local.InternalStorageManager
import com.mhss.app.localweather.data.local.PreferenceManager
import com.mhss.app.localweather.data.remote.WeatherApi
import com.mhss.app.localweather.data.repository.LocationRepositoryImpl
import com.mhss.app.localweather.data.repository.WeatherRepositoryImpl
import com.mhss.app.localweather.domain.repository.LocationRepository
import com.mhss.app.localweather.domain.repository.WeatherRepository
import com.mhss.app.localweather.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(
        weatherApi: WeatherApi,
        dataStoreManager: InternalStorageManager,
        ioDispatcher: CoroutineDispatcher
    ): WeatherRepository {
        return WeatherRepositoryImpl(weatherApi, dataStoreManager, ioDispatcher)
    }

    @Provides
    @Singleton
    fun provideLocationRepository(
        preferenceManager: PreferenceManager,
        ioDispatcher: CoroutineDispatcher
    ): LocationRepository {
        return LocationRepositoryImpl(preferenceManager, ioDispatcher)
    }

    @Provides
    @Singleton
    fun provideInternalStorageManager(@ApplicationContext context: Context): InternalStorageManager {
        return InternalStorageManager(context)
    }

    @Provides
    @Singleton
    fun providePreferenceManager(@ApplicationContext context: Context): PreferenceManager {
        return PreferenceManager(context)
    }

    @Provides
    @Singleton
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideGeocoder(@ApplicationContext context: Context): Geocoder {
        return Geocoder(context)
    }
}