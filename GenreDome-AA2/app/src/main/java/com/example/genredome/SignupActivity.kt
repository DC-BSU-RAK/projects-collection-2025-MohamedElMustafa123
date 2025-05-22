package com.example.genredome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //finds input fields by id and stores in val
        val nameInput = findViewById<EditText>(R.id.nameInput)
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        //onclick
        signUpButton.setOnClickListener{
            //converts the entered texts into string and stores it
            val name = nameInput.text.toString()
            val email = emailInput.text.toString()

            //saves the user preference for use in the profile screen
            val userInfo = getSharedPreferences("UserPrefernce", Context.MODE_PRIVATE)
            with(userInfo.edit()){
                putString("USER_NAME", name)
                putString("USER_EMAIL", email)
                apply()
            }

            //displays the home screen after the button is clicked
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}