package ir.ah.app.bumgard.ui.hotel.adapter


import android.annotation.*
import android.graphics.*
import android.graphics.drawable.*
import android.view.*
import androidx.recyclerview.selection.*
import androidx.recyclerview.widget.*
import com.bumptech.glide.*
import ir.ah.app.bumgard.*
import ir.ah.app.bumgard.R

import ir.ah.app.bumgard.base.*
import ir.ah.app.bumgard.data.model.*
import ir.ah.app.bumgard.databinding.*
import ir.ah.app.bumgard.ui.search.adapter.*
import java.util.ArrayList
import javax.inject.*


class HotelLanguagesAdapter @Inject constructor(private val glide: RequestManager) :
    BaseAdapter<Languages, HotelLanguagesAdapter.HotelLanguagesViewHolder>() {


    inner class HotelLanguagesViewHolder(private val binding: ItemLanguagesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(languages: Languages) {
            binding.apply {
                glide.load(languages.image).into(binding.imageViewLanguage)
                binding.languageName.text = languages.name

            }
        }


    }

    override fun getItemId(position: Int): Long = position.toLong()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelLanguagesViewHolder {
        val binding =
            ItemLanguagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotelLanguagesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelLanguagesViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { click ->
                click(currentItem)
            }
        }

    }


}