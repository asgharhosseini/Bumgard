package ir.ah.app.bumgard.data.repository.hotel

import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.di.*
import ir.ah.app.bumgard.other.wrapper.*
import retrofit2.*
import retrofit2.http.*

interface HotelRepository {
    suspend fun getHotelDetail(hotelId: Int): Resource<HotelDetailResponse>
}