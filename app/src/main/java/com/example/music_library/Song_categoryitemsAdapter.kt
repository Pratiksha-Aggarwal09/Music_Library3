package com.example.music_library

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/*class Song_categoryitemsAdapter internal constructor(private val itemList: List<Item>) :
    RecyclerView.Adapter<Song_categoryitemsAdapter.ItemViewHolder?>() {
    private val viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): ItemViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.song_categoryitems, viewGroup, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull itemViewHolder: ItemViewHolder, i: Int) {
        val item = itemList[i]
        itemViewHolder.tvItemTitle.setText(item.itemTitle)

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

    inner class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val tvItemTitle: TextView
        val rvSubItem: RecyclerView

        init {
            tvItemTitle = itemView.findViewById(R.id.categorytitle)
            rvSubItem = itemView.findViewById(R.id.itemslist)
        }
    }
}*/

class Song_categoryitemsAdapter internal constructor(
    private val itemList: List<Item>,
    val onButtonClickListener: OnButtonClickListener,
    val onCategoryClickListener: OnCategoryClickListener
) : RecyclerView.Adapter<Song_categoryitemsAdapter.ItemViewHolder>() {


    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.song_categoryitems, viewGroup, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, i: Int) {
        val item = itemList[i]
        //val button1 = itemViewHolder.see
        itemViewHolder.bind(i, item, onButtonClickListener)

        if (i == 0) {
            Log.i("onBindViewHolder1", "i= " + i + " || item = " + item.itemTitle)
            itemViewHolder.categoryTitle.text = item.itemTitle
            /*val button1 = itemViewHolder.see
            itemViewHolder.bind(i, item, onButtonClickListener)*/


            // Create layout manager with initial prefetch item count
            val layoutManager = GridLayoutManager(
                itemViewHolder.rvSubItem.context,
                4
            )
            // layoutManager.initialPrefetchItemCount = item.subItemList.size

            // Create sub item view adapter
            val subItemAdapter = CategoryTypesAdapter(
                item.subItemList as List<CategoryTypes>,
                onCategoryClickListener = onCategoryClickListener
            )
            itemViewHolder.rvSubItem.layoutManager = layoutManager
            itemViewHolder.rvSubItem.adapter = subItemAdapter
            //itemViewHolder.rvSubItem.setRecycledViewPool(viewPool)

            Log.i(
                "onBindViewHolder4",
                "i= " + i + " || item = " + item.itemTitle + " || " + item.subItemList
            )
        } else {
            Log.i("onBindViewHolder2", "i= " + i + " || item = " + item.itemTitle)
            //val item = itemList[i]
            itemViewHolder.categoryTitle.text = item.itemTitle
            /*val button1 = itemViewHolder.see
            itemViewHolder.bind(i, item, onButtonClickListener)*/


            // Create layout manager with initial prefetch item count
            val layoutManager = LinearLayoutManager(
                itemViewHolder.rvSubItem.context,
                LinearLayoutManager.VERTICAL,
                false
            )
            // layoutManager.initialPrefetchItemCount = item.subItemList.size

            // Create sub item view adapter
            val subItemAdapter = SubitemAdapter(item.subItemList as List<SubItem>)
            itemViewHolder.rvSubItem.layoutManager = layoutManager
            itemViewHolder.rvSubItem.adapter = subItemAdapter
            itemViewHolder.rvSubItem.setRecycledViewPool(viewPool)

            Log.i(
                "onBindViewHolder3",
                "i= " + i + " || item = " + item.itemTitle + " || " + item.subItemList
            )
        }
    }


    override fun getItemCount(): Int {
        return itemList.size
    }


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTitle: TextView
        val rvSubItem: RecyclerView
        val see = itemView.findViewById<Button>(R.id.seeall)


        init {
            categoryTitle = itemView.findViewById(R.id.categorytitle)
            rvSubItem = itemView.findViewById(R.id.itemslist)

        }

        fun bind(position: Int, user: Item, clickListener: OnButtonClickListener) {


            see.setOnClickListener {
                clickListener.onButtonClicked(position, user)
            }
        }


    }


}

