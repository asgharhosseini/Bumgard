package ir.ah.app.bumgard.ui.search

import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.data.repository.search.*
import ir.ah.app.bumgard.other.util.*
import ir.ah.app.bumgard.other.wrapper.*
import ir.ah.app.bumgard.ui.auth.signup.*

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

    private val facilitiesChanel = Channel<Resource<FacilitiesResponse>>()
    val facilities = facilitiesChanel.receiveAsFlow()

    private val searchChanel = Channel<Resource<HotelResponse>>()
    val search = searchChanel.receiveAsFlow()

    private val searchQueryChanel = Channel<SearchEvent>()
    val searchQuery = searchQueryChanel.receiveAsFlow()

    val searchQueryText: MutableStateFlow<String> = MutableStateFlow("")
    val checkOutDate: MutableStateFlow<String> = MutableStateFlow(getTomorrowDate())
    val checkInDate: MutableStateFlow<String> = MutableStateFlow(getTodayDate())
    val guest: MutableStateFlow<Int> = MutableStateFlow(1)
    val filterFacilitiesList: MutableStateFlow<List<Facilities>> = MutableStateFlow(listOf())
    val filterStar: MutableStateFlow<String> = MutableStateFlow("all")
    val priceOf: MutableStateFlow<String> = MutableStateFlow("")
    val priceUp: MutableStateFlow<String> = MutableStateFlow("")



    fun validateSearch() {
        val searchQueryText = searchQueryText.value
        val checkOutDate = checkOutDate.value
        val checkInDate = checkInDate.value
        val guest = guest.value
        doInMain {
            if (searchQueryText.isEmpty()) {
                searchQueryChanel.send(SearchEvent.SearchQueryIsEmpty)
                return@doInMain
            }

            getSearch(searchQueryText,checkInDate,checkOutDate,guest)
            return@doInMain
        }
    }


    fun getTopCity() = doInMain {
        topCityChanel.send(Resource.Loading)
        topCityChanel.send(searchRepository.getTopCity())
    }

    fun getPopularCity() = doInMain {
        popularCityChanel.send(Resource.Loading)
        popularCityChanel.send(searchRepository.getPopularCity())
    }

    fun getFacilities() = doInMain {
        facilitiesChanel.send(Resource.Loading)
        facilitiesChanel.send(searchRepository.getFacilities())
    }

    private fun getSearch(cityName: String, checkInDate: String, checkOutDate: String, guest: Int) =
        doInMain {
            searchChanel.send(Resource.Loading)
            searchChanel.send(
                searchRepository.getSearch(
                    cityName,
                    checkInDate,
                    checkOutDate,
                    guest
                )
            )
        }

}




