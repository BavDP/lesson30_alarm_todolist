package com.example.viewpager.mvvm.todoList

import com.example.viewpager.models.todoList.TodoTask
import com.example.viewpager.models.todoList.TodoTaskDB
import com.example.viewpager.models.todoList.TodoTaskState
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.Random
import java.util.concurrent.TimeUnit
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoListRepository() {
    suspend fun loadTodoListTasksByStatus(status: TodoTaskState): List<TodoTask> {
        return withContext(Dispatchers.IO) {
            TodoTaskDB.tasks().filter { task -> task.status == status }
        }
    }
}