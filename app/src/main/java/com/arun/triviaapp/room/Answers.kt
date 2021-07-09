package com.arun.triviaapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Answers : Serializable{

    @PrimaryKey(autoGenerate = true)
    var id = 0
    var date : String = ""
    var name : String = ""
    var player : String = ""
    var colurs : String = ""
}