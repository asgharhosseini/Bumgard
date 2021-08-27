package ir.ah.app.bumgard.data.model

import com.squareup.moshi.*

@JsonClass(generateAdapter = true)
data class Ratings(
    @Json(name = "Location")
    val location:Int,
    @Json(name = "Cleaning")
    val cleaning:Int,
    @Json(name = "Service")
    val service:Int,
    @Json(name = "Price")
    val price:Int,
)
