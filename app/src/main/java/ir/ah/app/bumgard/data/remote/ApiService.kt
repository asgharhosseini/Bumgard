package ir.ah.app.bumgard.data.remote

import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.di.*
import retrofit2.*
import retrofit2.http.*

interface ApiService {
    @POST(EndPoints.getTopCityRequest)
    @FormUrlEncoded
    suspend fun getTopCity(
        @Field("page")
        page: Int=1,
        @Field("apiKey")
        apiKey: String="",
        @Field("itemsCountPerPage")
        pageSize: Int = EndPoints.itemsCountPerPage
    ): Response<CityResponse>
    @POST(EndPoints.getPopularCityRequest)
    @FormUrlEncoded
    suspend fun getPopularCity(
        @Field("page")
        page: Int=1,
        @Field("apiKey")
        apiKey: String="",
        @Field("itemsCountPerPage")
        pageSize: Int = EndPoints.itemsCountPerPage
    ): Response<CityResponse>
    @POST(EndPoints.getSearchRequest)
    @FormUrlEncoded
    suspend fun getSearch(
        @Field("cityName")
        cityName: String,
        @Field("page")
        page: Int=1,
        @Field("apiKey")
        apiKey: String="",
        @Field("itemsCountPerPage")
        pageSize: Int = EndPoints.itemsCountPerPage
    ): Response<HotelResponse>
}