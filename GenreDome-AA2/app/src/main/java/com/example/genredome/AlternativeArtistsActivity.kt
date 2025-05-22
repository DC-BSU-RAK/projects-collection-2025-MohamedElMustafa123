package com.example.genredome

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AlternativeArtistsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alternative_artists)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Finds the back arrow button in the layout using its id and stores it in a val
        val backArrowButton = findViewById<ImageButton>(R.id.backArrowButton)

        //Finds the artists image buttons in the layout using its id and stores it in a val
        val jojiButton: ImageButton = findViewById(R.id.jojiButton)
        val mitskiButton: ImageButton = findViewById(R.id.mitskiButton)
        val phoebeButton: ImageButton = findViewById(R.id.phoebeButton)
        val tameButton: ImageButton = findViewById(R.id.tameButton)
        val clairoButton: ImageButton = findViewById(R.id.clairoButton)

        //takes the user back to the Home screen when clicked
        backArrowButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        //opens joji spotify page on click
        jojiButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/3MZsBdqDrRTJihTHQrO6Dq"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens mitski spotify page on click
        mitskiButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/2uYWxilOVlUdk4oV9DvwqK"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens phoebe spotify page on click
        phoebeButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/1r1uxoy19fzMxunt3ONAkG"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens tame impala spotify page on click
        tameButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/5INjqkS1o8h1imAzPqGZBb"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens clairo spotify page on click
        clairoButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/3l0CmX0FuQjFxr8SK7Vqag"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

    }
}