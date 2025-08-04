package com.example.quizapp 

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.quizapp.ui.QuestionActivity

class MainActivity : AppCompatActivity() {
    private lateinit var startButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.StartButton)

        startButton.setOnClickListener {
            Intent(this@MainActivity, QuestionActivity::class.java).also {
                startActivity(it)
            }
            finish()
        }

    }
}