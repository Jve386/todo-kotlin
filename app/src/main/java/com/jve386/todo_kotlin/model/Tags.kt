package com.jve386.todo_kotlin.model

// Sealed class representing different task tags
sealed class Tags(var isSelected: Boolean = true) {
    // Object instances for specific tags with default selection state

    // Personal tag
    object Personal : Tags()

    // Work tag
    object Work : Tags()

    // Shopping tag
    object Shopping : Tags()
}
