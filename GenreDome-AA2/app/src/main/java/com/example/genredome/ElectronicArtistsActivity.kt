package com.example.genredome

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ElectronicArtistsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_electronic_artists)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Finds the back arrow button in the layout using its id and stores it in a val
        val backArrowButton = findViewById<ImageButton>(R.id.backArrowButton)

        //Finds the artists image buttons in the layout using its id and stores it in a val
        val calvinButton: ImageButton = findViewById(R.id.calvinButton)
        val davidButton: ImageButton = findViewById(R.id.davidButton)
        val marshmelloButton: ImageButton = findViewById(R.id.marshmelloButton)
        val zeddButton: ImageButton = findViewById(R.id.zeddButton)
        val kygoButton: ImageButton = findViewById(R.id.kygoButton)

        //takes the user back to the Home screen when clicked
        backArrowButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        //opens calvin harris spotify page on click
        calvinButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/7CajNmpbOovFoOoasH2HaY"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens david spotify page on click
        davidButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/1Cs0zKBU1kc0i8ypK3B9ai"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens marshmello spotify page on click
        marshmelloButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/64KEffDW9EtZ1y2vBYgq8T"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens zedd spotify page on click
        zeddButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/2qxJFvFYMEDqd7ui6kSAcq"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens kygo spotify page on click
        kygoButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/23fqKkggKUBHNkbKtXEls4"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }
    }
}