package ir.ah.app.bumgard.ui.auth.forgotpassword

import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    val mainCoroutineDispatcher: CoroutineDispatcher,
) : BaseViewModel(mainCoroutineDispatcher) {
}




