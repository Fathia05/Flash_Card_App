package com.example.flashcardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

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
        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            val data: Intent? = result.data
            if (data != null) {
                val string1 = data.getStringExtra("string1")
                val string2 = data.getStringExtra("string2")

                // Log the value of the strings for easier debugging
                Log.i("MainActivity", "string1: $string1")
                Log.i("MainActivity", "string2: $string2")
            } else {
                Log.i("MainActivity", "Returned null data from AddCardActivity")
            }

        }

        findViewById<View>(R.id.myAddBtn).setOnClickListener {
            val intent = Intent(this, AddCardActivity::class.java)
            resultLauncher.launch(intent)
        }

    }


}