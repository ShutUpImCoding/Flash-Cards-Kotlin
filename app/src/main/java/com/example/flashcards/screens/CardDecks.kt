package com.example.flashcards.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flashcards.ui.theme.ButtonForAction
import com.example.flashcards.ui.theme.ButtonForReturn


// ── Deck List (all categories)

@Composable
fun DeckListScreen(
    onDeckClick: (deckId: String) -> Unit,
    onBack: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("My Decks", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(24.dp))
        // TODO: LazyColumn of deck cards

        ButtonForAction(onClick = { onDeckClick("demo-deck-1") }, text = "Demo Deck →")

        Spacer(Modifier.height(12.dp))

        ButtonForReturn(onClick = onBack, text = "Back")

    }
}

// ── Deck Detail (cards inside one deck)

@Composable
fun DeckDetailScreen(
    deckId: String,
    onCardClick: (cardId: String) -> Unit,
    onBack: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Deck: $deckId", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(24.dp))
        // TODO: LazyColumn of cards in this deck

        ButtonForAction(onClick = { onCardClick("demo-card-1") }, text = "Demo Card →")
        Spacer(Modifier.height(12.dp))
        ButtonForReturn(onClick = onBack, text = "Back")

    }
}