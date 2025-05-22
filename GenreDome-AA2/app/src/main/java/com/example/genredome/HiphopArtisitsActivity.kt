package com.example.genredome

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HiphopArtisitsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hiphop_artists)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Finds the back arrow button in the layout using its id and stores it in a val
        val backArrowButton = findViewById<ImageButton>(R.id.backArrowButton)

        //Finds the artists image buttons in the layout using its id and stores it in a val
        val drakeButton: ImageButton = findViewById(R.id.drakeButton)
        val kendrickButton: ImageButton = findViewById(R.id.kendrickButton)
        val travisButton: ImageButton = findViewById(R.id.travisButton)
        val coleButton: ImageButton = findViewById(R.id.coleButton)
        val nickiButton: ImageButton = findViewById(R.id.nickiButton)

        //takes the user back to the Home screen when clicked
        backArrowButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        //opens drake spotify page on click
        drakeButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/3TVXtAsR1Inumwj472S9r4"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens kendrick spotify page on click
        kendrickButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/2YZyLoL8N0Wb9xBt1NhZWg"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens travis spotify page on click
        travisButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/0Y5tJX1MQlPlqiwlOH1tJY"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens j cole spotify page on click
        coleButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/6l3HvQ5sa6mXTsMTB19rO5"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens nicki minaj spotify page on click
        nickiButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/0hCNtLu0JehylgoiP8L4Gh"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }
    }
}