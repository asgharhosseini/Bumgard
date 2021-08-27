package ir.ah.app.bumgard.ui.hotel.adapter


import android.annotation.*
import android.graphics.*
import android.graphics.drawable.*
import android.view.*
import androidx.recyclerview.selection.*
import androidx.recyclerview.widget.*
import ir.ah.app.bumgard.*
import ir.ah.app.bumgard.R

import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.ui.search.adapter.*
import java.util.ArrayList


class HotelFacilitiesAdapter :
    BaseAdapter<Facilities, HotelFacilitiesAdapter.FacilitiesViewHolder>() {


    inner class FacilitiesViewHolder(private val binding: ItemFacilitiesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(facilities: Facilities) {
            binding.apply {
                title.text = facilities.name
                imageView.setImageResource(facilities.image)
                parent.setBackgroundResource(R.drawable.background_facilities_deselected_color)
                title.setTextColor(Color.parseColor("#9C9C9C"))
                imageView.setColorFilter(Color.parseColor("#9C9C9C"))
            }
        }


    }

    override fun getItemId(position: Int): Long = position.toLong()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacilitiesViewHolder {
        val binding =
            ItemFacilitiesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FacilitiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FacilitiesViewHolder, position: Int) {
        val currentItem = getItem(position)
            holder.bind(currentItem)
            holder.itemView.setOnClickListener {
            onItemClickListener?.let { click ->
                click(currentItem)
            }
        }
    }


}