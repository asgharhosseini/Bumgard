package ir.ah.app.bumgard.data.repository.search.dummy

import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.data.repository.search.*
import ir.ah.app.bumgard.data.repository.search.factory.DummyFactory.DummyCityResponse
import ir.ah.app.bumgard.data.repository.search.factory.DummyFactory.DummyHotelResponse
import ir.ah.app.bumgard.other.wrapper.*

class DummySearchRepository :SearchRepository {
    override suspend fun getTopCity(): Resource<CityResponse> =
        Resource.Success(DummyCityResponse)

    override suspend fun getPopularCity(): Resource<CityResponse> =
        Resource.Success(DummyCityResponse)


    override suspend fun getSearch(cityName: String): Resource<HotelResponse> =
        Resource.Success(DummyHotelResponse)
}