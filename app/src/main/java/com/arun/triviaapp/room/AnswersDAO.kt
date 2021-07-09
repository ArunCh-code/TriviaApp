package com.arun.triviaapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnswersDAO {

    @Insert
    suspend fun saveAnswer(answer : Answers)

    @Query ("Select * from Answers")
    fun getHistory() : LiveData<List<Answers>>
}