package ir.ah.app.bumgard.data.repository.city

import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.data.remote.*
import ir.ah.app.bumgard.other.util.*
import ir.ah.app.bumgard.other.wrapper.*
import javax.inject.*

class CityRepositoryImpl @Inject constructor(private val apiService: ApiService)  :CityRepository {
    override suspend fun getCity(cityName: String): Resource<HotelResponse> =
        safeApiCall { apiService.getSearch(cityName) }


}