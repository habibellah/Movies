package habibellah.ayata.movies.ui.screens.seeMoreMoviesScreen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

private const val ROUTE = "SeeMoreMovies"

fun NavController.navigateToSeeMoreMoviesScreen(movieType : String) {
    navigate("${ROUTE}/$movieType")
}

fun NavGraphBuilder.seeMoreMoviesRoute() {
    composable("${ROUTE}/{${SeeMoreMovieArgs.MOVIE_TYPE}}",
        arguments = listOf(
            navArgument(SeeMoreMovieArgs.MOVIE_TYPE) {
                NavType.StringType
                defaultValue = ""
            }
        )
    ) {
        SeeMoreMoviesScreen()
    }
}

class SeeMoreMovieArgs(savedStateHandle : SavedStateHandle) {
    val movieType : String = checkNotNull(savedStateHandle.get<String>(MOVIE_TYPE))

    companion object {
        const val MOVIE_TYPE = "movieType"
    }
}