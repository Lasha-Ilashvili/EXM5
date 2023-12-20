package com.example.exm5.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Course(
    val id: String? = null,
    @Json(name = "icon_type") val iconType: String? = null,
    val duration: String? = null,
    @Json(name = "booking_time") val bookingTime: String? = null,
    val progress: String? = null,
    val title: String? = null,
    val question: String? = null,
    @Json(name = "main_color") val mainColor: String? = null,
    @Json(name = "background_color_present") val backgroundColorPresent: String? = null,
    @Json(name = "play_button_color_present") val playButtonColorPresent: String? = null,
    val image: String? = null
)