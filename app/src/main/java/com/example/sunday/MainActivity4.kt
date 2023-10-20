package com.example.sunday

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val registerButton: View = findViewById(R.id.registerButton)
        registerButton.setOnClickListener {
            if (validateFields()) {
                // All fields are filled, proceed to the next activity (MainActivity5)
                moveToNextActivity()
            } else {
                // Notify the user that some fields are empty
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateFields(): Boolean {
        // Validate if all the fields are filled. Customize this based on your needs.
        return isFieldFilled(R.id.button1) &&
                isFieldFilled(R.id.button2) &&
                isFieldFilled(R.id.button3) &&
                isFieldFilled(R.id.button4) &&
                isFieldFilled(R.id.button5) &&
                isFieldFilled(R.id.button6)
    }

    private fun isFieldFilled(editTextId: Int): Boolean {
        val editText: View = findViewById(editTextId)
        if (editText is TextInputEditText) {
            return editText.text?.toString()?.isNotBlank() == true
        }
        return false
    }

    private fun moveToNextActivity() {
        // Retrieve data from TextInputEditText fields
        val name = findViewById<TextInputEditText>(R.id.button1).text.toString()
        val dob = findViewById<TextInputEditText>(R.id.button2).text.toString()
        val designation = findViewById<TextInputEditText>(R.id.button3).text.toString()
        val collegeName = findViewById<TextInputEditText>(R.id.button4).text.toString()
        val district = findViewById<TextInputEditText>(R.id.button5).text.toString()
        val phoneNumber = findViewById<TextInputEditText>(R.id.button6).text.toString()

        // Create an intent and pass data to MainActivity5
        val intent = Intent(this, MainActivity5::class.java).apply {
            putExtra("name", name)
            putExtra("dob", dob)
            putExtra("designation", designation)
            putExtra("collegeName", collegeName)
            putExtra("district", district)
            putExtra("phoneNumber", phoneNumber)
        }

        startActivity(intent)
    }
}











