package com.example.youssef_echady_sfaxi

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun QuizScreen() {
    val context = LocalContext.current
    val questions = remember { Constants.getQuestions() }
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf(-1) }
    var correctAnswers by remember { mutableStateOf(0) }
    val question = questions[currentQuestionIndex]
    val totalQuestions = questions.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                val intent = Intent(context, Navigation::class.java)
                context.startActivity(intent)
                (context as? Activity)?.finish()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text("Back to navigation screen", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Text(
            text = question.question,
            fontSize = 22.sp,
            color = Color(0xFF363A43),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .size(120.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = painterResource(id = question.image),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LinearProgressIndicator(
                progress = (currentQuestionIndex + 1) / totalQuestions.toFloat(),
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
            )
            Text(
                text = "${currentQuestionIndex + 1}/$totalQuestions",
                modifier = Modifier.padding(15.dp),
                color = Color(0xFF7A8089),
                fontSize = 14.sp
            )
        }

        val options = listOf(
            question.optionOne,
            question.optionTwo,
            question.optionThree,
            question.optionFour
        )

        options.forEachIndexed { index, optionText ->
            val bgColor = when {
                selectedOption == -1 -> Color(0xFF78A8F5)
                index + 1 == question.correctAnswer -> Color(0xFF4CAF50) // green for correct
                index + 1 == selectedOption -> Color(0xFFE53935) // red for wrong
                else -> Color(0xFF78A8F5)
            }

            Text(
                text = optionText,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(bgColor)
                    .padding(15.dp)
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .clickable(enabled = selectedOption == -1) { selectedOption = index + 1 },
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }

        Button(
            onClick = {
                if (selectedOption != -1) {
                    if (selectedOption == question.correctAnswer) correctAnswers++

                    if (currentQuestionIndex < totalQuestions - 1) {
                        currentQuestionIndex++
                        selectedOption = -1
                    } else {
                        //show results page
                    }
                }

            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF59ABCF)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = if (currentQuestionIndex == totalQuestions - 1) "FINISH" else "NEXT",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun NavigationScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "quiz") {
        composable("quiz") { QuizScreen() }
        composable("result/{score}/{total}") { backStackEntry ->
            val score = backStackEntry.arguments?.getString("score")?.toInt() ?: 0
            val total = backStackEntry.arguments?.getString("total")?.toInt() ?: 0
            ResultScreen(score = score, total = total, onFinishClick = {
                navController.popBackStack("quiz", inclusive = true)
            })
        }
    }
}



@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    QuizScreen()
}
