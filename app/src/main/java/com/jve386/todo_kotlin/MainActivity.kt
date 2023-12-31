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
import com.jve386.todo_kotlin.model.Tags
import com.jve386.todo_kotlin.model.Tags.*
import com.jve386.todo_kotlin.model.Task

class MainActivity : ComponentActivity() {

    // List of available tags
    private val tags = listOf(
        Personal,
        Work,
        Shopping
    )

    // List of tasks
    private val tasks = mutableListOf(
        Task("PruebaBusiness", Work),
        Task("PruebaPersonal", Personal),
        Task("PruebaShopping", Shopping)
    )

    // UI components
    private lateinit var rvTags: RecyclerView
    private lateinit var tagsAdapter: TagsAdapter
    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter
    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        // Listener for the "Add Task" button
        fabAddTask.setOnClickListener { showDialog() }
    }

    @SuppressLint("CutPasteId")
    private fun showDialog() {
        // Create and show the dialog for adding a new task
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTaskName)
        val rgTags: RadioGroup = dialog.findViewById(R.id.rgTags)

        btnAddTask.setOnClickListener {
            // Get the details of the new task from the dialog
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgTags.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgTags.findViewById(selectedId)
                val currentTag: Tags = when (selectedRadioButton.text) {
                    getString(R.string.personal) -> Personal
                    getString(R.string.work) -> Work
                    else -> Shopping
                }

                // Add the new task to the list and update the UI
                tasks.add(Task(currentTask, currentTag))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun initComponents() {
        // Initialize UI components
        rvTags = findViewById(R.id.rvTags)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        // Set up the UI for tags and tasks
        tagsAdapter = TagsAdapter(tags) { position -> updateTags(position) }
        rvTags.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvTags.adapter = tagsAdapter

        tasksAdapter = TasksAdapter(tasks) { onItemSelected(it) }
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

    private fun onItemSelected(position: Int) {
        // Toggle the selected state of a task and update the UI
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun updateTags(position: Int) {
        // Toggle the selected state of a tag and update the UI
        tags[position].isSelected = !tags[position].isSelected
        tagsAdapter.notifyItemChanged(position)
        updateTasks()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateTasks() {
        // Filter tasks based on selected tags and update the task list in the adapter
        val selectedTags: List<Tags> = tags.filter { it.isSelected }
        val newTasks = tasks.filter { selectedTags.contains(it.tag) }
        tasksAdapter.tasks = newTasks
        tasksAdapter.notifyDataSetChanged()
    }
}
