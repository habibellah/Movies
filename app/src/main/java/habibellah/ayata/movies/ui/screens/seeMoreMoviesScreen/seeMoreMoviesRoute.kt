package habibellah.ayata.movies.ui.screens.seeMoreMoviesScreen

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import habibellah.ayata.movies.ui.ShowType

private const val ROUTE = "SeeMoreMovies"

fun NavController.navigateToSeeMoreMoviesScreen(movieType : String,filmType:ShowType) {
    navigate("${ROUTE}/$movieType/$filmType")
}

fun NavGraphBuilder.seeMoreMoviesRoute(navController: NavController) {
    composable("${ROUTE}/{${SeeMoreMovieArgs.MOVIE_TYPE}}/{${SeeMoreMovieArgs.FILM_TYPE}}",
        arguments = listOf(
            navArgument(SeeMoreMovieArgs.MOVIE_TYPE) {
                NavType.StringType
                defaultValue = ""
            },
            navArgument(SeeMoreMovieArgs.FILM_TYPE) {
                NavType.EnumType::class.java
                defaultValue = ShowType.MOVIE
            }
        )
    ) {
        SeeMoreMoviesScreen(navController)
    }
}

class SeeMoreMovieArgs(savedStateHandle : SavedStateHandle) {
    val movieType : String = checkNotNull(savedStateHandle.get<String>(MOVIE_TYPE))
    val filmType : ShowType = checkNotNull(savedStateHandle.get<ShowType>(FILM_TYPE))

    companion object {
        const val MOVIE_TYPE = "movieType"
        const val FILM_TYPE = "filmType"
    }
}