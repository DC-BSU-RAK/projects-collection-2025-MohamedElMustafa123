package com.example.moodtrack

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {
    //map of pairings
    private val genreMap = mapOf(
        //happy pairings
        Pair("happy", "morning") to "Indie Pop",
        Pair("happy", "noon") to "Funky Groove",
        Pair("happy", "evening") to "Synthpop",
        Pair("happy", "night") to "Chill Dance",
        Pair("happy", "latenight") to "Dream Pop",

        //chill pairings
        Pair("chill", "morning") to "Acoustic Lofi",
        Pair("chill", "noon") to "Coffeehouse",
        Pair("chill", "evening") to "Chillhop",
        Pair("chill", "night") to "Ambient Jazz",
        Pair("chill", "latenight") to "Downtempo Beats",

        //energetic pairings
        Pair("energetic", "morning") to "Pop Rock",
        Pair("energetic", "noon") to "EDM",
        Pair("energetic", "evening") to "Electropop",
        Pair("energetic", "night") to "Trap Party",
        Pair("energetic", "latenight") to "Hyperpop",

        //sad pairings
        Pair("sad", "morning") to "Indie Folk",
        Pair("sad", "noon") to "Melancholy Rock",
        Pair("sad", "evening") to "Soft Piano",
        Pair("sad", "night") to "Sad R&B",
        Pair("sad", "latenight") to "Ambient Ballad",

        //moody pairings
        Pair("moody", "morning") to "Dreamwave",
        Pair("moody", "noon") to "Art Pop",
        Pair("moody", "evening") to "Trip-Hop",
        Pair("moody", "night") to "Experimental",
        Pair("moody", "latenight") to "Jazz Noir"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //info button found by id and stored in a val
        val infoButton = findViewById<ImageButton>(R.id.infoButton)

        //variables to store selected mood and time
        var moodSelected: String? = null
        var timeSelected: String? = null

        //generate button found by id and stored in a val
        val generateButton = findViewById<Button>(R.id.generateSuggestionButton)

        //load bounce animation
        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)

        //val to store references to the last selected buttons for animation clearing
        var selectedMoodAnimatedButton: ImageButton? = null
        var selectedTimeAnimatedButton: ImageButton? = null

        //animation for mood buttons
        fun onMoodImageButtonClicked(button: ImageButton) {
            selectedMoodAnimatedButton?.clearAnimation()
            button.startAnimation(bounceAnimation)
            selectedMoodAnimatedButton = button
        }

        //animation for the time buttons
        fun onTimeImageButtonClicked(button: ImageButton) {
            selectedTimeAnimatedButton?.clearAnimation()
            button.startAnimation(bounceAnimation)
            selectedTimeAnimatedButton = button
        }

        // Mood buttons
        val chillButton = findViewById<ImageButton>(R.id.chillButton)
        val anxiousButton = findViewById<ImageButton>(R.id.sadButton)
        val moodyButton = findViewById<ImageButton>(R.id.moodyButton)
        val happyButton = findViewById<ImageButton>(R.id.happyButton)
        val energeticButton = findViewById<ImageButton>(R.id.energeticButton)

        // Time buttons
        val morningButton = findViewById<ImageButton>(R.id.morningButton)
        val afternoonButton = findViewById<ImageButton>(R.id.afternoonButton)
        val eveningButton = findViewById<ImageButton>(R.id.eveningButton)
        val nightButton = findViewById<ImageButton>(R.id.nightButton)
        val latenightButton = findViewById<ImageButton>(R.id.latenightButton)

        //onclick instructions pop up
        infoButton.setOnClickListener {
            val infoOutput = layoutInflater.inflate(R.layout.info_output, null)
            AlertDialog.Builder(this)
                .setView(infoOutput)
                .setPositiveButton("Ok", null)
                .create()
                .show()
        }

        // ALL MOOD BUTTONS ON CLICK LISTENERS
        chillButton.setOnClickListener {
            onMoodImageButtonClicked(chillButton)
            moodSelected = "chill"
        }

        anxiousButton.setOnClickListener {
            onMoodImageButtonClicked(anxiousButton)
            moodSelected = "sad"
        }

        moodyButton.setOnClickListener {
            onMoodImageButtonClicked(moodyButton)
            moodSelected = "moody"
        }

        happyButton.setOnClickListener {
            onMoodImageButtonClicked(happyButton)
            moodSelected = "happy"
        }

        energeticButton.setOnClickListener {
            onMoodImageButtonClicked(energeticButton)
            moodSelected = "energetic"
        }

        morningButton.setOnClickListener {
            onTimeImageButtonClicked(morningButton)
            timeSelected = "morning"
        }

        afternoonButton.setOnClickListener {
            onTimeImageButtonClicked(afternoonButton)
            timeSelected = "noon"
        }

        eveningButton.setOnClickListener {
            onTimeImageButtonClicked(eveningButton)
            timeSelected = "evening"
        }

        nightButton.setOnClickListener {
            onTimeImageButtonClicked(nightButton)
            timeSelected = "night"
        }

        latenightButton.setOnClickListener {
            onTimeImageButtonClicked(latenightButton)
            timeSelected = "latenight"
        }



        generateButton.setOnClickListener{
            if (moodSelected !=null && timeSelected !=null){
                //gets the genre paired based on the mood and time selected
                val genre = genreMap[Pair(moodSelected, timeSelected)]?:"null"

                //inflates the genre result pop up screen
                val genreOutputView = layoutInflater.inflate(R.layout.genre_output, null)
                val vibeImage = genreOutputView.findViewById<ImageView>(R.id.vibeImage)
                val genreText = genreOutputView.findViewById<TextView>(R.id.genreText)

                //letter capitalization
                val moodLabel = moodSelected!!.replaceFirstChar { it.uppercaseChar() }
                val timeLabel = timeSelected!!.replaceFirstChar { it.uppercaseChar() }

                //sets the genre text
                genreText.text = "Mood: $moodLabel\nTime: $timeLabel\n\nGenre: $genre"

                //choosing gif based on mood selected
                val gifRes = when (moodSelected){
                    "happy" -> R.drawable.happybmo
                    "sad" -> R.drawable.sadbmo
                    "chill" -> R.drawable.chillbmoo
                    "energetic" -> R.drawable.energeticbmo
                    "moody" -> R.drawable.moodybmo
                    else -> R.drawable.sadbmo // if no mood is selected displays the sadbmo (never happens)
                }

                //loading gif using Glide library
                Glide.with(this)
                    .asGif()
                    .load(gifRes)
                    .into(vibeImage)

                //shows result
                AlertDialog.Builder(this)
                    .setView(genreOutputView)
                    .setPositiveButton("Ok", null)
                    .create()
                    .show()
            }else{
                //shows an error if mood or time or none is selected
                val errorOutput = layoutInflater.inflate(R.layout.error_output, null)
                val errorGif = errorOutput.findViewById<ImageView>(R.id.errorGif)
                val errorText = errorOutput.findViewById<TextView>(R.id.errorText)

                errorText.text = "Please select both mood and time of day"

                Glide.with(this)
                    .asGif()
                    .load(R.drawable.errorbmo)
                    .into(errorGif)
                AlertDialog.Builder(this)
                    .setView(errorOutput)
                    .setPositiveButton("Ok", null)
                    .create()
                    .show()
            }
        }

    }
}
