package com.jve386.todo_kotlin.adapters

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jve386.todo_kotlin.R
import com.jve386.todo_kotlin.models.Tags
import com.jve386.todo_kotlin.models.Task
import androidx.appcompat.widget.AppCompatCheckBox


class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvTask: TextView = view.findViewById(R.id.tvTask)
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask)

    init {
        // Set up the checkbox listener
        cbTask.setOnCheckedChangeListener { _, isChecked ->
            handleCheckboxChange(isChecked)
        }

        // Set up the text view listener
        tvTask.setOnClickListener {
            // Toggle the checkbox state on text click
            cbTask.isChecked = !cbTask.isChecked
        }
    }

    // Render the task
    fun render(task: Task) {
        // Set initial checkbox state
        cbTask.isChecked = task.isSelected

        // Set the text of the TextView
        tvTask.text = task.name

        // Apply strike-through effect based on the checkbox state
        handleCheckboxChange(task.isSelected)

        // Set the checkbox color based on the category
        val color = when (task.category) {
            Tags.Work -> R.color.todo_business_category
            Tags.Shopping -> R.color.todo_other_category
            Tags.Personal -> R.color.todo_personal_category
        }

        // Set the checkbox color
        cbTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTask.context, color)
        )

    }

    // Apply strike-through effect based on the checkbox state
    private fun handleCheckboxChange(isChecked: Boolean) {
        if (isChecked) {
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}