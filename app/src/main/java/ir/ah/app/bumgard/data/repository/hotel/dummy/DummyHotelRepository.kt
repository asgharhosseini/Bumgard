package ir.ah.app.bumgard.data.repository.hotel.dummy

import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.data.repository.city.*
import ir.ah.app.bumgard.data.repository.search.*
import ir.ah.app.bumgard.data.repository.factory.DummyFactory.DummyCityResponse
import ir.ah.app.bumgard.data.repository.factory.DummyFactory.DummyFacilitiesResponse
import ir.ah.app.bumgard.data.repository.factory.DummyFactory.DummyHotelDetailResponse
import ir.ah.app.bumgard.data.repository.factory.DummyFactory.DummyHotelResponse
import ir.ah.app.bumgard.data.repository.hotel.*
import ir.ah.app.bumgard.other.wrapper.*
import retrofit2.*

class DummyHotelRepository :HotelRepository {
    override suspend fun getHotelDetail(hotelId: Int): Resource<HotelDetailResponse> =
     Resource.Success(DummyHotelDetailResponse)


}