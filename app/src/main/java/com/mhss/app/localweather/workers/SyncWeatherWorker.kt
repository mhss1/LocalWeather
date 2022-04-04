package com.mhss.app.localweather.workers

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.mhss.app.localweather.domain.use_case.RefreshWeather
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class SyncWeatherWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val refreshWeather: RefreshWeather
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        try {
            refreshWeather()
        }catch (e: Exception) {
            return Result.failure()
        }
        return Result.success()
    }
}
