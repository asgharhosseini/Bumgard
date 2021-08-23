package ir.ah.app.bumgard.ui.city


import android.util.*
import androidx.lifecycle.*
import androidx.navigation.fragment.*
import androidx.recyclerview.widget.*
import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*
import ir.ah.app.bumgard.other.util.Constance.TAG
import ir.ah.app.bumgard.other.wrapper.*
import ir.ah.app.bumgard.ui.city.adapter.*
import kotlinx.coroutines.flow.*
import javax.inject.*

@AndroidEntryPoint
class CityFragment : BaseFragment<CityViewModel>(
    R.layout.fragment_city, CityViewModel::class
) {
    private val binding by viewBinding(FragmentCityBinding::bind)
    private val arg by navArgs<CityFragmentArgs>()
    @Inject
    lateinit var hotelInCityAdapter: HotelInCityAdapter


    override fun observeData() {
        super.observeData()
        subscribeToObserve()
    }

    private fun subscribeToObserve() {
        vm.getHotelInCity()
        lifecycleScope.launchWhenStarted {
            vm.hotelInCity.collectLatest { event ->
                handleResource(event) { vm.getHotelInCity() }
                when (event) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        hotelInCityAdapter.submitList(event.success.hotels)
                    }
                    is Resource.Failure -> {
                    }
                }

            }
        }
    }

    override fun setUpViews() {
        super.setUpViews()
        vm.cityName.value=arg.cityName
        binding.toolbar.apply {
            title=arg.cityName
            navigationIcon = resources.getDrawable(R.drawable.ic_back)
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
        setUpAdapter()

    }

    private fun setUpAdapter() {
        binding.recyclerView.apply {
            adapter = hotelInCityAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }


}