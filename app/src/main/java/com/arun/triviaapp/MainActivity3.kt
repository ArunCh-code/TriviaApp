package com.arun.triviaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.arun.triviaapp.room.Answers

class MainActivity3 : AppCompatActivity() {

    lateinit var btnNext: Button
    lateinit var selectedColours: StringBuilder
    lateinit var answer: Answers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        /* Initilise CheckBoxes */
        var cbGreen: CheckBox = findViewById(R.id.cbGreen);
        var cbWhite: CheckBox = findViewById(R.id.cbWhite);
        var cbYellow: CheckBox = findViewById(R.id.cbYellow);
        var cbOrange: CheckBox = findViewById(R.id.cbOrange);

        /* Get model class from bundle */
        val bundle: Bundle? = intent.getBundleExtra("bundle")
        answer = bundle?.getSerializable("answers") as Answers

        btnNext = findViewById(R.id.btnNext)

        /* Handle click action */
        btnNext.setOnClickListener(View.OnClickListener { view ->
            /* Manage selected cours in StringBuilder */
            if (cbWhite.isChecked) {
                if (this::selectedColours.isInitialized) {
                    selectedColours.append(",White")
                } else {
                    selectedColours = StringBuilder()
                    selectedColours.append("White")
                }
            }

            if (cbGreen.isChecked) {
                if (this::selectedColours.isInitialized) {
                    selectedColours.append(",Green")
                } else {
                    selectedColours = StringBuilder()
                    selectedColours.append("Green")
                }
            }

            if (cbOrange.isChecked) {
                if (this::selectedColours.isInitialized) {
                    selectedColours.append(",Orange")
                } else {
                    selectedColours = StringBuilder()
                    selectedColours.append("Orange")
                }
            }

            if (cbYellow.isChecked) {
                if (this::selectedColours.isInitialized) {
                    selectedColours.append(",Yellow")
                } else {
                    selectedColours = StringBuilder()
                    selectedColours.append("Yellow")
                }
            }

            if (!this::selectedColours.isInitialized) {
                Toast.makeText(this, "Please select a colour.", Toast.LENGTH_SHORT).show()
            } else {
                answer.colurs = selectedColours.toString();
                val bundle: Bundle = Bundle();
                bundle.putSerializable("answers", answer);
                val activity3 = Intent(this, SummaryActivity::class.java)
                activity3.putExtra("bundle", bundle)
                startActivity(activity3)
            }
        })
    }
}