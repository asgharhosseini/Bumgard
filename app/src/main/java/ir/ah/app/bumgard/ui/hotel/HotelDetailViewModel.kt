package ir.ah.app.bumgard.ui.hotel

import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.repository.hotel.*

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
class HotelDetailViewModel @Inject constructor(
    val mainCoroutineDispatcher: CoroutineDispatcher,
    private val hotelRepository: HotelRepository
) : BaseViewModel(mainCoroutineDispatcher) {
}




