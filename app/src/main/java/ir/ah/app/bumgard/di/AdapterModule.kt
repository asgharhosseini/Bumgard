package ir.ah.app.bumgard.di

import com.bumptech.glide.*
import dagger.*
import dagger.hilt.*
import dagger.hilt.android.components.*
import ir.ah.app.bumgard.ui.city.adapter.*
import ir.ah.app.bumgard.ui.hotel.adapter.*
import ir.ah.app.bumgard.ui.search.adapter.*
import ir.ah.app.bumgard.ui.search.filter.adapter.*

@Module
@InstallIn(FragmentComponent::class)
object AdapterModule {


    @Provides
    fun provideTopCityAdapter(glide: RequestManager) = TopCityAdapter(glide)
    @Provides
    fun providePopularCityAdapter(glide: RequestManager) = PopularCityAdapter(glide)
    @Provides
    fun provideSearchAdapter(glide: RequestManager) = SearchAdapter(glide)
    @Provides
    fun provideHotelInCityAdapter(glide: RequestManager) = HotelInCityAdapter(glide)
    @Provides
    fun provideFacilitiesAdapter() = FacilitiesAdapter()
    @Provides
    fun provideHotelFacilitiesAdapter() = HotelFacilitiesAdapter()
}