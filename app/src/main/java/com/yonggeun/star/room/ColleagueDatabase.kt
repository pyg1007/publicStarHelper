package com.yonggeun.star.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Colleague::class], version = 1, exportSchema = false)
abstract class ColleagueDatabase : RoomDatabase() {
    abstract fun colleagueDAO(): ColleagueDAO

    companion object {
        private var INSTANCE: ColleagueDatabase? = null

        fun getInstance(context: Context): ColleagueDatabase? {
            if (INSTANCE == null) {
                synchronized(ColleagueDatabase::class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ColleagueDatabase::class.java,
                            "Colleague.db"
                        )
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}