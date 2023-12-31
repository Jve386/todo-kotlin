package com.jve386.todo_kotlin.model

// Data class representing a task with a name, tag, and selection state
data class Task(val name: String, val tag: Tags, var isSelected: Boolean = false)
