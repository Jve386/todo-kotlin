package com.jve386.todo_kotlin.adapters

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jve386.todo_kotlin.R
import com.jve386.todo_kotlin.model.Tags

// ViewHolder for the Tags in the RecyclerView
class TagsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // References to UI elements
    private val tvTagsName: TextView = view.findViewById(R.id.tvTagsName)
    private val divider: View = view.findViewById(R.id.divider)
    private val viewContainer: CardView = view.findViewById(R.id.viewContainer)

    // Function to render data to the ViewHolder
    fun render(tags: Tags, onItemSelected: (Int) -> Unit) {

        // Set background color based on the selected state
        val color = if (tags.isSelected) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        viewContainer.setCardBackgroundColor(
            ContextCompat.getColor(viewContainer.context, color)
        )

        // Set click listener to handle item selection
        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        // Customize UI based on the tag type
        when (tags) {
            Tags.Personal -> {
                tvTagsName.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_personal_tag)
                )
            }

            Tags.Shopping -> {
                tvTagsName.text = "Shopping"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_other_tag)
                )
            }

            Tags.Work -> {
                tvTagsName.text = "Work"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context, R.color.todo_business_tag)
                )
            }
        }
    }
}