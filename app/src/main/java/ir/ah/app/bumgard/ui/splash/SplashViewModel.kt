package ir.ah.app.bumgard.ui.splash

import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.local.sharedpreferences.*
import ir.ah.app.bumgard.other.wrapper.*

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@HiltViewModel
class SplashViewModel @Inject constructor(
    val mainCoroutineDispatcher: CoroutineDispatcher,
    private val userInfoManager: UserInfoManager
) : BaseViewModel(mainCoroutineDispatcher) {

    fun refreshToken() = doInMain {
        if (userInfoManager.getEmail() != "" &&
            userInfoManager.getToken() != ""

        ) {
            splashEventChannel.send(Resource.Success(true))
        }
    }

    private val splashEventChannel = Channel<Resource<Boolean>>()
    val splashEvent = splashEventChannel.receiveAsFlow()

    init {
        refreshToken()
    }
}




