package ir.ah.app.bumgard.data.repository.city.dummy

import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.data.repository.city.*
import ir.ah.app.bumgard.data.repository.search.*
import ir.ah.app.bumgard.data.repository.factory.DummyFactory.DummyCityResponse
import ir.ah.app.bumgard.data.repository.factory.DummyFactory.DummyFacilitiesResponse
import ir.ah.app.bumgard.data.repository.factory.DummyFactory.DummyHotelResponse
import ir.ah.app.bumgard.other.wrapper.*

class DummyCityRepository :CityRepository {
    override suspend fun getHotelInCity(cityName: String): Resource<HotelResponse> =
        Resource.Success(DummyHotelResponse)


}