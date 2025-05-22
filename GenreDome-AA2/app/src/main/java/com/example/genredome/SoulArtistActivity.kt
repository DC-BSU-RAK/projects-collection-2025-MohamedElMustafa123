package com.example.genredome

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SoulArtistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_soul_artist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Finds the back arrow button in the layout using its id and stores it in a val
        val backArrowButton = findViewById<ImageButton>(R.id.backArrowButton)

        //Finds the artists image buttons in the layout using its id and stores it in a val
        val szaButton: ImageButton = findViewById(R.id.szaButton)
        val weekendButton: ImageButton = findViewById(R.id.weekendButton)
        val herButton: ImageButton = findViewById(R.id.herButton)
        val frankButton: ImageButton = findViewById(R.id.frankButton)
        val aliciaButton: ImageButton = findViewById(R.id.aliciaButton)

        //takes the user back to the Home screen when clicked
        backArrowButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        //opens SZA spotify page on click
        szaButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/7tYKF4w9nC0nq9CsPZTHyP"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens the weekend spotify page on click
        weekendButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/1Xyo4u8uXC1ZmMpatF05PJ"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens HER spotify page on click
        herButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/3Y7RZ31TRPVadSFVy1o8os"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens frank ocean spotify page on click
        frankButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/2h93pZq0e7k5yf4dywlkpM"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens alica spotify page on click
        aliciaButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/3DiDSECUqqY1AuBP8qtaIa"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }
    }
}