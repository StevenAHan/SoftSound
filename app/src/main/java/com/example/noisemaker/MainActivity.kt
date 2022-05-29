package com.example.noisemaker

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.isVisible
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val array = arrayOf(Rain::class.java, Fan::class.java, Lawn::class.java, Stream::class.java, Ac::class.java, Shower::class.java)
        val randomNumber = Random.nextInt(6)
        val random = array[randomNumber]

        //Set up the rain button to go to that activity screen
        val rainButton = findViewById<ImageView>(R.id.rainIcon)
        rainButton.setOnClickListener {
            val intent = Intent(this, Rain :: class.java)
            startActivity(intent)
        }

        //Set up the fan button to go to that activity screen
        val fanButton = findViewById<ImageView>(R.id.fanIcon)
        fanButton.setOnClickListener {
            val intent = Intent(this, Fan :: class.java)
            startActivity(intent)
        }

        //Set up the lawnmower button to go to that activity screen
        val lawnButton = findViewById<ImageView>(R.id.lawnIcon)
        lawnButton.setOnClickListener {
            val intent = Intent(this, Lawn :: class.java)
            startActivity(intent)
        }

        //Set up the water stream button to go to that activity screen
        val streamButton = findViewById<ImageView>(R.id.streamIcon)
        streamButton.setOnClickListener {
            val intent = Intent(this, Stream :: class.java)
            startActivity(intent)
        }


        //Set up the ac button to go to that activity screen
        val acButton = findViewById<ImageView>(R.id.acIcon)
        acButton.setOnClickListener {
            val intent = Intent(this, Ac :: class.java)
            startActivity(intent)
        }

        //Set up the shower button to go to that activity screen
        val showerButton = findViewById<ImageView>(R.id.showerIcon)
        showerButton.setOnClickListener {
            val intent = Intent(this, Shower :: class.java)
            startActivity(intent)
        }
        //Set up the random button to go to a random activity screen
        val randomButton = findViewById<ImageView>(R.id.randomButton)
        randomButton.setOnClickListener {
            val intent = Intent(this, random)
            startActivity(intent)
        }

        val releasePolicy = findViewById<ImageView>(R.id.aboutUsIcon)
        val privPol = findViewById<ImageView>(R.id.privacyPolicy)
        releasePolicy.setOnClickListener {
            privPol.isVisible = privPol.isVisible != true
        }

    }
}