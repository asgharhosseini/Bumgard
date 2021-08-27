package ir.ah.app.bumgard.data.repository.hotel

import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.data.remote.*
import ir.ah.app.bumgard.other.util.*
import ir.ah.app.bumgard.other.wrapper.*
import javax.inject.*

class HotelRepositoryImpl @Inject constructor(private val apiService: ApiService)  :HotelRepository {
    override suspend fun getHotelDetail(hotelId: Int): Resource<HotelDetailResponse> =
        safeApiCall { apiService.getHotelDetail(hotelId) }



}