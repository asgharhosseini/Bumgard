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


class HotelPhotosAdapter @Inject constructor(private val glide: RequestManager) :
    BaseAdapter<Photos, HotelPhotosAdapter.PhotosViewHolder>() {


    inner class PhotosViewHolder(private val binding: ItemPhotosBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photos: Photos) {
            binding.apply {
                glide.load(photos.image).into(binding.imageView)

            }
        }


    }

    override fun getItemId(position: Int): Long = position.toLong()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val binding =
            ItemPhotosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { click ->
                click(currentItem)
            }
        }

    }


}