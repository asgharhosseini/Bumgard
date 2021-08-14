package ir.ah.app.bumgard.ui.auth.singin


import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*

@AndroidEntryPoint
class SingInFragment : BaseFragment<SingInViewModel>(
    R.layout.fragment_sing_in, SingInViewModel::class
) {
    private val binding by viewBinding(FragmentSingInBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()

    }


}