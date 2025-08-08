package com.example.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.quizapp.R
import com.example.quizapp.utils.Constants

class FinalActivity : AppCompatActivity() {
    private lateinit var textViewName: TextView
    private lateinit var scoreTextView: TextView
    private lateinit var finishButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)


        textViewName = findViewById(R.id.textView4)
        scoreTextView = findViewById(R.id.textView5)
        finishButton = findViewById(R.id.finishButton)

        val name = intent.getStringExtra(Constants.USERNAME)
        val score = intent.getIntExtra(Constants.SCORE, 0)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        scoreTextView.text = "Your score out of $totalQuestions is $score"
        textViewName.text = intent!!.getStringExtra(Constants.USERNAME).toString()
        textViewName.text = name.toString()
        finishButton.setOnClickListener {
            finish()
        }
    }
}