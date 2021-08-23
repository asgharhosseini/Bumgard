package ir.ah.app.bumgard.ui.city

import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.repository.city.*

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
class CityViewModel @Inject constructor(
    val mainCoroutineDispatcher: CoroutineDispatcher,
    repository: CityRepository
) : BaseViewModel(mainCoroutineDispatcher) {
}




