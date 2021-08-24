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
        @Field("checkInDate")
        checkInDate: String="",
        @Field("checkOutDate")
        checkOutDate: String="",
        @Field("guest")
        guest: Int=1,
        @Field("page")
        page: Int=1,
        @Field("apiKey")
        apiKey: String="",
        @Field("itemsCountPerPage")
        pageSize: Int = EndPoints.itemsCountPerPage
    ): Response<HotelResponse>

    @POST(EndPoints.getPopularCityRequest)
    @FormUrlEncoded
    suspend fun getFacilities(
        @Field("page")
        page: Int=1,
        @Field("apiKey")
        apiKey: String="",
        @Field("itemsCountPerPage")
        pageSize: Int = EndPoints.itemsCountPerPage
    ): Response<FacilitiesResponse>


    @POST(EndPoints.getSearchRequest)
    @FormUrlEncoded
    suspend fun getHotelInCity(
        @Field("cityName")
        cityName: String,
        @Field("page")
        page: Int=1,
        @Field("apiKey")
        apiKey: String="",
        @Field("itemsCountPerPage")
        pageSize: Int = EndPoints.itemsCountPerPage
    ): Response<HotelResponse>
    @POST(EndPoints.getSearchRequest)
    @FormUrlEncoded
    suspend fun getHotelDetail(
        @Field("hotelId")
        hotelId: Int,
        @Field("page")
        page: Int=1,
        @Field("apiKey")
        apiKey: String="",
        @Field("itemsCountPerPage")
        pageSize: Int = EndPoints.itemsCountPerPage
    ): Response<HotelResponse>




}