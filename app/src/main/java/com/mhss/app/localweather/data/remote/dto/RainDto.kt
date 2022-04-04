package com.mhss.app.localweather.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RainDto(
    @SerializedName("1h")
    val oneHour: Double
)