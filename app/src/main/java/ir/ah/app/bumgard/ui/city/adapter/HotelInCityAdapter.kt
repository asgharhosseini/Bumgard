package ir.ah.app.bumgard.ui.city.adapter
import android.view.*
import androidx.recyclerview.widget.*
import com.bumptech.glide.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.databinding.*
import kotlinx.coroutines.flow.*
import javax.inject.*
import kotlin.random.*

class HotelInCityAdapter @Inject constructor(private val glide: RequestManager) :
    BaseAdapter<Hotel, HotelInCityAdapter.HotelInCityViewHolder>() {

    inner class HotelInCityViewHolder(private val binding: ItemHotelInCityBinding) :
        RecyclerView.ViewHolder(binding.root) {

         fun bind(hotel: Hotel) {
            binding.apply {
                glide.load(hotel.image).into(imgItemSearch)
                txtItemSearchTitle.text=hotel.name
                Space.text="${hotel.spaceToCentrum} km to centrum"
                price.text=hotel.price
                rateReview.text="${hotel.rate} / ${hotel.reviews} reviews "
                materialRatingBar.rating=hotel.rate.toFloat()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):HotelInCityViewHolder {
        val binding = ItemHotelInCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotelInCityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelInCityViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { click ->
                click(currentItem)
            }
        }
    }


}