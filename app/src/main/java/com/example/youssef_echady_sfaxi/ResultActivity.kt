package com.example.youssef_echady_sfaxi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    val tv_score = findViewById<TextView>(R.id.tv_score)
    val tv_congratulations = findViewById<TextView>(R.id.tv_congratulations)
    val iv_trophy = findViewById<ImageView>(R.id.iv_trophy)
    val btn_finish = findViewById<TextView>(R.id.btn_finish)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tv_score.text = "Your Score is $correctAnswers out of $totalQuestions."

        if (correctAnswers <= 4) {
            iv_trophy.setImageResource(R.drawable.sad_emoticon)
            tv_congratulations.text = "Hey, Try again!"
        }

        btn_finish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }
    }
}