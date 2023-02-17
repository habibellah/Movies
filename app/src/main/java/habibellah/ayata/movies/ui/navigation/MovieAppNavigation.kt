package habibellah.ayata.movies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun Navigation(navController: NavHostController) {
  MovieNavGraph(navController = navController)
}

