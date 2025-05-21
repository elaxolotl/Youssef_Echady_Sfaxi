package com.example.youssef_echady_sfaxi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun ResultScreen(score: Int, total: Int, onFinishClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Result",
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 25.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_trophy),
            contentDescription = "image",
            modifier = Modifier
                .padding(top = 16.dp)
                .size(150.dp), // Adjust size as needed
            contentScale = ContentScale.Fit
        )

        Text(
            text = "Hey, Congratulations!",
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "Your Score is $score out of $total",
            color = Color.DarkGray,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 10.dp)
        )

        Button(
            onClick = onFinishClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Text(
                text = "FINISH",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
