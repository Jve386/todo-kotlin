package com.jve386.todo_kotlin.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jve386.todo_kotlin.R
import com.jve386.todo_kotlin.models.Tags
import com.jve386.todo_kotlin.models.Task

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTask: TextView = view.findViewById(R.id.tvTask)
    private val cbTask: TextView = view.findViewById(R.id.tvTask)
    fun render(task: Task) {
        tvTask.text = task.name
    }
}