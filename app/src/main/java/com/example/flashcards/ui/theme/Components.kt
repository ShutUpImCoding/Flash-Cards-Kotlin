package com.example.flashcards.ui.theme


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun ButtonForAction(
    onClick: () -> Unit,
    text: String,
) {
    Button(modifier = Modifier.fillMaxWidth(), onClick = onClick) {
        Text(text)
    }
}

@Composable
fun ButtonForReturn(
    onClick: () -> Unit,
    text: String,
) {
    TextButton(onClick = onClick) {
        Text(text)
    }
}

/* Card looking component for navigating */
@Composable
fun NavigationCard(
    onClick: () -> Unit,
    text: String,
) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        onClick = onClick,
        border = BorderStroke(
            2.dp,
            MaterialTheme.colorScheme.outline
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

/*
* CREATING NEW FLASHCARD
* TODO Different ways to add question -> card changes style
*  - image (camera, gallery), text,
* */
@Composable
fun FlashCardField(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
) {

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = title,
                modifier = Modifier.padding(10.dp)
            )
            HorizontalDivider()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                TextField(
                    value = value,
                    onValueChange = onValueChange,
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = LocalTextStyle.current.copy(
                        textAlign = TextAlign.Center
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        cursorColor = MaterialTheme.colorScheme.primary
                    ),
                    placeholder = {
                        Text(
                            text = placeholder,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    singleLine = false,
                    maxLines = 20
                )
            }
        }
    }
}