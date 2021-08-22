package ir.ah.app.bumgard.ui.search.filter.adapter

import androidx.recyclerview.selection.*
import ir.ah.app.bumgard.data.model.*

class MyItemKeyProvider(private val adapter: FacilitiesAdapter) : ItemKeyProvider<String>(SCOPE_CACHED)
{
    override fun getKey(position: Int): String? =
        adapter.currentList[position].name

    override fun getPosition(key: String): Int =
        adapter.currentList.indexOfFirst {it.name == key}
    

}