package com.example.quizapp 

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.quizapp.ui.QuestionActivity
import com.example.quizapp.utils.Constants

class MainActivity : AppCompatActivity() {
    private lateinit var startButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = intent.getStringExtra(Constants.USERNAME)
        //the !! added earlier didn't really do anything.

        startButton = findViewById(R.id.StartButton)

        startButton.setOnClickListener {
            Intent(this@MainActivity, QuestionActivity::class.java).also {
                it.putExtra(Constants.USERNAME, name)
                startActivity(it)
                finish()
            }

        }

    }
}