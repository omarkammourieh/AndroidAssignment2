package com.example.loginactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(
    private val items: MutableList<String>,
    private val onItemClick: (String) -> Unit,
    private val onRemoveClick: (Int) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    // ViewHolder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
        val removeButton: Button = itemView.findViewById(R.id.removeButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemNameTextView.text = item

        // Handle item click
        holder.itemNameTextView.setOnClickListener {
            onItemClick(item)
        }

        // Handle remove button click
        holder.removeButton.setOnClickListener {
            onRemoveClick(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
