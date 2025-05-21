package com.example.youssef_echady_sfaxi

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.view.View
import android.widget.Button
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent{
            ActivityMain()
        }
    }
}