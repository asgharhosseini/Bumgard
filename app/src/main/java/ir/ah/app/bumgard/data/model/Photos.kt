package ir.ah.app.bumgard.data.model

import com.squareup.moshi.*
@JsonClass(generateAdapter = true)
data class Photos(
    @Json(name = "id")
    val id:Int,
    @Json(name = "image")
    val image:String
)
