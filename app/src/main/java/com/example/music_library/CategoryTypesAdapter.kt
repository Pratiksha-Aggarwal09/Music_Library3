package com.example.music_library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class CategoryTypesAdapter internal constructor(private val Category: List<CategoryTypes>, val onCategoryClickListener: OnCategoryClickListener?, val onCategoryImageClickListener: OnCategoryImageClickListener?) :
        RecyclerView.Adapter<CategoryTypesAdapter.CategoryTypeViewHolder>() {

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): CategoryTypeViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.categorytypes, viewGroup, false)
        return CategoryTypeViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull subItemViewHolder: CategoryTypeViewHolder, i: Int) {
        val category = Category[i]
        subItemViewHolder.tvSubItemTitle.setText(category.subItemTitle)
        subItemViewHolder.isubItemImage.setImageResource(category.subItemImage)

        subItemViewHolder.bind(i,onCategoryClickListener)
        //.bind1(i,onCategoryImageClickListener)

        /*val button2=subItemViewHolder.see1
         subItemViewHolder.bind1(category)*/




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

        fun bind1(position: Int, clickListener: OnCategoryImageClickListener?)
        {


            isubItemImage.setOnClickListener {
                clickListener?.onCategoryImageClicked(position)
            }
        }




    }
}
