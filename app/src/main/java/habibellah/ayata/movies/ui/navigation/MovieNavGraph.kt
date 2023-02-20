package habibellah.ayata.movies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import habibellah.ayata.movies.ui.screens.favoriteScreen.favoriteRoute
import habibellah.ayata.movies.ui.screens.homeScreen.homeRoute
import habibellah.ayata.movies.ui.screens.loginScreen.loginRoute
import habibellah.ayata.movies.ui.screens.movieDetailsScreen.movieDetailsRoute
import habibellah.ayata.movies.ui.screens.profileScreen.profileRoute
import habibellah.ayata.movies.ui.screens.searchScreen.searchRoute

@Composable
fun MovieNavGraph(navController: NavHostController) {
  NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
    homeRoute(navController = navController)
    searchRoute()
    favoriteRoute()
    profileRoute()
    movieDetailsRoute()
    loginRoute()
  }
}