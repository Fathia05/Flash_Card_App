package com.example.flashcardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashcardQuestion= findViewById<TextView>(R.id.flashcard_question)
        val flashcardAnswer= findViewById<TextView>(R.id.flashcard_answer)
        flashcardQuestion.setOnClickListener {
            flashcardAnswer.visibility = View.VISIBLE
            flashcardQuestion.visibility = View.INVISIBLE
        }

        flashcardAnswer.setOnClickListener {
            flashcardAnswer.visibility = View.INVISIBLE
            flashcardQuestion.visibility = View.VISIBLE
        }

        val flashcardAnswer1=findViewById<View>(R.id.flashcard_answer1)
        val flashcardAnswer2=findViewById<View>(R.id.flashcard_answer2)
        val flashcardAnswer3=findViewById<View>(R.id.flashcard_answer3)
        flashcardAnswer1.setOnClickListener {
            flashcardAnswer1.setBackgroundColor(getResources().getColor(R.color.my_green_color, null))
        }

        flashcardAnswer2.setOnClickListener {
            flashcardAnswer2.setBackgroundColor(getResources().getColor(R.color.my_red_color, null))
            flashcardAnswer1.setBackgroundColor(getResources().getColor(R.color.my_green_color, null))
        }

        flashcardAnswer3.setOnClickListener {
            flashcardAnswer3.setBackgroundColor(getResources().getColor(R.color.my_red_color, null))
            flashcardAnswer1.setBackgroundColor(getResources().getColor(R.color.my_green_color, null))
        }

    }

}