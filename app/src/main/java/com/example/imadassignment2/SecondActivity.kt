package com.example.imadassignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private var clickCountFeed = 0
    private var clickCountClean = 0
    private var clickCountPlay = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val petImageSecond = findViewById<ImageView>(R.id.petImageSecond)
        val feedButton = findViewById<Button>(R.id.feedButton)
        val cleanButton = findViewById<Button>(R.id.cleanButton)
        val playButton = findViewById<Button>(R.id.playButton)
        val restoreButton = findViewById<Button>(R.id.restoreButton)
        val backButton = findViewById<Button>(R.id.backButton)

        feedButton.setOnClickListener {
            if (clickCountFeed < 10) {
                petImageSecond.setImageResource(R.drawable.feed)
                clickCountFeed++
                findViewById<TextView>(R.id.feedCount).text = clickCountFeed.toString()
                if (clickCountFeed == 10) {
                    feedButton.isEnabled = false
                    showWellDoneMessage()
                }
            }
        }

        cleanButton.setOnClickListener {
            if (clickCountClean < 10) {
                petImageSecond.setImageResource(R.drawable.clean)
                clickCountClean++
                findViewById<TextView>(R.id.cleanCount).text = clickCountClean.toString()
                if (clickCountClean == 10) {
                    cleanButton.isEnabled = false
                    showWellDoneMessage()
                }
            }
        }

        playButton.setOnClickListener {
            if (clickCountPlay < 10) {
                petImageSecond.setImageResource(R.drawable.play)
                clickCountPlay++
                findViewById<TextView>(R.id.playCount).text = clickCountPlay.toString()
                if (clickCountPlay == 10) {
                    playButton.isEnabled = false
                    showWellDoneMessage()
                }
            }
        }

        restoreButton.setOnClickListener {
            // Reset counts and restore dog image
            clickCountFeed = 0
            clickCountClean = 0
            clickCountPlay = 0
            petImageSecond.setImageResource(R.drawable.dog)
            findViewById<TextView>(R.id.feedCount).text = "0"
            findViewById<TextView>(R.id.cleanCount).text = "0"
            findViewById<TextView>(R.id.playCount).text = "0"
            // Enable buttons
            feedButton.isEnabled = true
            cleanButton.isEnabled = true
            playButton.isEnabled = true
        }

        backButton.setOnClickListener {
            // Navigate back to the welcome page
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showWellDoneMessage() {
        Toast.makeText(this, "Well done! The job is done.", Toast.LENGTH_SHORT).show()
    }
}
