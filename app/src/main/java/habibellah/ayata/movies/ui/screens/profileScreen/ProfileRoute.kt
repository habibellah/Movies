package habibellah.ayata.movies.ui.screens.profileScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "profile"

fun NavGraphBuilder.profileRoute() {
  composable(
    ROUTE
  ) {
   ProfileScreen()
  }
}
