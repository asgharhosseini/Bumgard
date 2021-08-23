package ir.ah.app.bumgard.ui.search.filter


import android.os.*
import android.util.*
import android.view.*
import android.widget.*
import androidx.lifecycle.*
import androidx.navigation.fragment.*
import androidx.recyclerview.selection.*
import androidx.recyclerview.widget.*
import com.google.android.material.chip.*
import com.google.android.material.slider.*
import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.data.repository.factory.DummyFactory.facilitiesList
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*
import ir.ah.app.bumgard.other.wrapper.*
import ir.ah.app.bumgard.ui.search.*
import ir.ah.app.bumgard.ui.search.filter.adapter.*
import kotlinx.coroutines.flow.*
import java.text.*
import java.util.*
import javax.inject.*
import kotlin.math.*

@AndroidEntryPoint
class FilterFragment : BaseFragment<SearchViewModel>(
    R.layout.fragment_filter, SearchViewModel::class
) {
    private val binding by viewBinding(FragmentFilterBinding::bind)


    @Inject
    lateinit var facilitiesAdapter: FacilitiesAdapter

    override fun observeData() {
        super.observeData()

        subscribeToObserve()
    }

    private fun subscribeToObserve() {
        vm.getFacilities()
        lifecycleScope.launchWhenStarted {
            vm.facilities.collectLatest { event ->
                handleResource(event) { vm.getFacilities() }
                when (event) {
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {

                       facilitiesAdapter.submitList(event.success.facilities)
                    }
                    is Resource.Failure -> {
                    }
                }
            }
        }
    }


    override fun setUpViews() {
        super.setUpViews()

        onClickItem()
        setupAdapter()
    }

    private fun onClickItem() {
        binding.toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_back)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
            vm.filterFacilitiesList.value = listOf()
            vm.filterStar.value = "all"
            vm.priceOf.value = ""
            vm.priceUp.value = ""
            facilitiesAdapter.clearSelectedList()
        }
        binding.chipsGroup.setOnCheckedChangeListener { chipGroup, checkedId ->
            val titleOrNull = chipGroup.findViewById<Chip>(checkedId)?.text
            vm.filterStar.value = titleOrNull.toString()
           // Toast.makeText(chipGroup.context, titleOrNull ?: "No Choice", Toast.LENGTH_LONG).show()
        }

        binding.rangeSlider.apply {
            addOnChangeListener(object : RangeSlider.OnChangeListener {
                override fun onValueChange(slider: RangeSlider, value: Float, fromUser: Boolean) {
                    val values = this@apply.values
                    vm.priceOf.value = values[0].toString()
                    vm.priceUp.value = values[1].toString()
                }
            })
            setLabelFormatter { value: Float ->
                val format = NumberFormat.getCurrencyInstance()
                format.maximumFractionDigits = 0
                format.currency = Currency.getInstance("USD")
                format.format(value.toDouble())
            }
        }

        binding.btnDone.setOnClickListener {
            vm.filterFacilitiesList.value = facilitiesAdapter.getSelectedList()
            findNavController().popBackStack()
        }

    }

    var tracker: SelectionTracker<String>? = null
    private fun setupAdapter() {

        binding.recyclerView.apply {
            adapter = facilitiesAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        facilitiesAdapter.submitList(facilitiesList)
        tracker = SelectionTracker.Builder<String>(
            "mySelection",
            binding.recyclerView,
            MyItemKeyProvider(facilitiesAdapter),
            MyItemDetailsLookup(binding.recyclerView),
            StorageStrategy.createStringStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()
        facilitiesAdapter.tracker = tracker
        tracker?.addObserver(
            object : SelectionTracker.SelectionObserver<String>() {
                override fun onSelectionChanged() {
                    super.onSelectionChanged()

                }
            })


    }


}