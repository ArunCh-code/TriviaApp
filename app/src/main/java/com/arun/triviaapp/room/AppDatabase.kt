package com.arun.triviaapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Answers::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun answersDAO(): AnswersDAO

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDbInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "GameDB"
                ).build()
            }
            return INSTANCE
        }
    }
}
