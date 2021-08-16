package ir.ah.app.bumgard.ui.auth.signup

import ir.ah.app.bumgard.other.wrapper.*

sealed class SignUpEvent {
    object UserEmailIsEmpty : SignUpEvent()
    object UserPasswordIsEmpty : SignUpEvent()
    object UserConfirmPasswordIsEmpty : SignUpEvent()
    object PasswordAndPasswordVerificationAreNotTheSame : SignUpEvent()
    object EmailIsNotValid : SignUpEvent()
    object InvalidUserPassword : SignUpEvent()
    object InvalidUserConfirmPassword: SignUpEvent()
    data class NavigateToHome(val UserEmail:String, val UserPassword:String) : SignUpEvent()
    data class NavigateBackWithResult(val result: Boolean) : SignUpEvent()
    data class ShowError(val failure: FailureInterface?) : SignUpEvent()
}