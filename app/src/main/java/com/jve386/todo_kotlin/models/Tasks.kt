package com.jve386.todo_kotlin.models

sealed class Tasks {
    object Personal : Tasks()
    object Work : Tasks()
    object Shopping : Tasks()
}
