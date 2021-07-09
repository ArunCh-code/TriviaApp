package com.arun.triviaapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.arun.triviaapp.room.Answers
import com.arun.triviaapp.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.*

class SummaryActivity : AppCompatActivity() {

    lateinit var answer: Answers
    lateinit var btnFinish: Button
    lateinit var btnHistory: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        /* Get model class from bundle */
        val bundle: Bundle? = intent.getBundleExtra("bundle")
        answer = bundle?.getSerializable("answers") as Answers

        val tvName: TextView = findViewById(R.id.tvName);
        val tvAns1: TextView = findViewById(R.id.tvAns1);
        val tvAns2: TextView = findViewById(R.id.tvAns2);

        /* Set values to textviews */
        tvName.setText("Hello " + answer.name)
        tvAns1.setText(answer.player)
        tvAns2.setText(answer.colurs)

        /* Set date and time to Answers data */
        val date = Date()
        answer.date=DateFormat.getDateTimeInstance().format(date)

        btnFinish = findViewById(R.id.btnFinish)
        btnHistory = findViewById(R.id.btnHistory)

        /* Coroutine call call to save Answer data to Room database */
        GlobalScope.launch(Dispatchers.Main) {
            AppDatabase.getDbInstance(applicationContext)?.answersDAO()?.saveAnswer(answer)
        }

        /* Handle click action */
        btnFinish.setOnClickListener(View.OnClickListener { view ->

            val home = Intent(this, MainActivity::class.java)
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(home)
            finish();
        })

        /* Handle click action */
        btnHistory.setOnClickListener(View.OnClickListener { view ->

            val historyActivity = Intent(this, HistoryActivity::class.java)
            startActivity(historyActivity)
        })
    }
}