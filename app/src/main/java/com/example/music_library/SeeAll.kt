package com.example.music_library

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class SeeAll : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seeall)
        //var list1= ArrayList<SubItem>()
        //val filelist = intent.getSerializableExtra("List")


        val rvItem : RecyclerView= findViewById(R.id.itemslist)
        val layoutManager = LinearLayoutManager(this)
        val itemAdapter = SeeAllAdapter(buildSubItemList())
        rvItem.setAdapter(itemAdapter)
        rvItem.setLayoutManager(layoutManager)

    }


    private fun buildSubItemList():List<SubItem> {
        val subItemList = ArrayList<SubItem>()
        for (i in 0..7)
        {
            val subItem = SubItem("Sub Item " + i, "Description " + i,R.drawable.cartoon)
            subItemList.add(subItem)
        }
        // return fileList() as ArrayList<SubItem>
        return  subItemList
    }
}