package ir.ah.app.bumgard.data.model

import com.squareup.moshi.*

@JsonClass(generateAdapter = true)
data class Ratings(
    @Json(name = "Location")
    val Location:Float,
    @Json(name = "Cleaning")
    val Cleaning:Float,
    @Json(name = "Service")
    val Service:Float,
    @Json(name = "Price")
    val Price:Float,
)
