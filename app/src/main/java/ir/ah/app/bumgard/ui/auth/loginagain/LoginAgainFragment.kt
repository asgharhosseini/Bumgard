package ir.ah.app.bumgard.ui.auth.loginagain


import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*

@AndroidEntryPoint
class LoginAgainFragment : BaseFragment<LoginAgainViewModel>(
    R.layout.fragment_login_again, LoginAgainViewModel::class
) {
    private val binding by viewBinding(FragmentLoginAgainBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()

    }


}