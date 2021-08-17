package ir.ah.app.bumgard.ui.search


import android.view.*
import android.view.animation.*
import dagger.hilt.android.*
import ir.ah.app.bumgard.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*
import ir.ah.app.bumgard.other.util.*
import ir.ah.app.bumgard.other.util.UtilityAnimation.fadeVisibility


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
        handleSearchEditor()


    }
    private fun handleSearchEditor(){
        binding.edtSearch.afterTextChanged { it ->
            if (it.length > 0) {
                binding.filterLayout.fadeVisibility(View.VISIBLE, 600)
                binding.baseView.fadeVisibility(View.GONE, 600)
                binding.searchResultView.fadeVisibility(View.VISIBLE, 600)


            } else {
                binding.filterLayout.fadeVisibility(View.GONE, 600)
                binding.baseView.fadeVisibility(View.VISIBLE, 600)
                binding.searchResultView.fadeVisibility(View.GONE, 600)

            }

        }
    }

}