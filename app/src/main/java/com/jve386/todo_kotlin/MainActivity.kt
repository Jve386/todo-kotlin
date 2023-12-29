package com.jve386.todo_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jve386.todo_kotlin.adapters.TagsAdapter
import com.jve386.todo_kotlin.models.Tasks
import com.jve386.todo_kotlin.ui.theme.TodokotlinTheme

/* To add in Github's description
tasks-todo-list in kotlin
recycler view
Uso de estilos por contenedor
sealed class

 */

class MainActivity : ComponentActivity() {

    private val categories = listOf(
        Tasks.Personal,
        Tasks.Work,
        Tasks.Shopping
    )

    private lateinit var rvTags: RecyclerView
    private lateinit var tagsAdapter: TagsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initcomponents()
        initUI()
    }

    private fun initUI() {
        tagsAdapter = TagsAdapter(categories)
        rvTags.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTags.adapter = tagsAdapter
    }

    private fun initcomponents() {
        rvTags = findViewById(R.id.rvTags)
    }
}
