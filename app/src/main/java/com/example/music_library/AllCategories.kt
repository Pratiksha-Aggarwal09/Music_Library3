package com.example.music_library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AllCategories : AppCompatActivity(),OnCategoryClickListener {
    val categories = mutableListOf<CategoryTypes>(CategoryTypes("Music",R.drawable.music),
            CategoryTypes("Entertainment",R.drawable.music),CategoryTypes("Fashion",R.drawable.music),
            CategoryTypes("Technology",R.drawable.music),
            CategoryTypes("Health",R.drawable.music),
            CategoryTypes("Motivation",R.drawable.music), CategoryTypes("Fitness",R.drawable.music))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categories)
        val rvItem : RecyclerView = findViewById(R.id.categoryimage)
        val layoutManager = GridLayoutManager(this,3)
        val itemAdapter = CategoryTypesAdapter(categoryItemList(), onCategoryClickListener = this)
        rvItem.setAdapter(itemAdapter)
        rvItem.setLayoutManager(layoutManager)
    }
    private fun categoryItemList():List<CategoryTypes> {
        val itemList = ArrayList<CategoryTypes>()
        for (i in 0..6)
        {
            val item = CategoryTypes(categories[i].subItemTitle,categories[i].subItemImage)
            itemList.add(item)
        }
        return itemList
    }

    override fun onCategoryClicked(position: Int) {
        val intent = Intent(this, SeeAll::class.java)
        startActivity(intent)
    }


}