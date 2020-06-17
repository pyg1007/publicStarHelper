package com.yonggeun.become_star.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ColleagueDAO {

    @Query("SELECT * FROM colleague")
    fun getAll(): LiveData<List<Colleague>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg colleague: Colleague)

    @Update
    fun update(vararg colleague: Colleague)

    @Delete
    fun delete(vararg colleague: Colleague)
}