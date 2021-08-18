package ir.ah.app.bumgard.ui.search.adapter
import android.view.*
import androidx.recyclerview.widget.*
import com.bumptech.glide.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.databinding.*
import kotlinx.coroutines.flow.*
import javax.inject.*

class PopularCityAdapter @Inject constructor(private val glide: RequestManager) :
    BaseAdapter<City, PopularCityAdapter.PopularCityViewHolder>() {

    inner class PopularCityViewHolder(private val binding: ItemPopularBinding) :
        RecyclerView.ViewHolder(binding.root) {

         fun bind(city: City) {
            binding.apply {
                glide.load(city.image).into(imgItemPopular)
                txtItemPopularTitle.text=city.name
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularCityViewHolder {
        val binding = ItemPopularBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularCityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularCityViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }


}