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
import java.util.ArrayList


class FacilitiesAdapter :
    BaseAdapter<Facilities, FacilitiesAdapter.FacilitiesViewHolder>() {
    init {
        setHasStableIds(true)
    }
   private var selectedList: ArrayList<Facilities> = arrayListOf()
    var tracker: SelectionTracker<String>? = null

    fun getSelectedList():ArrayList<Facilities> {
        return selectedList
    }
    fun clearSelectedList(){
       selectedList =  arrayListOf()
    }

    inner class FacilitiesViewHolder(private val binding: ItemFacilitiesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(facilities: Facilities, selected: Boolean) {
            binding.apply {
                title.text = facilities.name
                imageView.setImageResource(facilities.image)
                if (selected){
                    parent.setBackgroundResource(R.drawable.background_facilities_selected_color)
                    selectedList.add(facilities)
                    title.setTextColor(Color.WHITE)
                    imageView.setColorFilter(Color.WHITE)

                }else{
                    parent.setBackgroundResource(R.drawable.background_facilities_deselected_color)
                    selectedList.remove(facilities)
                    title.setTextColor(Color.parseColor("#9C9C9C"))
                    imageView.setColorFilter(Color.parseColor("#9C9C9C"))
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