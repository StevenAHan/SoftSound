package com.example.noisemaker

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.view.isVisible

class Stream : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stream)

        //Set up the switch to turn the sound off or on
        val playButton = findViewById<ImageView>(R.id.btnTurnOnOff)
        val stopButton = findViewById<ImageView>(R.id.stopButton)
        val timerSeekBar = findViewById<SeekBar>(R.id.timerCircle)
        val softSound: MediaPlayer = MediaPlayer.create(this, R.raw.watersoundslol)
        val timerOn = findViewById<ImageView>(R.id.timerStartRectangle)
        val timerTimeOn = findViewById<TextView>(R.id.timerStartTime)
        var theMinutes = ""
        var seconds = 0L
        var theSeconds = ""
        var newSeconds: Long
        var soundIsOn: Boolean = false
        lateinit var timer : CountDownTimer
        timerSeekBar.max = 1800
        playButton.setOnClickListener{
            newSeconds = timerSeekBar.progress.toLong()
            if (!soundIsOn) {
                softSound.isLooping = true
                softSound.start()
                soundIsOn = true
                stopButton.isVisible = true
                seconds = newSeconds + 1
            }
            else
            {
                softSound.pause()
                soundIsOn = false
                stopButton.isVisible = false
                timerOn.isVisible = false
                timerTimeOn.isVisible = false
            }

            var currentSeconds = seconds.toInt()

            if(!soundIsOn && currentSeconds > 2)
            {
                timer.cancel()
            }
            if(currentSeconds > 2)
            {
                timer = object : CountDownTimer(seconds * 1000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        timerSeekBar.setProgress(((millisUntilFinished / 1000)).toInt())
                        if (currentSeconds > 2) {
                            currentSeconds--
                            theMinutes = (currentSeconds / 60).toString()
                            theSeconds = (currentSeconds % 60).toString()
                            if(theSeconds.toInt() < 10)
                            {
                                theSeconds = "0" + theSeconds
                            }
                            timerTimeOn.text = (theMinutes + ":" + theSeconds)
                        }
                    }

                    override fun onFinish() {
                        softSound.pause()
                    }
                }
                if(soundIsOn)
                {
                    timer.start()
                    timerOn.isVisible = true
                    timerTimeOn.isVisible = true
                }
            }
        }

        val prevButton = findViewById<ImageView>(R.id.previousButton)
        val nextButton = findViewById<ImageView>(R.id.nextButton)
        prevButton.setOnClickListener {
            softSound.stop()
            val prevIntent = Intent(this, Lawn :: class.java)
            startActivity(prevIntent)
        }

        nextButton.setOnClickListener {
            softSound.stop()
            val nextIntent = Intent(this, Ac :: class.java)
            startActivity(nextIntent)
        }
        //Set up home button
        val homeButton = findViewById<ImageView>(R.id.btnHome)
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity :: class.java)
            //Makes sure that the sound doesn't carry through
            softSound.stop()
            //Shifts back to home screen
            startActivity(intent)
        }
    }
}