package ir.ah.app.bumgard.ui.auth.signup


import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*

@AndroidEntryPoint
class SingUpFragment : BaseFragment<SingUpViewModel>(
    R.layout.fragment_sing_up, SingUpViewModel::class
) {
    private val binding by viewBinding(FragmentSingUpBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()

    }


}