package com.mhss.app.localweather.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UtilTest {

    @Test
    fun `getUviString returns correct string for all uvi levels`() {
        assertThat(0.5.getUviString()).isEqualTo("Low")
        assertThat(3.5.getUviString()).isEqualTo("Moderate")
        assertThat(7.0.getUviString()).isEqualTo("High")
        assertThat(8.5.getUviString()).isEqualTo("Very High")
        assertThat(12.0.getUviString()).isEqualTo("Extreme")
    }

    @Test
    fun `getMoonPhase returns correct moon phase for all phases`() {
        assertThat(0.0.getMoonPhase()).isEqualTo("New Moon")
        assertThat(0.2.getMoonPhase()).isEqualTo("Waxing Crescent")
        assertThat(0.3.getMoonPhase()).isEqualTo("First Quarter")
        assertThat(0.6.getMoonPhase()).isEqualTo("Waxing Gibbous")
        assertThat(0.9.getMoonPhase()).isEqualTo("Full Moon")
    }

}