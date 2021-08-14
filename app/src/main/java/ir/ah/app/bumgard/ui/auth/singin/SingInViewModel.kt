package ir.ah.app.bumgard.ui.auth.singin

import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
class SingInViewModel @Inject constructor(
    val mainCoroutineDispatcher: CoroutineDispatcher,
) : BaseViewModel(mainCoroutineDispatcher) {
}




