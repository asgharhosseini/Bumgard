package ir.ah.app.bumgard.ui.splash

import com.google.firebase.auth.*
import ir.ah.app.bumgard.other.wrapper.*

sealed class SplashEvent {

    data class NavigateToSearch(val result: Boolean) : SplashEvent()
    data class NavigateToAuth(val result: Boolean) : SplashEvent()

}