package habibellah.ayata.movies.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import habibellah.ayata.movies.ui.screens.FavoriteScreen
import habibellah.ayata.movies.ui.screens.HomeScreen
import habibellah.ayata.movies.ui.screens.ProfileScreen
import habibellah.ayata.movies.ui.screens.SearchScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("search") {
            SearchScreen()
        }
        composable("favorite") {
            FavoriteScreen()
        }
        composable("profile") {
            ProfileScreen()
        }
    }
}

