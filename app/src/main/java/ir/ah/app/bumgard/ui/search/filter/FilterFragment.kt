package ir.ah.app.bumgard.ui.search.filter


import android.os.*
import android.util.*
import android.view.*
import android.widget.*
import androidx.navigation.fragment.*
import androidx.recyclerview.selection.*
import androidx.recyclerview.widget.*
import com.google.android.material.chip.*
import com.google.android.material.slider.*
import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*
import ir.ah.app.bumgard.ui.search.*
import ir.ah.app.bumgard.ui.search.filter.adapter.*
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

    val myList = listOf(
        Facilities(0,"Alice", R.drawable.ic_calendar),
        Facilities(1,"Bob",  R.drawable.ic_calendar),
        Facilities(2,"Carol", R.drawable.ic_calendar),
        Facilities(3,"Dan",  R.drawable.ic_calendar),
        Facilities(4,"Eric", R.drawable.ic_calendar),
        Facilities(5,"Craig", R.drawable.ic_calendar)
    )
    override fun observeData() {
        super.observeData()



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
        }
       binding.chipsGroup.setOnCheckedChangeListener { chipGroup, checkedId ->
            val titleOrNull = chipGroup.findViewById<Chip>(checkedId)?.text
            Toast.makeText(chipGroup.context, titleOrNull ?: "No Choice", Toast.LENGTH_LONG).show()
        }

        binding.rangeSlider.apply {
            addOnChangeListener(object : RangeSlider.OnChangeListener{

                override fun onValueChange(slider: RangeSlider, value: Float, fromUser: Boolean) {
                    val values =  this@apply.values

                    Log.d("From", values[0].toString())
                    Log.d("T0", values[1].toString())
                }
            })
            setLabelFormatter {
                    value: Float ->
                val format = NumberFormat.getCurrencyInstance()
                format.maximumFractionDigits = 0
                format.currency = Currency.getInstance("USD")
                format.format(value.toDouble())
            }
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
        facilitiesAdapter.submitList(myList)

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