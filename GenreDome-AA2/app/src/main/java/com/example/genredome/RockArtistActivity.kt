package com.example.genredome

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RockArtistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rock_artist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Finds the back arrow button in the layout using its id and stores it in a val
        val backArrowButton = findViewById<ImageButton>(R.id.backArrowButton)

        //Finds the artists image buttons in the layout using its id and stores it in a val
        val fooButton: ImageButton = findViewById(R.id.fooButton)
        val arcticButton: ImageButton = findViewById(R.id.arcticButton)
        val museButton: ImageButton = findViewById(R.id.museButton)
        val redHotChilliButton: ImageButton = findViewById(R.id.redHotChilliButton)
        val imagineDragonsButton: ImageButton = findViewById(R.id.imagineDragonsButton)

        //takes the user back to the Home screen when clicked
        backArrowButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        //opens foo fighters spotify page on click
        fooButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/7jy3rLJdDQY21OgRLCZ9sD"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens arctic monkeys spotify page on click
        arcticButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/7Ln80lUS6He07XvHI8qqHH"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens muse spotify page on click
        museButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/12Chz98pHFMPJEknJQMWvI"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens RHC peppers spotify page on click
        redHotChilliButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/0L8ExT028jH3ddEcZwqJJ5"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens imagine dragons spotify page on click
        imagineDragonsButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/53XhwfbYqKCa1cC15pYq2q"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }
    }


}