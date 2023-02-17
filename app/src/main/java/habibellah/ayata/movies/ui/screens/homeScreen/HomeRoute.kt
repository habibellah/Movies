package habibellah.ayata.movies.ui.screens.homeScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "home"

fun NavGraphBuilder.homeRoute(navController: NavController) {
  composable(
    ROUTE
  ) {
    HomeScreen(navController = navController)
  }
}
