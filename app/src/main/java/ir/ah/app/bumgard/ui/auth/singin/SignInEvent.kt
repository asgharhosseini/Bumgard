package ir.ah.app.bumgard.ui.auth.singin

import com.google.firebase.auth.*
import ir.ah.app.bumgard.other.wrapper.*

sealed class SignInEvent {
    object UserEmailIsEmpty : SignInEvent()
    object UserPasswordIsEmpty : SignInEvent()
    object EmailIsNotValid : SignInEvent()
    object InvalidUserPassword : SignInEvent()
    data class NavigateBackWithResult(val result: Boolean) : SignInEvent()
    data class ShowError(val failure: FailureInterface?) : SignInEvent()
    lateinit var auth : FirebaseAuth

    init {
        auth = FirebaseAuth.getInstance()
    }

}