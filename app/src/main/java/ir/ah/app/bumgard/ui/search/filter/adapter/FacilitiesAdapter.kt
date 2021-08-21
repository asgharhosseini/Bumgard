package ir.ah.app.bumgard.ui.search.filter.adapter


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


class FacilitiesAdapter :
    BaseAdapter<Facilities, FacilitiesAdapter.FacilitiesViewHolder>() {
    init {
        setHasStableIds(true)
    }
    var tracker: SelectionTracker<String>? = null
    inner class FacilitiesViewHolder(private val binding: ItemFacilitiesBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(facilities: Facilities, selected: Boolean) {
            binding.apply {
                title.text = facilities.name
                imageView.setImageResource(facilities.image)
                if (selected){
                    parent.setBackgroundResource(R.drawable.background_facilities_selected_color)

                }else{
                    parent.setBackgroundResource(R.drawable.background_facilities_deselected_color)
                }

            }
        }

        fun getItemDetails(): ItemDetailsLookup.ItemDetails<String> =
            object : ItemDetailsLookup.ItemDetails<String>() {
                override fun getPosition(): Int = adapterPosition
                override fun getSelectionKey(): String? = getItem(position).name
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
        //holder.bind(currentItem, it.isSelected(position.toLong()))

        tracker?.let {
            holder.bind(currentItem, it.isSelected(currentItem.name))
        }
    }



}