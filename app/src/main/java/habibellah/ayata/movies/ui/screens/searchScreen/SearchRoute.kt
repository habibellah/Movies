package habibellah.ayata.movies.ui.screens.searchScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "search"

fun NavGraphBuilder.searchRoute() {
  composable(
    ROUTE
  ) {
    SearchScreen()
  }
}
