package ir.ah.app.bumgard.data.repository.search.dummy

import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.data.repository.search.*
import ir.ah.app.bumgard.data.repository.factory.DummyFactory.DummyCityResponse
import ir.ah.app.bumgard.data.repository.factory.DummyFactory.DummyFacilitiesResponse
import ir.ah.app.bumgard.data.repository.factory.DummyFactory.DummyHotelResponse
import ir.ah.app.bumgard.other.wrapper.*

class DummySearchRepository :SearchRepository {
    override suspend fun getTopCity(): Resource<CityResponse> =
        Resource.Success(DummyCityResponse)

    override suspend fun getPopularCity(): Resource<CityResponse> =
        Resource.Success(DummyCityResponse)


    override suspend fun getSearch(
        cityName: String,
        checkInDate: String,
        checkOutDate: String,
        guest: Int
    ): Resource<HotelResponse> =
        Resource.Success(DummyHotelResponse)

    override suspend fun getFacilities(): Resource<FacilitiesResponse> =
        Resource.Success(DummyFacilitiesResponse)
}