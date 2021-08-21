package ir.ah.app.bumgard.data.model

import com.squareup.moshi.*

data class Facilities (
    @Json(name="id")
    var id: Int,
    @Json(name="name")
    var name: String,
    @Json(name="image")
    var image: Int,
        )