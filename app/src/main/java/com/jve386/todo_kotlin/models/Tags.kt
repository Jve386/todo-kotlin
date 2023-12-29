package com.jve386.todo_kotlin.models

sealed class Tags {
    object Personal : Tags()
    object Work : Tags()
    object Shopping : Tags()
}
