package com.example.flashcards.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.LibraryBooks
import androidx.compose.material.icons.automirrored.outlined.LibraryBooks
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


/* CURRENT SOLUTION DOESN'T USE THIS */
/**
 * Bottom navigation bar.
 * Automatically highlights the tab matching the current route.
 * Only tabs listed in [BottomNavItem] are shown here.
 */
@Composable
fun BottomBar(navController: NavController) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    NavigationBar {
        BottomNavItem.entries.forEach { item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController.navigate(item.route) {
                            // Pop up to the start destination so back-stack doesn't grow
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (selected) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.label,
                    )
                },
                label = { Text(item.label) },
            )
        }
    }
}

/**
 * Returns true when the current route should show the bottom bar.
 * Detail screens (DeckDetail, StudySession) hide it automatically.
 */
@Composable
fun shouldShowBottomBar(navController: NavController): Boolean {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val bottomRoutes = BottomNavItem.entries.map { it.route }.toSet()
    return currentRoute in bottomRoutes
}

/**
 * Screens that appear as tabs in the BottomNavigationBar.
 * To add a new tab: just add an entry here — NavGraph picks it up automatically.
 */
enum class BottomNavItem(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    HOME(
        route = Routes.Home.route,
        label = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
    ),
    DECKS(
        route = Routes.DeckList.route,
        label = "My Decks",
        selectedIcon = Icons.AutoMirrored.Filled.LibraryBooks,
        unselectedIcon = Icons.AutoMirrored.Outlined.LibraryBooks,
    ),
    ADD(
        route = Routes.AddCard.route,
        label = "Add Card",
        selectedIcon = Icons.Filled.Add,
        unselectedIcon = Icons.Outlined.Add,
    ),
}