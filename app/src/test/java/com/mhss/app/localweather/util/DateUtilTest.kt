package com.mhss.app.localweather.util

import com.google.common.truth.Truth.assertThat
import com.mhss.app.localweather.domain.model.Alert
import org.junit.Test

class DateUtilTest {

    @Test
    fun `getFormatted Date returns full date format`() {
        val date = 1649425095.getFormattedDate()
        assertThat(date).isEqualTo("Apr 08,2022")
    }

    @Test
    fun `getFormattedDateWithTime returns full date format with time`() {
        val date = 1649425095.getFormattedDateWithTime()
        // this expected time is in my local timezone and it might change in other timezones
        assertThat(date).isEqualTo("Apr 08,2022 3:38 PM")
    }

    @Test
    fun `getFormattedTime returns time format with only hours`() {
        val date = 1649425095.getFormattedTime()
        assertThat(date).isEqualTo("3 PM")
    }

    @Test
    fun `getFormattedTimeWithMinutes returns time format with hours and minutes`() {
        val date = 1649425095.getFormattedTimeWithMinutes()
        assertThat(date).isEqualTo("3:38 PM")
    }

    @Test
    fun `getFormattedDay returns day format`() {
        val date = 1649425095.getFormattedDay()
        assertThat(date).isEqualTo("Friday")
    }

    @Test
    fun `didNotEnd returns true if alert ends in future`() {
        val end = (System.currentTimeMillis() / 1000).toInt() + 3600
        val alert = Alert("", end = end, "", "",0)
        assertThat(alert.didNotEnd()).isTrue()
    }

    @Test
    fun `didNotEnd returns false if alert ends in past`() {
        val end = (System.currentTimeMillis() / 1000).toInt() - 3600
        val alert = Alert("", end = end, "", "",0)
        assertThat(alert.didNotEnd()).isFalse()
    }

}