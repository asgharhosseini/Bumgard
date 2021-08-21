package ir.ah.app.bumgard.ui.search.filter.adapter

import android.view.*
import androidx.recyclerview.selection.*
import androidx.recyclerview.widget.*
import ir.ah.app.bumgard.data.model.*

class MyItemDetailsLookup(private val recyclerView: RecyclerView) :
    ItemDetailsLookup<String>() {
    override fun getItemDetails(event: MotionEvent): ItemDetails<String>? {
        val view = recyclerView.findChildViewUnder(event.x, event.y)
        if (view != null) {
            return (recyclerView.getChildViewHolder(view) as FacilitiesAdapter.FacilitiesViewHolder).getItemDetails()
        }
        return null
    }

}