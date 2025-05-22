package com.example.genredome

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

//INSTRUCTIONS PAGE
class instructionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_instruction)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //finds the bottom nav bar and stores it in a val
        val bottomNavbar = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        //highlights the currently seclected screen which is instructions here
        bottomNavbar.selectedItemId = R.id.nav_instructions

        //on item select
        bottomNavbar.setOnItemSelectedListener { item ->
            //if home is selected it navigates to the home page
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }

                //if profile is selected it navigates to the profile page
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }

                //if the user makes the same selection do nothing
                else -> false
            }
        }
    }
}