package ir.ah.app.bumgard.ui.hotel


import android.text.*
import androidx.core.util.Pair
import androidx.lifecycle.*
import androidx.navigation.fragment.*
import androidx.recyclerview.widget.*
import com.bumptech.glide.*
import com.google.android.material.appbar.*
import com.google.android.material.datepicker.*
import dagger.hilt.android.*
import ir.ah.app.bumgard.R
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.other.*
import ir.ah.app.bumgard.other.util.*
import ir.ah.app.bumgard.other.wrapper.*
import ir.ah.app.bumgard.ui.hotel.adapter.*
import kotlinx.coroutines.flow.*
import java.util.*
import javax.inject.*

@AndroidEntryPoint
class HotelDetailFragment : BaseFragment<HotelDetailViewModel>(
    R.layout.fragment_hotel_detail, HotelDetailViewModel::class
) {
    private val binding by viewBinding(FragmentHotelDetailBinding::bind)
    private val arg by navArgs<HotelDetailFragmentArgs>()
    @Inject
    lateinit var glide: RequestManager
    @Inject
    lateinit var hotelFacilitiesAdapter: HotelFacilitiesAdapter
    @Inject
    lateinit var hotelPhotosAdapter: HotelPhotosAdapter
    @Inject
    lateinit var hotelCommentAdapter: HotelCommentAdapter
    @Inject
    lateinit var hotelLanguagesAdapter: HotelLanguagesAdapter

    override fun observeData() {
        super.observeData()
        subscribeToObserve()
    }



    override fun setUpViews() {
        super.setUpViews()
        handleCollapsedToolbarTitle()
        binding.txtDateReturn.text = vm.checkOutDate.value
        binding.txtDateDeparture.text = vm.checkInDate.value
        onClickItem()
        setupAdapter()

    }

    private fun setupAdapter() {
        binding.recyclerViewFacilities.apply {
            adapter=hotelFacilitiesAdapter
            layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
        binding.recyclerViewPhotos.apply {
            adapter=hotelPhotosAdapter
            layoutManager=GridLayoutManager(requireContext(),3)
        }
        binding.recyclerViewComments.apply {
            adapter=hotelCommentAdapter
            layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
        binding.recyclerViewLanguages.apply {
            adapter=hotelLanguagesAdapter
            layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        }
    }

    private fun onClickItem() {
        hotelFacilitiesAdapter.setOnItemClickListener {  }
        hotelPhotosAdapter.setOnItemClickListener {  }
        hotelCommentAdapter.setOnItemClickListener {  }
        hotelLanguagesAdapter.setOnItemClickListener {  }
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
        binding.btnSelectRoom.setOnClickListener {

        }


    }
    private fun subscribeToObserve() {
        vm.hotelId.value=arg.hotelId
        vm.getHotelInCity()
        lifecycleScope.launchWhenStarted {
            vm.hotelDetail.collectLatest { event->
                when(event){
                    is Resource.Loading ->{}
                    is Resource.Success ->{
                        glide.load(event.success.hotel.image).into(binding.appBarImage)
                        binding.tvHotelPrice.text=event.success.hotel.price
                        binding.tvHotelName.text=arg.hotelName
                        binding.tvLocationHotel.text=event.success.hotel.locationName
                        binding.materialRatingBar2.rating=event.success.hotel.rate.toFloat()
                        binding.hotelRate.text= "(${event.success.hotel.rate})"
                        binding.tvRateInTopBase.text= event.success.hotel.rate.toString()
                        binding.tvRateLocation.text= ((event.success.hotel.ratings.location).toDouble()/10).toString()
                        binding.tvRateCleaning.text=(( event.success.hotel.ratings.cleaning).toDouble()/10).toString()
                        binding.tvRateService.text= ((event.success.hotel.ratings.service).toDouble()/10).toString()
                        binding.tvRatePrice.text= ((event.success.hotel.ratings.price).toDouble()/10).toString()
                        binding.progressBarLocation.progress= event.success.hotel.ratings.location
                        binding.progressBarCleaning.progress= event.success.hotel.ratings.cleaning
                        binding.progressBarService.progress= event.success.hotel.ratings.service
                        binding.progressBarPrice.progress= event.success.hotel.ratings.price
                        binding.tvAbout.text=event.success.hotel.about
                        hotelFacilitiesAdapter.submitList(event.success.hotel.facilities)
                        hotelPhotosAdapter.submitList(event.success.hotel.photos)
                        hotelCommentAdapter.submitList(event.success.hotel.comment)
                        hotelLanguagesAdapter.submitList(event.success.hotel.languages)

                    }
                    is Resource.Failure ->{}
                }

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
    private fun handleCollapsedToolbarTitle() {
        binding.appbar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = true
            var scrollRange = -1
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout!!.totalScrollRange
                }
                // verify if the toolbar is completely collapsed and set the movie name as the title
                // verify if the toolbar is completely collapsed and set the movie name as the title
                if (scrollRange + verticalOffset == 0) {
                    binding.toolbarTitle.text = arg.hotelName

                    isShow = true
                } else if (isShow) {
                    // display an empty string when toolbar is expanded
                    binding.toolbarTitle.text = getString(R.string.hotel_detail)
                    isShow = false
                }
            }
        })
    }
}