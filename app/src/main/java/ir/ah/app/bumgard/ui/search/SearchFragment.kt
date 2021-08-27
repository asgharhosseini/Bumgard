package ir.ah.app.bumgard.ui.search


import android.text.*
import android.view.*
import androidx.lifecycle.*
import androidx.recyclerview.widget.*
import com.google.android.material.datepicker.*

import dagger.hilt.android.*
import ir.ah.app.bumgard.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*
import ir.ah.app.bumgard.other.util.*
import androidx.core.util.Pair
import androidx.core.widget.*
import androidx.navigation.fragment.*
import ir.ah.app.bumgard.other.util.UtilityAnimation.fadeVisibility
import ir.ah.app.bumgard.other.wrapper.*
import ir.ah.app.bumgard.ui.search.adapter.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.text.*
import java.util.*
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

    @Inject
    lateinit var searchAdapter: SearchAdapter

    var job: Job? = null
    override fun observeData() {
        super.observeData()
        subscribeToObserve()

    }


    override fun setUpViews() {
        super.setUpViews()
        (activity as MainActivity).showBottomNav()
        handleSearchEditor()
        setUpAdapter()
        onItemClick()


    }

    private fun onItemClick() {
        topCityAdapter.setOnItemClickListener { city->
            findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToCityFragment(city.name))
        }
        popularCityAdapter.setOnItemClickListener { city->
            findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToCityFragment(city.name))
        }
        searchAdapter.setOnItemClickListener {
            searchAdapter.setOnItemClickListener {
                findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToHotelDetailFragment(it.name,it.id))
            }
        }
        binding.ivDown.setOnClickListener {
            if (vm.guest.value != 1) {
                vm.guest.value -= 1
                binding.edtCountGuest.text = Editable.Factory.getInstance()
                    .newEditable("${vm.guest.value.toString()}")

            }
        }
        binding.ivUp.setOnClickListener {
            if (vm.guest.value <= 5) {
                vm.guest.value += 1
                binding.edtCountGuest.text = Editable.Factory.getInstance()
                    .newEditable("${vm.guest.value.toString()}")
            }

        }
        binding.txtDateReturn.setOnClickListener {
            onDateRangeSelected()
        }
        binding.txtDateDeparture.setOnClickListener {
            onDateRangeSelected()
        }
        binding.btnSearch.setOnClickListener {

            subscribeToObserveSearch()
            binding.txtDateReturn.text = vm.checkOutDate.value
            binding.txtDateDeparture.text = vm.checkInDate.value
        }
        binding.btnFilter.setOnClickListener {
            findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToFilterFragment())
        }

    }


    private fun subscribeToObserve() {
        vm.getTopCity()
        vm.getPopularCity()
        lifecycleScope.launchWhenStarted {
            vm.topCity.collectLatest { event ->
                handleResource(event) { vm.getTopCity() }
                when (event) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        topCityAdapter.submitList(event.success.cities)
                    }
                    is Resource.Failure -> {
                    }
                }

            }
        }
        lifecycleScope.launchWhenStarted {
            vm.popularCity.collectLatest { event ->
                handleResource(event) { vm.getPopularCity() }
                when (event) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        popularCityAdapter.submitList(event.success.cities)

                    }
                    is Resource.Failure -> {
                    }
                }

            }
        }


    }

    private fun subscribeToObserveSearch() {
        vm.validateSearch()
        lifecycleScope.launchWhenStarted {
            vm.searchQuery.collectLatest { event ->
                when (event) {
                    is SearchEvent.SearchQueryIsEmpty -> {
                        binding.edtSearch.error = getString(R.string.search_query_is_empty)
                    }
                    is SearchEvent.ShowError -> {
                    }
                }
            }
        }
        lifecycleScope.launchWhenStarted {
            vm.search.collectLatest { event ->
                when (event) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        searchAdapter.submitList(event.success.hotels)
                    }
                    is Resource.Failure -> {
                    }
                }

            }
        }
    }

    private fun setUpAdapter() {

        binding.rvSearchFragmentTop.apply {
            adapter = topCityAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        binding.rvSearchFragmentPopular.apply {
            adapter = popularCityAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
        binding.rvSearchFragmentSearch.apply {
            adapter = searchAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun handleSearchEditor() {
            binding.edtSearch.afterTextChanged {
                if (it.isNotEmpty()) {
                    vm.searchQueryText.value = it.toString().trim()
                    binding.filterLayout.fadeVisibility(View.VISIBLE, 600)
                    binding.baseView.fadeVisibility(View.GONE, 400)
                    binding.searchResultView.fadeVisibility(View.VISIBLE, 600)
                    binding.btnFilter.fadeVisibility(View.VISIBLE,600)


                } else {
                    binding.filterLayout.fadeVisibility(View.GONE, 600)
                    binding.baseView.fadeVisibility(View.VISIBLE, 600)
                    binding.searchResultView.fadeVisibility(View.GONE, 600)
                    binding.txtDateDeparture.text = getString(R.string.check_in_date)
                    binding.txtDateReturn.text = getString(R.string.check_out_date)
                    searchAdapter.submitList(listOf())
                    binding.btnFilter.fadeVisibility(View.GONE,600)

                }
            }
    }





private fun onDateRangeSelected() {
    val builder = MaterialDatePicker.Builder.dateRangePicker()
    val now = Calendar.getInstance()
    builder.setSelection(Pair(now.timeInMillis, now.timeInMillis))
    val picker = builder.build()
    picker.show(activity?.supportFragmentManager!!, picker.toString())
    picker.addOnNegativeButtonClickListener {
    }
    picker.addOnPositiveButtonClickListener {
        vm.checkInDate.value = dateFormatted(it.first)
        vm.checkOutDate.value = dateFormatted(it.second)

        binding.txtDateDeparture.text = dateFormatted(it.first)
        binding.txtDateReturn.text = dateFormatted(it.second)
    }


}



}

