package ir.ah.app.bumgard.ui.hotel

import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.data.repository.hotel.*
import ir.ah.app.bumgard.other.wrapper.*

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
class HotelDetailViewModel @Inject constructor(
    val mainCoroutineDispatcher: CoroutineDispatcher,
    private val hotelRepository: HotelRepository
) : BaseViewModel(mainCoroutineDispatcher) {
    val hotelId: MutableStateFlow<Int> = MutableStateFlow(0)
    private val hotelDetailChanel = Channel<Resource<HotelDetailResponse>>()
    val hotelDetail = hotelDetailChanel.receiveAsFlow()

    fun getHotelInCity() =
        doInMain {
            hotelDetailChanel.send(Resource.Loading)

            hotelDetailChanel.send(hotelRepository.getHotelDetail(hotelId.value))
            }
}




