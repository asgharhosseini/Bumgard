package ir.ah.app.bumgard.ui.auth.singin

import com.google.firebase.auth.*
import dagger.hilt.android.lifecycle.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.local.sharedpreferences.*
import ir.ah.app.bumgard.other.util.*
import ir.ah.app.bumgard.other.wrapper.*
import ir.ah.app.bumgard.ui.auth.signup.*

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.tasks.*
import javax.inject.*

@HiltViewModel
class SingInViewModel @Inject constructor(
    val mainCoroutineDispatcher: CoroutineDispatcher,
    private val userInfoManager: UserInfoManager
) : BaseViewModel(mainCoroutineDispatcher) {
    val userEmail: MutableStateFlow<String> = MutableStateFlow("")
    val userPassword: MutableStateFlow<String> = MutableStateFlow("")
    private val signInEventChannel = Channel<SignInEvent>()
    val signInEvent = signInEventChannel.receiveAsFlow()
    lateinit var auth : FirebaseAuth

    init {
        auth = FirebaseAuth.getInstance()
    }
    fun validateUser() {
        val userEmail = userEmail.value
        val userPassword = userPassword.value

        doInMain {
            if (userEmail.isEmpty()) {
                signInEventChannel.send(SignInEvent.UserEmailIsEmpty)
                return@doInMain
            }
            if (userPassword.isEmpty()) {
                signInEventChannel.send(SignInEvent.UserPasswordIsEmpty)
                return@doInMain
            }

            if (!userEmail.isValidEmail()) {
                signInEventChannel.send(SignInEvent.EmailIsNotValid)
                return@doInMain
            }
            if (userPassword.count { it.isDigit() } < 6) {
                signInEventChannel.send(SignInEvent.InvalidUserPassword)
                return@doInMain
            }
            loginUser(userEmail,userPassword)
            return@doInMain
        }
    }

    private fun loginUser(userEmail: String, userPassword: String) =doInMain {
        try {

            auth.signInWithEmailAndPassword(userEmail, userPassword).await()
            withContext(Dispatchers.Main) {
                userInfoManager.clear()
                auth.currentUser!!.email?.let { userInfoManager.saveUser(email = it, token = auth.currentUser!!.uid) }
                signInEventChannel.send(SignInEvent.NavigateBackWithResult(true))
            }


        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                signInEventChannel.send(SignInEvent.ShowError(ApiCallFailure.OtherError(e.message,e)))

            }
        }
    }





}




