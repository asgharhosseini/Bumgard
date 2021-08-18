package ir.ah.app.bumgard.ui.search


import android.text.*
import android.util.*
import android.view.*
import androidx.lifecycle.*
import androidx.recyclerview.widget.*
import dagger.hilt.android.*
import ir.ah.app.bumgard.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*
import ir.ah.app.bumgard.other.util.*
import ir.ah.app.bumgard.other.util.Constance.TAG
import ir.ah.app.bumgard.other.util.UtilityAnimation.fadeVisibility
import ir.ah.app.bumgard.other.wrapper.*
import ir.ah.app.bumgard.ui.search.adapter.*
import kotlinx.coroutines.flow.*
import javax.inject.*


@AndroidEntryPoint
class SearchFragment : BaseFragment<SearchViewModel>(
    R.layout.fragment_search, SearchViewModel::class
) {
    private val binding by viewBinding(FragmentSearchBinding::bind)
    @Inject
    lateinit var topCityAdapter: TopCityAdapter
    @Inject
    lateinit var popularCityAdapter: PopularCityAdapter

    override fun observeData() {
        super.observeData()
        subscribeToObserve()
    }

    override fun setUpViews() {
        super.setUpViews()
        (activity as MainActivity).showBottomNav()
        handleSearchEditor()
        setUpAdapter()
        setUpSearch()



    }

    private fun setUpSearch() {
        binding.edtSearch.afterTextChanged { it ->
            vm.searchQuery.value = it
        }
        binding.ivDown.setOnClickListener {
            if (vm.guest.value != 1) {
                vm.guest.value -= 1
              binding.edtCountGuest .text = Editable.Factory.getInstance()
                    .newEditable("${ vm.guest.value.toString()}")

            }
        }
        binding.ivUp.setOnClickListener {
            if (vm.guest.value <=5){
                vm.guest.value += 1
                binding.edtCountGuest .text = Editable.Factory.getInstance()
                    .newEditable("${ vm.guest.value.toString()}")
            }

        }


    }

    private fun subscribeToObserve() {
        vm.getTopCity()
        vm.getPopularCity()
        lifecycleScope.launchWhenStarted {
            vm.topCity.collectLatest { event ->
                handleResource(event) { vm.getTopCity() }
                when(event){
                   is Resource.Loading ->{}
                   is Resource.Success ->{
                       topCityAdapter.submitList(event.success.cities)
                   }
                   is Resource.Failure ->{}
                }
                vm.popularCity.collectLatest { event ->
                    handleResource(event) { vm.getPopularCity() }
                    when(event){
                        is Resource.Loading ->{}
                        is Resource.Success ->{
                            popularCityAdapter.submitList(event.success.cities)
                            Log.e(TAG,event.success.cities[0].name)
                        }
                        is Resource.Failure ->{}
                    }

            }

            }

        }


    }

    private fun setUpAdapter() {
        topCityAdapter.setOnItemClickListener { }
        binding.rvSearchFragmentTop.apply {
            adapter = topCityAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
        popularCityAdapter.setOnItemClickListener { }
        binding.rvSearchFragmentPopular.apply {
            adapter = popularCityAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
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