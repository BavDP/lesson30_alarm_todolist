package com.example.viewpager.mvvm.todoList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewpager.models.todoList.TodoTask
import com.example.viewpager.models.todoList.TodoTaskState
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
import kotlinx.coroutines.launch

class TodoListViewModel(private var repository: TodoListRepository = TodoListRepository()): ViewModel() {
    val todoListLiveData = MutableLiveData<List<TodoTask>>()
    var activeTodoState: TodoTaskState = TodoTaskState.NONE
        set(value) {
            field = value
            viewModelScope.launch {
                todoListLiveData.value = repository.loadTodoListTasksByStatus(value)
            }
        }
}