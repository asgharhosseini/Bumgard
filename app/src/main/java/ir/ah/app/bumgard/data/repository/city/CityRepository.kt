package ir.ah.app.bumgard.data.repository.city

import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.other.wrapper.*

interface CityRepository {

    suspend fun getCity(cityName: String): Resource<HotelResponse>

}