package ir.ah.app.bumgard.ui.city

import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.data.repository.city.*
import ir.ah.app.bumgard.other.wrapper.*

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
class CityViewModel @Inject constructor(
    val mainCoroutineDispatcher: CoroutineDispatcher,
    private val repository: CityRepository
) : BaseViewModel(mainCoroutineDispatcher) {
    val cityName: MutableStateFlow<String> = MutableStateFlow("")
    private val hotelInCityChanel = Channel<Resource<HotelResponse>>()
    val hotelInCity = hotelInCityChanel.receiveAsFlow()

    private fun getSearch() =
        doInMain {
            hotelInCityChanel.send(Resource.Loading)

            cityName.value?.let {
                hotelInCityChanel.send(
                    repository.getCity(it)
                )
            }

        }

}



