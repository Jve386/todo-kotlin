package com.jve386.todo_kotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jve386.todo_kotlin.R
import com.jve386.todo_kotlin.model.Tags

// Adapter for the Tags RecyclerView
class TagsAdapter(private val tags: List<Tags>, private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<TagsViewHolder>() {

    // Create a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task_tags, parent, false)
        return TagsViewHolder(view)
    }

    // Get the number of items in the RecyclerView
    override fun getItemCount() = tags.size

    // Bind data to the ViewHolder at the specified position
    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) {
        holder.render(tags[position], onItemSelected)
    }
}
