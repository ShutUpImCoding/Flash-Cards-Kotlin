package com.example.flashcards.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(
    onAddCard: () -> Unit,
    onMyDecks: () -> Unit,
    onStartSession: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Flashcards", style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(32.dp))
        Button(modifier = Modifier.fillMaxWidth(), onClick = onAddCard) {
            Text("Add New Card")
        }
        Spacer(Modifier.height(12.dp))
        Button(modifier = Modifier.fillMaxWidth(), onClick = onMyDecks) {
            Text("My Decks")
        }
        Spacer(Modifier.height(12.dp))
        Button(modifier = Modifier.fillMaxWidth(), onClick = onStartSession) {
            Text("Start Session")
        }
    }
}



