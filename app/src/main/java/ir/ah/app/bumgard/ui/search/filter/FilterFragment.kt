package ir.ah.app.bumgard.ui.search.filter


import android.util.*
import android.widget.*
import androidx.navigation.fragment.*
import com.google.android.material.chip.*
import com.google.android.material.slider.*
import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*
import ir.ah.app.bumgard.ui.search.*
import java.text.*
import java.util.*
import kotlin.math.*

@AndroidEntryPoint
class FilterFragment : BaseFragment<SearchViewModel>(
    R.layout.fragment_filter, SearchViewModel::class
) {
    private val binding by viewBinding(FragmentFilterBinding::bind)


    override fun observeData() {
        super.observeData()

    }

    override fun setUpViews() {
        super.setUpViews()

        onClickItem()

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


}