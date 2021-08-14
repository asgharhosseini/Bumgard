package ir.ah.app.bumgard.ui.favorite

import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    val mainCoroutineDispatcher: CoroutineDispatcher,
) : BaseViewModel(mainCoroutineDispatcher) {
}




