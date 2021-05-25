package com.example.music_library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*class SeeAllAdapter internal constructor(private val itemList: List<Item>) : RecyclerView.Adapter<SeeAllAdapter.ItemViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.seeall, viewGroup, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, i: Int) {
        val item = itemList[i]
        itemViewHolder.categoryTitle.text = item.itemTitle

        // Create layout manager with initial prefetch item count
        val layoutManager = LinearLayoutManager(
                itemViewHolder.rvSubItem.context,
                LinearLayoutManager.VERTICAL,
                false
        )
        layoutManager.initialPrefetchItemCount = item.subItemList.size

        // Create sub item view adapter
        val subItemAdapter = SubitemAdapter(item.subItemList)
        itemViewHolder.rvSubItem.layoutManager = layoutManager
        itemViewHolder.rvSubItem.adapter = subItemAdapter
        itemViewHolder.rvSubItem.setRecycledViewPool(viewPool)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTitle: TextView
        val rvSubItem: RecyclerView

        init {
            categoryTitle = itemView.findViewById(R.id.categorytitle)
            rvSubItem = itemView.findViewById(R.id.itemslist)
        }
    }
}*/
class SeeAllAdapter internal constructor(private val subItemList: List<SubItem>) : RecyclerView.Adapter<SeeAllAdapter.SubItemViewHolder?>() {
    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): SubItemViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.subitem, viewGroup, false)
        return SubItemViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull subItemViewHolder: SubItemViewHolder, i: Int) {
        val subItem = subItemList[i]
        subItemViewHolder.tvSubItemTitle.setText(subItem.subItemTitle)
        subItemViewHolder.tvsubItemDesc.setText(subItem.subItemDesc)
        subItemViewHolder.isongimage.setImageResource(subItem.subItemImage)
    }

    override fun getItemCount(): Int {
        return subItemList.size
    }

    inner class SubItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvSubItemTitle: TextView
        var tvsubItemDesc :TextView
        var isongimage: ImageView

        init {
            tvSubItemTitle = itemView.findViewById(R.id.songname)
            tvsubItemDesc = itemView.findViewById(R.id.singer)
            isongimage = itemView.findViewById(R.id.thumbnail)

        }
    }
}