package habibellah.ayata.movies.ui.screens.favoriteScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "favorite"

fun NavGraphBuilder.favoriteRoute() {
  composable(
    ROUTE
  ) {
    FavoriteScreen()
  }
}
