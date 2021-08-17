package ir.ah.app.bumgard.ui.search


import dagger.hilt.android.*
import ir.ah.app.bumgard.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*

@AndroidEntryPoint
class SearchFragment : BaseFragment<SearchViewModel>(
    R.layout.fragment_search, SearchViewModel::class
) {
    private val binding by viewBinding(FragmentSearchBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()
        (activity as MainActivity).showBottomNav()

    }


}