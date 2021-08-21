package ir.ah.app.bumgard.ui.search.filter.adapter

import android.view.*
import androidx.recyclerview.widget.*
import com.bumptech.glide.*
import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.ui.search.adapter.*
import javax.inject.*

class FacilitiesAdapter @Inject constructor(private val glide: RequestManager) :
    BaseAdapter<Facilities, FacilitiesAdapter.FacilitiesViewHolder>() {

    inner class FacilitiesViewHolder(private val binding: ItemFacilitiesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(facilities: Facilities) {
            binding.apply {
                title.text=facilities.name
                imageView.setImageResource(facilities.image)

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):FacilitiesViewHolder {
        val binding = ItemFacilitiesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FacilitiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FacilitiesViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }


}