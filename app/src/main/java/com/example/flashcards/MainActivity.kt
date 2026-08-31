package com.example.flashcards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.flashcards.navigation.FlashcardNavGraph
import com.example.flashcards.ui.theme.FlashCardsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashCardsTheme() {
                FlashcardApp()
            }
        }
    }
}

@Composable
fun FlashcardApp() {
    val navController = rememberNavController()

    Scaffold(
    ) { innerPadding ->
        // Pass innerPadding into your root layout so content
        // isn't clipped by system bars or a future bottom bar.
        // Each screen should apply: modifier = Modifier.padding(innerPadding)
        FlashcardNavGraph(navController = navController)
    }
}