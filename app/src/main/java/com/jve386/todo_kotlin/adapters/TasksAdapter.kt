package com.jve386.todo_kotlin.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jve386.todo_kotlin.models.Tags

class TasksAdapter (private val tasks:List<Tags>) : RecyclerView.Adapter<TasksViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = tasks.size
}