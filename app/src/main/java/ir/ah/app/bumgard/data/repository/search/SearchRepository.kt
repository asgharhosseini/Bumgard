package ir.ah.app.bumgard.data.repository.search

import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.other.wrapper.*

interface SearchRepository {
    suspend fun getTopCity(): Resource<CityResponse>
    suspend fun getPopularCity(): Resource<CityResponse>
    suspend fun getSearch(cityName:String): Resource<HotelResponse>
}