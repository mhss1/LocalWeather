@file:Suppress("BlockingMethodInNonBlockingContext", "RedundantSuspendModifier")

package com.mhss.app.localweather.data.local

import android.content.Context
import com.mhss.app.localweather.util.Constants
import java.io.FileNotFoundException
class InternalStorageManager(private val context: Context) {

    suspend fun writeToInternalStorage(data: String) {
        context.openFileOutput(Constants.WEATHER_DATA_FILE_NAME, Context.MODE_PRIVATE).use {
            it.write(data.toByteArray())
        }
    }

    suspend fun readFromInternalStorage(): String {
        return try {
            context.openFileInput(Constants.WEATHER_DATA_FILE_NAME).bufferedReader().useLines { lines ->
                lines.fold("") { r, t ->
                    "$r$t"
                }
            }
        }catch (e: FileNotFoundException) {
            ""
        }
    }
}