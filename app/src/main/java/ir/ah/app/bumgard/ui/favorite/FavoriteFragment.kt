package ir.ah.app.bumgard.ui.favorite


import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FavoriteViewModel>(
    R.layout.fragment_favorite, FavoriteViewModel::class
) {
    private val binding by viewBinding(FragmentFavoriteBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()

    }


}