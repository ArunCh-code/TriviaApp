package com.arun.triviaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.arun.triviaapp.room.Answers

class MainActivity2 : AppCompatActivity() {

    lateinit var btnNext: Button
    lateinit var radioGroup: RadioGroup
    lateinit var selectedPlayer: String
    lateinit var answer: Answers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        /* Get model class from bundle */
        val bundle: Bundle? = intent.getBundleExtra("bundle")
        answer = bundle?.getSerializable("answers") as Answers

        btnNext = findViewById(R.id.btnNext)
        radioGroup = findViewById(R.id.rgRadioGroup)

        /* Set selected player using RadioGroup */
        radioGroup.setOnCheckedChangeListener({ group, checkedId ->
            if (checkedId != -1) {
                selectedPlayer = (findViewById<View>(checkedId) as RadioButton).getText().toString()
            }
        })

        /* Handle click action */
        btnNext.setOnClickListener(View.OnClickListener { view ->

            if (!this::selectedPlayer.isInitialized) {
                Toast.makeText(this, "Please select a player.", Toast.LENGTH_SHORT).show()
            } else {
                answer.player = selectedPlayer;
                val bundle: Bundle = Bundle();
                bundle.putSerializable("answers", answer);
                val activity3 = Intent(this, MainActivity3::class.java)
                activity3.putExtra("bundle", bundle)
                startActivity(activity3)
            }
        })
    }
}