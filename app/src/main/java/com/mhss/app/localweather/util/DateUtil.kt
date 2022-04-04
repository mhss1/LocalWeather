package com.mhss.app.localweather.util

import android.text.format.DateUtils
import com.mhss.app.localweather.domain.model.Alert
import java.text.SimpleDateFormat
import java.util.*

fun Int.getFormattedDate(): String {
    val sdf = SimpleDateFormat("MMM dd,yyyy", Locale.getDefault())

    val calender = Calendar.getInstance()
    calender.timeInMillis = this.toLong() * 1000
    return sdf.format(calender.time)
}
fun Int.getFormattedDateWithTime(): String {
    val sdf = SimpleDateFormat("MMM dd,yyyy h:mm a", Locale.getDefault())

    val calender = Calendar.getInstance()
    calender.timeInMillis = this.toLong() * 1000
    return sdf.format(calender.time)
}

fun Int.getFormattedTime(): String {
    val sdf = SimpleDateFormat("h a", Locale.getDefault())

    val calender = Calendar.getInstance()
    calender.timeInMillis = this.toLong() * 1000
    return sdf.format(calender.time)
}
fun Int.getFormattedTimeWithMinutes(): String {
    val sdf = SimpleDateFormat("h:mm a", Locale.getDefault())

    val calender = Calendar.getInstance()
    calender.timeInMillis = this.toLong() * 1000
    return sdf.format(calender.time)
}
fun Int.getFormattedDay(): String {
    val sdf = SimpleDateFormat("EEEE", Locale.getDefault())

    val calender = Calendar.getInstance()
    calender.timeInMillis = this.toLong() * 1000
    return sdf.format(calender.time)
}

fun Int.isToday(): Boolean {
    return DateUtils.isToday(this.toLong() * 1000)
}

fun Alert.didNotEnd() : Boolean {
    return this.end > System.currentTimeMillis() / 1000
}