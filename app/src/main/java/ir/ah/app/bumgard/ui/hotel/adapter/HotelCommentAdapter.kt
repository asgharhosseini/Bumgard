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


class HotelCommentAdapter @Inject constructor(private val glide: RequestManager) :
    BaseAdapter<Comment, HotelCommentAdapter.HotelCommentViewHolder>() {


    inner class HotelCommentViewHolder(private val binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comment: Comment) {
            binding.apply {
                glide.load(comment.userProfile).into(binding.imageView)
                binding.title.text=comment.username
                binding.text.text=comment.comment
            }
        }


    }

    override fun getItemId(position: Int): Long = position.toLong()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelCommentViewHolder {
        val binding =
            ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HotelCommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelCommentViewHolder, position: Int) {
        val currentItem = getItem(position)
            holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { click ->
                click(currentItem)
            }
        }
    }


}