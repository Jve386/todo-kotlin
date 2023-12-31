package com.jve386.todo_kotlin

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
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

    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initcomponents()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    @SuppressLint("CutPasteId")
    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTaskName)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: Tags = when (selectedRadioButton.text) {
                    getString(R.string.personal) -> Personal
                    getString(R.string.work) -> Work
                    else -> Shopping
                }

                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun initcomponents() {
        rvTags = findViewById(R.id.rvTags)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        tagsAdapter = TagsAdapter(categories)
        rvTags.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTags.adapter = tagsAdapter

        tasksAdapter = TasksAdapter(tasks) {onItemSelected(it)}
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

    private fun onItemSelected(position:Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun updateTasks() {
        tasksAdapter.notifyDataSetChanged()
    }
}
