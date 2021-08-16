package ir.ah.app.bumgard.ui.auth.signup

import com.google.android.material.snackbar.*
import com.google.firebase.auth.*
import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.local.sharedpreferences.*

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.*
import ir.ah.app.bumgard.other.util.*
import ir.ah.app.bumgard.other.wrapper.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.tasks.*
import java.util.regex.*


@HiltViewModel
class SingUpViewModel @Inject constructor(
    val mainCoroutineDispatcher: CoroutineDispatcher,
    private val userInfoManager: UserInfoManager
) : BaseViewModel(mainCoroutineDispatcher) {

    val userEmail: MutableStateFlow<String> = MutableStateFlow("")
    val userPassword: MutableStateFlow<String> = MutableStateFlow("")
    val userConfirmPassword: MutableStateFlow<String> = MutableStateFlow("")
    private val signUpEventChannel = Channel<SignUpEvent>()
    val signUpEvent = signUpEventChannel.receiveAsFlow()
    lateinit var auth : FirebaseAuth

    init {
        auth = FirebaseAuth.getInstance()
    }

    fun validateUser() {
        val userEmail = userEmail.value
        val userPassword = userPassword.value
        val userConfirmPassword= userConfirmPassword.value
        doInMain {
            if (userEmail.isEmpty()) {
                signUpEventChannel.send(SignUpEvent.UserEmailIsEmpty)
                return@doInMain
            }
            if (userPassword.isEmpty()) {
                signUpEventChannel.send(SignUpEvent.UserPasswordIsEmpty)
                return@doInMain
            }
            if (userConfirmPassword.isEmpty()) {
                signUpEventChannel.send(SignUpEvent.UserConfirmPasswordIsEmpty)
                return@doInMain
            }
            if (userPassword != userConfirmPassword) {
                signUpEventChannel.send(SignUpEvent.PasswordAndPasswordVerificationAreNotTheSame)
                return@doInMain
            }

            if (!userEmail.isValidEmail()) {
                signUpEventChannel.send(SignUpEvent.EmailIsNotValid)
                return@doInMain
            }
            if (userPassword.count { it.isDigit() } < 6) {
                signUpEventChannel.send(SignUpEvent.InvalidUserPassword)
                return@doInMain
            }
            if (userConfirmPassword.count { it.isDigit() } < 6) {
                signUpEventChannel.send(SignUpEvent.InvalidUserConfirmPassword)
                return@doInMain
            }
            registerUser(userEmail,userPassword)
            return@doInMain
        }
    }

    private fun registerUser(userEmail: String, userPassword: String) =doInMain {
        try {

            auth.createUserWithEmailAndPassword(userEmail, userPassword).await()
            withContext(Dispatchers.Main) {
                userInfoManager.clear()
                auth.currentUser!!.email?.let { userInfoManager.saveUser(email = it, token = auth.currentUser!!.uid) }
                signUpEventChannel.send(SignUpEvent.NavigateBackWithResult(true))
            }


        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                signUpEventChannel.send(SignUpEvent.ShowError(ApiCallFailure.OtherError(e.message,e)))

            }
        }
    }



}




