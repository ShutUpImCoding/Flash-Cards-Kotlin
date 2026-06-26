package com.example.flashcards.navigation

/**
 * Sealed class defining all navigation destinations in the app.
 *
 * HOW TO ADD A NEW SCREEN
 * ────────────────────────
 * 1. Add an object here (with optional args)
 * 2. Add a composable block in FlashcardNavGraph.kt
 * 3. Optionally add to BottomNavItem.kt if it needs a bottom tab
 */
sealed class Routes(val route: String) {

    // ── Top-level screens (Home is the navigation hub) ───────────────────

    /** Home screen — main place with buttons to all major sections */
    data object Home : Routes("home")

    /** All decks / categories */
    data object DeckList : Routes("deck_list")

    /** Add a new flashcard */
    data object AddCard : Routes("add_card")

    /** Start a study session — user picks a deck / mode here */
    data object StartSession : Routes("start_session")

    // ── Detail screens ────────────────────────────────────────────────────

    /**
     * All cards inside a single deck/category.
     * Usage: Routes.DeckDetail.buildRoute("deck-123")
     */
    data object DeckDetail : Routes("deck_detail/{deckId}") {
        const val ARG_DECK_ID = "deckId"
        fun buildRoute(deckId: String) = "deck_detail/$deckId"
    }

    /**
     * View / edit a single flashcard.
     * Both deckId and cardId are needed so we can navigate back to the right deck.
     * Usage: Routes.SingleCard.buildRoute("deck-123", "card-456")
     */
    data object SingleCard : Routes("card/{deckId}/{cardId}") {
        const val ARG_DECK_ID = "deckId"
        const val ARG_CARD_ID = "cardId"
        fun buildRoute(deckId: String, cardId: String) = "card/$deckId/$cardId"
    }

    /**
     * Active study/flip session for a deck.
     * Usage: Routes.StudySession.buildRoute("deck-123")
     */
    data object StudySession : Routes("study/{deckId}") {
        const val ARG_DECK_ID = "deckId"
        fun buildRoute(deckId: String) = "study/$deckId"
    }
}