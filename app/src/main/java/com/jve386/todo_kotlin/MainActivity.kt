package com.jve386.todo_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jve386.todo_kotlin.adapters.TagsAdapter
import com.jve386.todo_kotlin.adapters.TasksAdapter
import com.jve386.todo_kotlin.models.Tags
import com.jve386.todo_kotlin.models.Tags.*
import com.jve386.todo_kotlin.models.Task

/* To add in Github's description
tasks-todo-list in kotlin
recycler view
Uso de estilos por contenedor
sealed class
patrón arquitectura: MVVM

 */

class MainActivity : ComponentActivity() {

    private val categories = listOf(
        Personal,
        Work,
        Shopping
    )

    private val tasks = mutableListOf(
        Task("PruebaBusiness", Work),
        Task("PruebaPersonal", Personal),
        Task("PruebaShopping", Shopping)
    )


    private lateinit var rvTags: RecyclerView
    private lateinit var tagsAdapter: TagsAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter
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

        tasksAdapter = TasksAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

    private fun initcomponents() {
        rvTags = findViewById(R.id.rvTags)
        rvTasks = findViewById(R.id.rvTasks)
    }
}
