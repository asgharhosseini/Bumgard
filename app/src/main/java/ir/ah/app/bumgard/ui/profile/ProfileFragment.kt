package ir.ah.app.bumgard.ui.profile


import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*

@AndroidEntryPoint
class ProfileFragment : BaseFragment<ProfileViewModel>(
    R.layout.fragment_profile, ProfileViewModel::class
) {
    private val binding by viewBinding(FragmentProfileBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()

    }


}