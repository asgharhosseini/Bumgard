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
        if (userInfoManager.getEmail().isNullOrEmpty()&&
            userInfoManager.getToken().isNullOrEmpty()
        ) {
            splashEventChannel.send(SplashEvent.NavigateToAuth(false))
        }else{
            splashEventChannel.send(SplashEvent.NavigateToSearch(true))
        }
    }

    private val splashEventChannel = Channel<SplashEvent>()
    val splashEvent = splashEventChannel.receiveAsFlow()

    init {
        refreshToken()
    }
}




