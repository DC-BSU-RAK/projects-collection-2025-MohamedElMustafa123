package com.example.genredome

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //finds the buttons by ID and stores them in vals
        val popGenreButton = findViewById<ImageButton>(R.id.popGenreButton)
        val hiphopGenreButton = findViewById<ImageButton>(R.id.hiphopGenreButton)
        val alternativeGenreButton = findViewById<ImageButton>(R.id.alternativeGenreButton)
        val electronicGenreButton = findViewById<ImageButton>(R.id.electronicGenreButton)
        val rockGenreButton = findViewById<ImageButton>(R.id.rockGenreButton)
        val soulGenreButton = findViewById<ImageButton>(R.id.soulGenreButton)

        //finds the bottom nav bar and stores it in a val
        val bottomNavbar = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        //highlights the currently selected screen which is home here
        bottomNavbar.selectedItemId = R.id.nav_home

        //on item select
        bottomNavbar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                //already on home page
                R.id.nav_home -> true

                //if instructions is selected it navigates to the instructions page
                R.id.nav_instructions -> {
                    startActivity(Intent(this, instructionActivity::class.java))
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


        //Once the user clicks on a genre it takes them to its respective top artists page
        popGenreButton.setOnClickListener {
            val intent = Intent(this,PopArtistsActivity::class.java)
            startActivity(intent)
        }

        hiphopGenreButton.setOnClickListener {
            val intent = Intent(this,HiphopArtisitsActivity::class.java)
            startActivity(intent)
        }

        alternativeGenreButton.setOnClickListener {
            val intent = Intent(this,AlternativeArtistsActivity::class.java)
            startActivity(intent)
        }

        electronicGenreButton.setOnClickListener {
            val intent = Intent(this,ElectronicArtistsActivity::class.java)
            startActivity(intent)
        }

        rockGenreButton.setOnClickListener {
            val intent = Intent(this,RockArtistActivity::class.java)
            startActivity(intent)
        }

        soulGenreButton.setOnClickListener {
            val intent = Intent(this,SoulArtistActivity::class.java)
            startActivity(intent)
        }

    }
}