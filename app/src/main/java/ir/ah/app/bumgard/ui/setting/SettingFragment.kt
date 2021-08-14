package ir.ah.app.bumgard.ui.setting


import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*

@AndroidEntryPoint
class SettingFragment : BaseFragment<SettingViewModel>(
    R.layout.fragment_setting, SettingViewModel::class
) {
    private val binding by viewBinding(FragmentSettingBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()

    }


}