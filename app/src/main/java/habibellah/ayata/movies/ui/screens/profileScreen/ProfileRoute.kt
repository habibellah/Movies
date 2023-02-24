package habibellah.ayata.movies.ui.screens.profileScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "profile"

fun NavController.navigateToProfileScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.profileRoute() {
  composable(
    ROUTE
  ) {
   ProfileScreen()
  }
}
