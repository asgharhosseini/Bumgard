package ir.ah.app.bumgard.data.model

import android.annotation.*
import android.os.*
import com.squareup.moshi.*

@JsonClass(generateAdapter = true)
data class Hotel(
    @Json(name = "id")
    var id: Int,
    @Json(name = "state_id")
    var stateId: Int,
    @Json(name = "city_id")
    var cityId: Int,
    @Json(name = "name")
    var name: String,
    @Json(name = "image")
    var image: String,
    @Json(name = "latitude")
    var latitude: Double? = null,
    @Json(name = "longitude")
    var longitude: Double? = null,
)