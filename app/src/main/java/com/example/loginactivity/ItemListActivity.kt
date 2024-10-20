package com.example.loginactivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemListActivity : AppCompatActivity() {

    private lateinit var recyclerViewItems: RecyclerView
    private val items = mutableListOf("Pasta", "Banana", "Lasagna", "Mango", "Kiwi","Tomato", "Sushi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        recyclerViewItems = findViewById(R.id.recyclerViewItems)

        // Set up RecyclerView
        recyclerViewItems.layoutManager = LinearLayoutManager(this)
        val adapter = ItemAdapter(items, this::onItemClick, this::onRemoveClick)
        recyclerViewItems.adapter = adapter
    }

    private fun onItemClick(item: String) {
        Toast.makeText(this, "Clicked on: $item", Toast.LENGTH_SHORT).show()
    }

    private fun onRemoveClick(position: Int) {
        items.removeAt(position)
        recyclerViewItems.adapter?.notifyItemRemoved(position)
    }
}
