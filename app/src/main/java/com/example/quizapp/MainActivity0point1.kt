package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity0point1 : AppCompatActivity() {
    //private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity0point1)

       val button: Button = findViewById(R.id.proceedButton)
        val editText: EditText = findViewById(R.id.name)

        //var nameOfUser = editText.toString()


        button.setOnClickListener {
            if (editText.text.isNotEmpty()){
                Intent(this@MainActivity0point1, MainActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            } else{
                Toast.makeText(this@MainActivity0point1, "please input your name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}