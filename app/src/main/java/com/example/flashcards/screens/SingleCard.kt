package com.example.flashcards.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SingleCardScreen(
    deckId: String,
    cardId: String,
    onBack: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Card: $cardId", style = MaterialTheme.typography.headlineMedium)
        Text("Deck: $deckId", style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(24.dp))
        // TODO: front/back display, edit toggle
        TextButton(onClick = onBack) { Text("Back") }
    }
}