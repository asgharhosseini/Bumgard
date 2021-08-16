package ir.ah.app.bumgard.ui.auth.singin


import androidx.lifecycle.*
import androidx.navigation.fragment.*
import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*
import ir.ah.app.bumgard.other.util.*
import ir.ah.app.bumgard.other.util.Constance.RESULT_LOGIN
import ir.ah.app.bumgard.other.util.Constance.RESULT_REGISTER
import ir.ah.app.bumgard.ui.auth.signup.*
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class SingInFragment : BaseFragment<SingInViewModel>(
    R.layout.fragment_sing_in, SingInViewModel::class
) {
    private val binding by viewBinding(FragmentSingInBinding::bind)


    override fun observeData() {
        super.observeData()
        lifecycleScope.launchWhenStarted{
            vm.signInEvent.collectLatest { event->
                when(event){
                    SignInEvent.UserEmailIsEmpty->{
                        binding.edtEmailText.error=getString(R.string.user_email_is_empty)
                    }
                    SignInEvent.UserPasswordIsEmpty->{
                        binding.edtPassword.error=getString(R.string.user_password_is_empty)
                    }
                    SignInEvent.EmailIsNotValid->{
                        binding.edtEmailText.error=getString(R.string.email_format_is_incorrect)
                    }
                    SignInEvent.InvalidUserPassword->{
                        binding.edtPassword.error=getString(R.string.password_must_be_longer_than_6_characters)
                    }

                    is SignInEvent.NavigateBackWithResult ->{
                        setNavigationResult(
                            event.result,
                            RESULT_LOGIN,
                            findNavController()
                        )
                        findNavController().popBackStack()
                    }
                    is SignInEvent.ShowError ->{

                    }



                }
            }

        }
    }

    override fun setUpViews() {
        super.setUpViews()
        binding.edtEmailText.afterTextChanged { it ->
            vm.userEmail.value = it

        }
        binding.edtPassword.afterTextChanged { it ->
            vm.userPassword.value = it
            if (it==vm.userPassword.value && !vm.userEmail.value.isNullOrEmpty()){
                binding.btnLogin.isEnabled = it.count { it.isDigit() } >=6
            }
        }
        onRegisterSuccessNavigationResultReceived()
        onLoginSuccessNavigationResultReceived()
        onItemClick()
    }

    private fun onItemClick() {
        binding.tvSingUp.setOnClickListener {
            findNavController().navigate(SingInFragmentDirections.actionSingInFragmentToSingUpFragment())
        }
        binding.btnLogin.setOnClickListener {
            vm.validateUser()
        }
    }

    private fun onRegisterSuccessNavigationResultReceived() {
        getNavigationResult<Boolean>(RESULT_REGISTER, findNavController())?.observe(viewLifecycleOwner) {
            removeNavigationResult<Boolean>(RESULT_REGISTER)
            if (it) {
                setNavigationResult(true, RESULT_LOGIN)
                findNavController().popBackStack()
            }
        }
    }
    private fun onLoginSuccessNavigationResultReceived() {
        getNavigationResult<Boolean>(RESULT_LOGIN, findNavController())?.observe(viewLifecycleOwner) {
            removeNavigationResult<Boolean>(RESULT_LOGIN)
            if (it) {
                setNavigationResult(true, RESULT_LOGIN)
                findNavController().popBackStack()
            }
        }
    }

}