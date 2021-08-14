package ir.ah.app.bumgard.ui.search

import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
class SearchViewModel @Inject constructor(
    val mainCoroutineDispatcher: CoroutineDispatcher,
) : BaseViewModel(mainCoroutineDispatcher) {
}




