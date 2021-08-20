package ir.ah.app.bumgard.data.repository.search

import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.data.remote.*
import ir.ah.app.bumgard.other.util.*
import ir.ah.app.bumgard.other.wrapper.*
import javax.inject.*

class SearchRepositoryImpl @Inject constructor(private val apiService: ApiService)  :SearchRepository {
    override suspend fun getTopCity(): Resource<CityResponse> =
        safeApiCall { apiService.getTopCity() }


    override suspend fun getPopularCity(): Resource<CityResponse> =
        safeApiCall { apiService.getPopularCity() }

    override suspend fun getSearch(
        cityName: String,
        checkInDate: String,
        checkOutDate: String,
        guest: Int
    ): Resource<HotelResponse> =
        safeApiCall { apiService.getSearch(cityName,checkInDate,checkOutDate,guest) }
}