package com.example.flashcardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class AddCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        findViewById<View>(R.id.myCancelBtn).setOnClickListener {
            finish()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.mySaveBtn).setOnClickListener {
            findViewById<EditText>(R.id.question).text.toString()
            findViewById<EditText>(R.id.answer).text.toString()

            val data = Intent() // create a new Intent, this is where we will put our data

            data.putExtra(
                "string1",
                "some string"
            ) // puts one string into the Intent, with the key as 'string1'

            data.putExtra(
                "string2",
                "another string"
            ) // puts another string into the Intent, with the key as 'string2

            setResult(RESULT_OK, data) // set result code and bundle data for response
            val flashcardQuestion= findViewById<TextView>(R.id.question)
            val flashcardAnswer= findViewById<TextView>(R.id.answer)
            flashcardQuestion.setOnClickListener {
                flashcardAnswer.visibility = View.VISIBLE
                flashcardQuestion.visibility = View.INVISIBLE
            }

            flashcardAnswer.setOnClickListener {
                flashcardAnswer.visibility = View.INVISIBLE
                flashcardQuestion.visibility = View.VISIBLE
            }

            finish()
        }

    }
}