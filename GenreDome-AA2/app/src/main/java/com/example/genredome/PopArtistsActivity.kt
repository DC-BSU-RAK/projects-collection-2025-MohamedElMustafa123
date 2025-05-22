package com.example.genredome

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PopArtistsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pop_artists)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Finds the back arrow button in the layout using its id and stores it in a val
        val backArrowButton = findViewById<ImageButton>(R.id.backArrowButton)

        //Finds the artists image buttons in the layout using its id and stores it in a val
        val taylorButton: ImageButton = findViewById(R.id.taylorButton)
        val duaLipaButton: ImageButton = findViewById(R.id.duaLipaButton)
        val billieButton: ImageButton = findViewById(R.id.billieButton)
        val ladyGagaButton: ImageButton = findViewById(R.id.ladyGagaButton)
        val brunoMarsButton: ImageButton = findViewById(R.id.brunoMarsButton)

        //takes the user back to the Home screen when clicked
        backArrowButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        //opens taylor swift spotify page on click
        taylorButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/06HL4z0CvFAxyc27GXpf02"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens dua lipa spotify page on click
        duaLipaButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/6M2wZ9GZgrQXHCFfjv46we"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens billie eilish spotify page on click
        billieButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/6qqNVTkY8uBg9cP3Jd7DAH"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens lady gaga spotify page on click
        ladyGagaButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/1HY2Jd0NmPuamShAr6KMms"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }

        //opens bruno mars spotify page on click
        brunoMarsButton.setOnClickListener {
            val spotifyUrl = "https://open.spotify.com/artist/0du5cEVh5yTK9QJze8zA0C"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(spotifyUrl)
            startActivity(intent)
        }
    }
}