package com.example.genredome

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //finds the bottom nav bar and stores it in a val
        val bottomNavbar = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        //highlights the currently selected screen which is profile here
        bottomNavbar.selectedItemId = R.id.nav_profile

        //on item select
        bottomNavbar.setOnItemSelectedListener { item ->
            //if home is selected it navigates to the home page
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }

                //if instructions is selected it navigates to the instructions page
                R.id.nav_instructions -> {
                    startActivity(Intent(this, instructionActivity::class.java))
                    true
                }

                //if the user makes the same selection do nothing
                else -> false
            }
        }

        //finds relevant items by ID and stores it in a val
        val usernameTextView = findViewById<TextView>(R.id.usernameTextView)
        val emailTextView = findViewById<TextView>(R.id.emailTextView)

        //loading data
        val userInfo = getSharedPreferences("UserPrefernce", Context.MODE_PRIVATE)
        val name = userInfo.getString("USER_NAME", "-")
        val email = userInfo.getString("USER_EMAIL", "-")

        //displays the data
        usernameTextView.text = "Username: $name"
        emailTextView.text = "Email: $email"



    }
}