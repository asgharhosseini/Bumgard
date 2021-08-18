package ir.ah.app.bumgard.data.model

import com.squareup.moshi.*

@JsonClass(generateAdapter = true)
data class CityResponse(
    @Json(name = "issue")
    val cities: List<City>,
    @Json(name = "totalPages")
    val totalPages: Int,
    @Json(name = "pageSize")
    val pageSize: Int,
    @Json(name = "currentPage")
    val currentPage: Int
)
