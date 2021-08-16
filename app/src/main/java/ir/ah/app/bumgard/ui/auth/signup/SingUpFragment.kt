package ir.ah.app.bumgard.ui.auth.signup


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
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class SingUpFragment : BaseFragment<SingUpViewModel>(
    R.layout.fragment_sing_up, SingUpViewModel::class
) {
    private val binding by viewBinding(FragmentSingUpBinding::bind)


    override fun setUpViews() {
        super.setUpViews()
        binding.edtEmailText.afterTextChanged { it ->
            vm.userEmail.value = it

        }
        binding.edtPassword.afterTextChanged { it ->
            vm.userPassword.value = it
        }
        binding.edtConfirmPassword.afterTextChanged { it ->
            vm.userConfirmPassword.value=it
            if (it==vm.userPassword.value && !vm.userEmail.value.isNullOrEmpty()){

                binding.btnRegister.isEnabled = it.count { it.isDigit() } >=6
            }
        }

        onItemClick()

    }

    private fun onItemClick() {
        binding.btnRegister.setOnClickListener {
            vm.validateUser()
        }
    }

    override fun observeData() {
        super.observeData()
        lifecycleScope.launchWhenStarted{
            vm.signUpEvent.collectLatest { event->
                when(event){
                    SignUpEvent.UserEmailIsEmpty->{
                        binding.edtEmailText.error=getString(R.string.user_email_is_empty)
                    }
                    SignUpEvent.UserPasswordIsEmpty->{
                        binding.edtPassword.error=getString(R.string.user_password_is_empty)
                    }
                    SignUpEvent.UserConfirmPasswordIsEmpty->{
                        binding.edtConfirmPassword.error=getString(R.string.user_confirm_password_is_empty)
                    }
                    SignUpEvent.EmailIsNotValid->{
                        binding.edtEmailText.error=getString(R.string.email_format_is_incorrect)
                    }
                    SignUpEvent.PasswordAndPasswordVerificationAreNotTheSame->{
                        binding.edtConfirmPassword.error=getString(R.string.password_and_password_verification_are_not_the_same)
                    }
                    SignUpEvent.InvalidUserPassword->{
                        binding.edtPassword.error=getString(R.string.password_must_be_longer_than_6_characters)
                    }
                    SignUpEvent.InvalidUserConfirmPassword->{
                        binding.edtConfirmPassword.error=getString(R.string.confirm_password_must_be_longer_than_6_characters)
                    }
                   is SignUpEvent.NavigateBackWithResult ->{
                       setNavigationResult(
                           event.result,
                            RESULT_REGISTER,
                           findNavController()
                       )
                       findNavController().popBackStack()
                   }
                   is SignUpEvent.ShowError ->{

                   }



                }
            }

        }



    }




}