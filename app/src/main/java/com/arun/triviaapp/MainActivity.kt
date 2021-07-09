package com.arun.triviaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.arun.triviaapp.room.Answers

class MainActivity : AppCompatActivity() {

    lateinit var btnNext: Button
    lateinit var etName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNext = findViewById(R.id.btnNext)
        etName = findViewById(R.id.etName)

        val answers: Answers = Answers()

        /* Handle click action */
        btnNext.setOnClickListener(View.OnClickListener { view ->

            var userName = etName.text.toString()
            if (userName.equals("")) {
                Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show()
            } else {
                answers.name = userName;
                val bundle: Bundle = Bundle();
                bundle.putSerializable("answers", answers);
                val activity2 = Intent(this, MainActivity2::class.java)
                activity2.putExtra("bundle", bundle)
                startActivity(activity2)
            }
        })
    }
}