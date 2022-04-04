package com.mhss.app.localweather

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.*
import com.mhss.app.localweather.workers.SyncWeatherWorker
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltAndroidApp
class LocalWeatherApp : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

    override fun onCreate() {
        super.onCreate()

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val request = PeriodicWorkRequestBuilder<SyncWeatherWorker>(
            4,
            TimeUnit.HOURS
        ).setConstraints(constraints)
            .build()

        WorkManager
            .getInstance(this)
            .enqueueUniquePeriodicWork(
                "SyncWeatherWorker",
                ExistingPeriodicWorkPolicy.KEEP,
                request
            )
    }
}
