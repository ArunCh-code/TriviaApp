package com.arun.triviaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arun.triviaapp.adapters.CustomAdapter
import com.arun.triviaapp.room.Answers
import com.arun.triviaapp.room.AppDatabase

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val rvHistory : RecyclerView = findViewById(R.id.rvHistory)

        val layoutManager = LinearLayoutManager(applicationContext)
        rvHistory.layoutManager = layoutManager
        rvHistory.itemAnimator = DefaultItemAnimator()

        /* GLiveData obserable to obserbe on history data */
        AppDatabase.getDbInstance(applicationContext)?.answersDAO()?.getHistory()?.observe(this,{
            val customAdapter = CustomAdapter(it)
            rvHistory.adapter=customAdapter
            customAdapter.notifyDataSetChanged()
        })
    }
}