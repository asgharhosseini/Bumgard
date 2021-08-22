package ir.ah.app.bumgard.data.repository.search

import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.other.wrapper.*

interface SearchRepository {
    suspend fun getTopCity(): Resource<CityResponse>
    suspend fun getPopularCity(): Resource<CityResponse>
    suspend fun getSearch(
        cityName: String,
        checkInDate: String="",
        checkOutDate: String="",
        guest: Int=1): Resource<HotelResponse>
    suspend fun getFacilities(): Resource<FacilitiesResponse>
}