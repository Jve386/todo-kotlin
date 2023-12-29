package com.jve386.todo_kotlin.adapters

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jve386.todo_kotlin.R
import com.jve386.todo_kotlin.models.Tags

class TagsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvTagsName: TextView = view.findViewById(R.id.tvTagsName)
    private val divider: View = view.findViewById(R.id.divider)
    fun render(tags: Tags) {

        when (tags) {
            Tags.Personal -> {
                tvTagsName.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_personal_category)
                )
            }

            Tags.Shopping -> {
                tvTagsName.text = "Shopping"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_other_category)
                )
            }

            Tags.Work -> {
                tvTagsName.text = "Work"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_business_category)
                )
            }
        }
    }
}