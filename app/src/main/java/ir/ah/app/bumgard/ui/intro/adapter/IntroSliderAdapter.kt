package ir.ah.app.bumgard.ui.intro.adapter

import android.view.*
import androidx.recyclerview.widget.*
import ir.ah.app.bumgard.*
import ir.ah.app.bumgard.databinding.*


class IntroSliderAdapter : RecyclerView.Adapter<IntroSliderAdapter.PagerVH>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(
            ItemPageIntroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    //get the size of color array
    override fun getItemCount(): Int = 3

    //binding the screen with view
    override fun onBindViewHolder(holder: PagerVH, position: Int) {

        holder.bind(position)
    }


    inner class PagerVH(private val binding :ItemPageIntroBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
            if (position == 0) {
                binding.ivImage.setImageResource(R.drawable.ic_image1)
            }
            if (position == 1) {
                binding.ivImage.setImageResource(R.drawable.ic_image2)
            }
            if (position == 2) {
                binding.ivImage.setImageResource(R.drawable.ic_image3)
            }
        }
    }

}