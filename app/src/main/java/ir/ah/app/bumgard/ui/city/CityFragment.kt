package ir.ah.app.bumgard.ui.city


import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*

@AndroidEntryPoint
class CityFragment : BaseFragment<CityViewModel>(
    R.layout.fragment_city, CityViewModel::class
) {
    private val binding by viewBinding(FragmentCityBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()

    }


}