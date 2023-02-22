package habibellah.ayata.movies.ui.screens.loginScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "Login"

fun NavGraphBuilder.loginRoute(navController: NavController) {
    composable(
        ROUTE
    ) {
        LoginScreen(navController = navController)
    }
}
