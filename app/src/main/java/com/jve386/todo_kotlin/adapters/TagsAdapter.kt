package com.jve386.todo_kotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jve386.todo_kotlin.R
import com.jve386.todo_kotlin.models.Tasks

class TagsAdapter(private val categories: List<Tasks>) :
    RecyclerView.Adapter<TagsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_task_tags, parent, false)
        return TagsViewHolder(view)
    }

    override fun getItemCount() = categories.size


    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) {
        holder.render(categories[position])
    }
}