package ir.ah.app.bumgard.ui.intro


import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*

@AndroidEntryPoint
class IntroFragment : BaseFragment<IntroViewModel>(
    R.layout.fragment_intro, IntroViewModel::class
) {
    private val binding by viewBinding(FragmentIntroBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()

    }


}