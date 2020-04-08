package com.yonggeun.star.room

import androidx.lifecycle.LiveData

class ColleagueRepository(private val colleagueDAO: ColleagueDAO) {

    val data: LiveData<List<Colleague>> = colleagueDAO.getAll()

    fun insert(colleague: Colleague) {
        colleagueDAO.insert(colleague)
    }

    fun update(colleague: Colleague) {
        colleagueDAO.update(colleague)
    }

    fun delete(colleague: Colleague) {
        colleagueDAO.delete(colleague)
    }
}