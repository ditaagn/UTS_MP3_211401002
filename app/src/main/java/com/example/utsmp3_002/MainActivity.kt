package com.example.utsmp3_002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHealth: RecyclerView
    private val list = ArrayList<Health>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvHealth = findViewById(R.id.rv_health)

        list.addAll(getListHealth())
        showRecyclerList()
    }

    private fun getListHealth(): ArrayList<Health> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataImage = resources.obtainTypedArray(R.array.data_img)
        val listCategory = ArrayList<Health>()
        for (i in dataName.indices) {
            val category = Health(dataImage.getResourceId(i, -1), dataName[i])
            listCategory.add(category)
        }

        return listCategory
    }

    private fun showRecyclerList() {
        rvHealth.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listCategoryAdapter = ListHealthAdapter(list)
        rvHealth.adapter = listCategoryAdapter
    }
}