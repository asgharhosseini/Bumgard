package ir.ah.app.bumgard.ui.hotel


import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*

@AndroidEntryPoint
class HotelDetailFragment : BaseFragment<HotelDetailViewModel>(
    R.layout.fragment_hotel_detail, HotelDetailViewModel::class
) {
    private val binding by viewBinding(FragmentHotelDetailBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()

    }


}