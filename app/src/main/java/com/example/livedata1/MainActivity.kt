package com.example.livedata1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    val vmodel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        var textView = findViewById<TextView>(R.id.tvNumber)
        var buttonNext = findViewById<Button>(R.id.button_next)
        var buttonprev = findViewById<Button>(R.id.button_prev)
        var progressBar = findViewById<ProgressBar>(R.id.progressBar)
        var questionText = findViewById<TextView>(R.id.tvQuestion)


        progressBar.max = vmodel.questionCount

        buttonNext.setOnClickListener {
           vmodel.nextClicked()
        }
        buttonprev.setOnClickListener {
            vmodel.prevClicked()
        }

        val numberObserver = Observer<Int> { number ->
                textView.text = number.toString()
                progressBar.progress = number
        }

        val buttonNextEnabledObserver = Observer<Boolean>{  enabled ->
            buttonNext.isEnabled = enabled
        }
        val buttonPrevEnabledObserver = Observer<Boolean>{  enabled ->
            buttonprev.isEnabled = enabled
        }

        val questionObserver = Observer<String>{ question ->
            questionText.text = question
        }

        vmodel.questionLiveData.observe(this , questionObserver)
        vmodel.nextEnabledLiveData.observe(this , buttonNextEnabledObserver)
        vmodel.prevEnabledLiveData.observe(this , buttonPrevEnabledObserver)
        vmodel.numberLiveData.observe(this , numberObserver)

    }
}