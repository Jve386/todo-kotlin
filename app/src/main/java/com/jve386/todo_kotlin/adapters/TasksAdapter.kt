package com.jve386.todo_kotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jve386.todo_kotlin.R
import com.jve386.todo_kotlin.model.Task

// Adapter for the RecyclerView to display a list of tasks
class TasksAdapter(var tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) :
    RecyclerView.Adapter<TasksViewHolder>() {

    // Create a new ViewHolder instance
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TasksViewHolder(view)
    }

    // Bind data to the ViewHolder at the specified position
    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasks[position])

        // Set a click listener to handle task selection
        holder.itemView.setOnClickListener { onTaskSelected(position) }
    }

    // Return the total number of items in the data set
    override fun getItemCount() = tasks.size
}