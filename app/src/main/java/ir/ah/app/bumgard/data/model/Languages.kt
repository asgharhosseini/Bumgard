package ir.ah.app.bumgard.data.model

import com.squareup.moshi.*
@JsonClass(generateAdapter = true)
data class Languages(
    @Json(name = "id")
    val id:Int,
    @Json(name = "name")
    val name:String,
    @Json(name = "image")
    val image:String
)
