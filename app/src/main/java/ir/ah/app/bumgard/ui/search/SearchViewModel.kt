package ir.ah.app.bumgard.ui.search

import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.data.repository.search.*
import ir.ah.app.bumgard.other.wrapper.*

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
class SearchViewModel @Inject constructor(
    val mainCoroutineDispatcher: CoroutineDispatcher,
    private val searchRepository: SearchRepository
) : BaseViewModel(mainCoroutineDispatcher) {

    private val topCityChanel = Channel<Resource<CityResponse>>()
    val topCity = topCityChanel.receiveAsFlow()

    private val popularCityChanel = Channel<Resource<CityResponse>>()
    val popularCity = popularCityChanel.receiveAsFlow()

    private val searchChanel = Channel<Resource<HotelResponse>>()
    val search = searchChanel.receiveAsFlow()


    fun getTopCity() = doInMain {
        topCityChanel.send(Resource.Loading)
        topCityChanel.send(searchRepository.getTopCity())
    }
    fun getPopularCity() = doInMain {
        popularCityChanel.send(Resource.Loading)
        popularCityChanel.send(searchRepository.getPopularCity())
    }
    fun getSearch(cityName:String) = doInMain {
        searchChanel.send(Resource.Loading)
        searchChanel.send(searchRepository.getSearch(cityName))
    }

}




