package ir.ah.app.bumgard.data.model

import com.squareup.moshi.*
@JsonClass(generateAdapter = true)
data class Comment(
    @Json(name = "id")
    val id:Int,
    @Json(name = "username")
    val username:String,
    @Json(name = "userProfile")
    val userProfile:String,
    @Json(name = "comment")
    val comment:String,
)
