package com.example.flashcards.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flashcards.ui.theme.ButtonForAction


@Composable
fun HomeScreen(
    onAddCard: () -> Unit,
    onMyDecks: () -> Unit,
    onStartSession: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Flashcards", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(32.dp))

        ButtonForAction(text = "CREATE NEW", onClick = onAddCard)
        Spacer(Modifier.height(12.dp))
        ButtonForAction(text = "My Decks", onClick = onMyDecks)

        Spacer(Modifier.height(12.dp))
        ButtonForAction(text = "Start Session", onClick = onStartSession)

    }
}



