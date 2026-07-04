package com.example.flashcards.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.flashcards.ui.theme.ButtonForReturn

// ── Start Session (deck picker)

@Composable
fun StartSessionScreen(
    onDeckSelected: (deckId: String) -> Unit,
    onBack: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Start Session", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp))
        Text("Pick a deck to study", style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(24.dp))
        // TODO: list of decks to choose from
        Button(onClick = { onDeckSelected("demo-deck-1") }) { Text("Study Demo Deck") }
        Spacer(Modifier.height(12.dp))

        ButtonForReturn(onClick = onBack, text = "Back")

    }
}

// ── Study Session (active flip session)

@Composable
fun StudySessionScreen(
    deckId: String,
    onFinished: () -> Unit,
    onBack: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Studying: $deckId", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp))
        Text("(Placeholder)", style = MaterialTheme.typography.bodySmall)
        Spacer(Modifier.height(24.dp))

        Button(onClick = onFinished) { Text("Finish Session") }
        Spacer(Modifier.height(12.dp))

        ButtonForReturn(onClick = onBack, text = "Back")

    }
}