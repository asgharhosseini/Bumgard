package ir.ah.app.bumgard.ui.search.adapter
import android.view.*
import androidx.recyclerview.widget.*
import com.bumptech.glide.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.databinding.*
import kotlinx.coroutines.flow.*
import javax.inject.*

class TopCityAdapter @Inject constructor(private val glide: RequestManager) :
    BaseAdapter<City, TopCityAdapter.TopCityViewHolder>() {

    inner class TopCityViewHolder(private val binding: ItemTopBinding) :
        RecyclerView.ViewHolder(binding.root) {

         fun bind(city: City) {
            binding.apply {
                glide.load(city.image).into(imgItemTop)
                txtItemTopTitle.text=city.name
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopCityViewHolder {
        val binding = ItemTopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopCityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopCityViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { click ->
                click(currentItem)
            }
        }

    }


}