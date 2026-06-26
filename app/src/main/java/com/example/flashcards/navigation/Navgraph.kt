package com.example.flashcards.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.flashcards.screens.AddCardScreen
import com.example.flashcards.screens.DeckDetailScreen
import com.example.flashcards.screens.DeckListScreen
import com.example.flashcards.screens.HomeScreen
import com.example.flashcards.screens.SingleCardScreen
import com.example.flashcards.screens.StartSessionScreen
import com.example.flashcards.screens.StudySessionScreen

/**
 * Central navigation graph.
 *
 *
 * HOW TO ADD A NEW SCREEN
 * ────────────────────────
 * 1. Add a Routes entry in Routes.kt
 * 2. Add a composable { } block below
 * 3. Optionally add to BottomNavItem.kt for a bottom tab
 *
 * HOW TO NAVIGATE (from any screen that receives navController)
 * ──────────────────────────────────────────────────────────────
 *   // Simple push
 *   navController.navigate(Routes.DeckList.route)
 *
 *   // Push with argument
 *   navController.navigate(Routes.DeckDetail.buildRoute(deckId))
 *
 *   // Push and clear previous screen from back stack
 *   navController.navigate(Routes.DeckList.route) {
 *       popUpTo(Routes.AddCard.route) { inclusive = true }
 *   }
 *
 *   // Go back one screen
 *   navController.popBackStack()
 */

@Composable
fun FlashcardNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home.route,
    ) {

        // ── Home ──────────────────────────────────────────────────────────

        composable(Routes.Home.route) {
            HomeScreen(
                onAddCard = { navController.navigate(Routes.AddCard.route) },
                onMyDecks = { navController.navigate(Routes.DeckList.route) },
                onStartSession = { navController.navigate(Routes.StartSession.route) },
            )
        }

        // ── Add Card ──────────────────────────────────────────────────────

        composable(Routes.AddCard.route) {
            AddCardScreen(
                onCardSaved = {
                    // After saving, go to DeckList and drop AddCard from back stack
                    navController.navigate(Routes.DeckList.route) {
                        popUpTo(Routes.AddCard.route) { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() },
            )
        }

        // ── Deck list (all categories) ────────────────────────────────────

        composable(Routes.DeckList.route) {
            DeckListScreen(
                onDeckClick = { deckId ->
                    navController.navigate(Routes.DeckDetail.buildRoute(deckId))
                },
                onBack = { navController.popBackStack() },
            )
        }

        // ── Deck detail (cards inside one category) ───────────────────────

        composable(
            route = Routes.DeckDetail.route,
            arguments = listOf(
                navArgument(Routes.DeckDetail.ARG_DECK_ID) { type = NavType.StringType },
            ),
        ) { backStackEntry ->
            val deckId = backStackEntry.arguments
                ?.getString(Routes.DeckDetail.ARG_DECK_ID) ?: ""

            DeckDetailScreen(
                deckId = deckId,
                onCardClick = { cardId ->
                    navController.navigate(Routes.SingleCard.buildRoute(deckId, cardId))
                },
                onBack = { navController.popBackStack() },
            )
        }

        // ── Single card (view / edit) ─────────────────────────────────────

        composable(
            route = Routes.SingleCard.route,
            arguments = listOf(
                navArgument(Routes.SingleCard.ARG_DECK_ID) { type = NavType.StringType },
                navArgument(Routes.SingleCard.ARG_CARD_ID) { type = NavType.StringType },
            ),
        ) { backStackEntry ->
            val deckId = backStackEntry.arguments

                ?.getString(Routes.SingleCard.ARG_DECK_ID) ?: ""
            val cardId = backStackEntry.arguments
                ?.getString(Routes.SingleCard.ARG_CARD_ID) ?: ""

            SingleCardScreen(
                deckId = deckId,
                cardId = cardId,
                onBack = { navController.popBackStack() },
            )
        }

        // ── Start session (pick a deck) ───────────────────────────────────

        composable(Routes.StartSession.route) {
            StartSessionScreen(
                onDeckSelected = { deckId ->
                    navController.navigate(Routes.StudySession.buildRoute(deckId))
                },
                onBack = { navController.popBackStack() },
            )
        }

        // ── Study session (active flip session) ───────────────────────────

        composable(
            route = Routes.StudySession.route,
            arguments = listOf(
                navArgument(Routes.StudySession.ARG_DECK_ID) { type = NavType.StringType },
            ),
        ) { backStackEntry ->
            val deckId = backStackEntry.arguments
                ?.getString(Routes.StudySession.ARG_DECK_ID) ?: ""

            StudySessionScreen(
                deckId = deckId,
                onFinished = { navController.popBackStack() },
                onBack = { navController.popBackStack() },
            )
        }
    }
}
