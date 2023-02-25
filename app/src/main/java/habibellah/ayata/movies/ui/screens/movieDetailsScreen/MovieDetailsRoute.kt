package habibellah.ayata.movies.ui.screens.movieDetailsScreen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import habibellah.ayata.movies.ui.ShowType
import habibellah.ayata.movies.ui.screens.movieDetailsScreen.MovieDetailsArgs.Companion.FILM_TYPE
import habibellah.ayata.movies.ui.screens.movieDetailsScreen.MovieDetailsArgs.Companion.ID_ARG

private const val ROUTE = "MovieDetails"

fun NavController.navigateToMovieDetailsScreen(id: Int,filmType : ShowType) {
  navigate("$ROUTE/$id/$filmType")
}

fun NavGraphBuilder.movieDetailsRoute() {
  composable("$ROUTE/{$ID_ARG}/{$FILM_TYPE}",
    arguments = listOf(
      navArgument(ID_ARG) {
        NavType.IntType
        defaultValue = 0

      },
      navArgument(FILM_TYPE) {
        NavType.EnumType(ShowType::class.java)
        defaultValue = ShowType.MOVIE

      }
    )
  ) {
    MovieDetailsScreen()
  }
}

class MovieDetailsArgs(savedStateHandle: SavedStateHandle) {
  val id: Int = checkNotNull(savedStateHandle.get<Int>(ID_ARG))
  val filmType: ShowType = checkNotNull(savedStateHandle.get<ShowType>(FILM_TYPE))

  companion object {
    const val ID_ARG = "id"
    const val FILM_TYPE = "filmType"
  }
}