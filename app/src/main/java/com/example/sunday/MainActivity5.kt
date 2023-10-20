package com.example.sunday

// Import statements
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity5 : AppCompatActivity() {

    // SharedPreferences file name
    private val PREFS_NAME = "UserProfilePrefs"

    // UI elements
    private lateinit var nameEditText: TextInputEditText
    private lateinit var dobEditText: TextInputEditText
    private lateinit var updateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        // Initialize UI elements
        nameEditText = findViewById(R.id.textViewName)
        dobEditText = findViewById(R.id.textViewDOB)
        updateButton = findViewById(R.id.updateButton)

        // Set up the "Update" button click listener
        updateButton.setOnClickListener {
            // Get the updated data
            val newName = nameEditText.text.toString().trim()
            val newDob = dobEditText.text.toString().trim()

            // Update the user data locally
            updateLocalUserProfile(newName, newDob)

            // Show a toast indicating successful update
            Toast.makeText(this, "Profile Updated Successfully", Toast.LENGTH_SHORT).show()
        }

        // Retrieve user data from SharedPreferences and populate UI
        loadUserProfileData()
    }

    private fun loadUserProfileData() {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Retrieve user data from SharedPreferences
        val name = sharedPreferences.getString("name", "")
        val dob = sharedPreferences.getString("dob", "")

        // Populate UI with user data
        nameEditText.setText(name)
        dobEditText.setText(dob)
    }

    private fun updateLocalUserProfile(newName: String, newDob: String) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Update the user data in SharedPreferences
        val editor = sharedPreferences.edit()
        editor.putString("name", newName)
        editor.putString("dob", newDob)
        editor.apply()
    }
}
