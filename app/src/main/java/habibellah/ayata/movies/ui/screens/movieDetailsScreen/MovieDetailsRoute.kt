package habibellah.ayata.movies.ui.screens.movieDetailsScreen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import habibellah.ayata.movies.ui.screens.movieDetailsScreen.MovieDetailsArgs.Companion.ID_ARG

private const val ROUTE = "MovieDetails"

fun NavController.navigateToMovieDetailsScreen(id: Int) {
  navigate("$ROUTE/$id")
}

fun NavGraphBuilder.movieDetailsRoute() {
  composable("$ROUTE/{$ID_ARG}",
    arguments = listOf(
      navArgument(ID_ARG) {
        NavType.IntType
        defaultValue = 0

      }
    )
  ) {
    MovieDetailsScreen()
  }
}

class MovieDetailsArgs(savedStateHandle: SavedStateHandle) {
  val id: Int = checkNotNull(savedStateHandle.get<Int>(ID_ARG))

  companion object {
    const val ID_ARG = "id"
  }
}