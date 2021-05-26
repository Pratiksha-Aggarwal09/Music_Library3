package com.example.music_library

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), OnButtonClickListener, OnCategoryClickListener {
    //val itemList: MutableList<Item> = ArrayList()
    lateinit var rvItem: RecyclerView
    val categories = mutableListOf<CategoryTypes>(
        CategoryTypes("Music", R.drawable.music),
        CategoryTypes("Entertainment", R.drawable.music),
        CategoryTypes("Fashion", R.drawable.music),
        CategoryTypes("Technology", R.drawable.music),
        CategoryTypes("Health", R.drawable.music),
        CategoryTypes("Motivation", R.drawable.music),
        CategoryTypes("Fitness", R.drawable.music)
    )

    val songs = ArrayList<SubItem>(7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvItem = findViewById(R.id.mainlist)
        // val rvItem1 : RecyclerView= findViewById(R.id.categoryimage)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        //val layoutManager1= GridLayoutManager(this@MainActivity,4)
        val itemAdapter = Song_categoryitemsAdapter(buildItemList(), this, this)
        /* val itemAdapter1 = CategoryTypesAdapter(categoryItemList(), onCategoryClickListener = this, onCategoryButtonClickListener =this)
         rvItem1.setAdapter(itemAdapter1)
         rvItem1.setLayoutManager(layoutManager1)*/
        rvItem.adapter = itemAdapter
        rvItem.layoutManager = layoutManager


    }

    private fun categoryItemList(): List<CategoryTypes> {
        val itemList = ArrayList<CategoryTypes>()
        for (i in 0..6) {
            val item = CategoryTypes(categories[i].subItemTitle, categories[i].subItemImage)
            itemList.add(item)
        }
        return itemList
    }

    private fun buildItemList(): List<Item> {
        val itemList = ArrayList<Item>()
        for (i in 0..7) {
            if (i == 0) {
                val item = Item("Categories", categoryItemList())
                itemList.add(item)
            } else {
                val item = Item(categories[i - 1].subItemTitle, buildSubItemList())
                itemList.add(item)
            }

            Log.i("buildItemList", itemList.get(i).itemTitle + " || " + itemList.get(i).subItemList)
        }

        return itemList
    }

    private fun buildSubItemList(): List<SubItem> {
        val subItemList = ArrayList<SubItem>(7)
        for (i in 0..4) {
            val subItem = SubItem("Sub Item " + i, "Description " + i, R.drawable.cartoon)
            subItemList.add(subItem)
        }
        return subItemList
    }


    override fun onButtonClicked(position: Int, item: Item) {
        if (position == 0) {
            val intent = Intent(this, AllCategories::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, SeeAll::class.java)
            startActivity(intent)
        }
    }

    /*override fun onCategoryImageClicked(position: Int) {
        rvItem.smoothScrollToPosition(position+1)
    }*/

    override fun onCategoryClicked(position: Int) {
        Log.i("onCategoryClicked", "position = $position")
        rvItem.smoothScrollToPosition(position + 1)
    }


}
