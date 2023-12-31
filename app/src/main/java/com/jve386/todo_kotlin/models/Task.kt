package com.jve386.todo_kotlin.models

data class Task (val name:String, val category: Tags, var isSelected:Boolean = false)