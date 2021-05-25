package com.example.music_library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

/*class SubitemAdapter internal constructor(private val subItemList: List<SubItem>) :
    RecyclerView.Adapter<SubitemAdapter.SubItemViewHolder?>() {
    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): SubItemViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.subitem, viewGroup, false)
        return SubItemViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull subItemViewHolder: SubItemViewHolder, i: Int) {
        val subItem = subItemList[i]
        subItemViewHolder.tvSubItemTitle.setText(subItem.subItemTitle)


    }

    override fun getItemCount(): Int {
        return subItemList.size
    }

    inner class SubItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var tvSubItemTitle: TextView

        init {
            tvSubItemTitle = itemView.findViewById(R.id.songname)
        }
    }
}*/

class SubitemAdapter internal constructor(private val subItemList: List<SubItem>) : RecyclerView.Adapter<SubitemAdapter.SubItemViewHolder>() {

    override fun onCreateViewHolder( viewGroup: ViewGroup, i: Int): SubItemViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.subitem, viewGroup, false)
        return SubItemViewHolder(view)
    }

    override fun onBindViewHolder( subItemViewHolder: SubItemViewHolder, i: Int) {
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
         var isongimage:ImageView

        init {
            tvSubItemTitle = itemView.findViewById(R.id.songname)
            tvsubItemDesc = itemView.findViewById(R.id.singer)
            isongimage = itemView.findViewById(R.id.thumbnail)

        }
    }
}


