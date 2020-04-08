package com.yonggeun.star.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class ColleagueViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ColleagueRepository

    val allData: LiveData<List<Colleague>>

    init {
        val colleagueDAO = ColleagueDatabase.getInstance(
            application
        )!!.colleagueDAO()
        repository = ColleagueRepository(colleagueDAO)
        allData = repository.data
    }

    fun insert(colleague: Colleague) = viewModelScope.launch {
        thread {
            repository.insert(colleague)
        }
    }

    fun update(colleague: Colleague) = viewModelScope.launch {
        thread {
            repository.update(colleague)
        }
    }

    fun delete(colleague: Colleague) = viewModelScope.launch {
        thread {
            repository.delete(colleague)
        }
    }

}