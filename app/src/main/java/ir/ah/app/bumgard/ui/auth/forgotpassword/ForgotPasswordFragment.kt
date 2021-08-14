package ir.ah.app.bumgard.ui.auth.forgotpassword


import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*

@AndroidEntryPoint
class ForgotPasswordFragment : BaseFragment<ForgotPasswordViewModel>(
    R.layout.fragment_forgot_password, ForgotPasswordViewModel::class
) {
    private val binding by viewBinding(FragmentForgotPasswordBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()

    }


}