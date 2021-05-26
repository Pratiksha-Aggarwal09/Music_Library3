package com.example.music_library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryTypesAdapter internal constructor(private val Category: List<CategoryTypes>, val onCategoryClickListener: OnCategoryClickListener?) :
        RecyclerView.Adapter<CategoryTypesAdapter.CategoryTypeViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CategoryTypeViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.categorytypes, viewGroup, false)
        return CategoryTypeViewHolder(view)
    }

    override fun onBindViewHolder(subitemViewHolder: CategoryTypeViewHolder, i: Int) {
        val category = Category[i]
        subitemViewHolder.tvSubItemTitle.setText(category.subItemTitle)
        subitemViewHolder.isubItemImage.setImageResource(category.subItemImage)

        subitemViewHolder.bind(i,onCategoryClickListener)




    }

    override fun getItemCount(): Int {
        return Category.size
    }

    inner class CategoryTypeViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        var tvSubItemTitle: TextView
        val isubItemImage:ImageView

        init {
            tvSubItemTitle = itemView.findViewById(R.id.tv_category_name)
            isubItemImage=itemView.findViewById(R.id.iv_category_thumb)
        }

        fun bind(position: Int, clickListener: OnCategoryClickListener?)
        {


            itemView.setOnClickListener {
                clickListener?.onCategoryClicked(position)
            }
        }





    }
}

