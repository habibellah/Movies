package habibellah.ayata.movies.ui.screens.loginScreen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "Login"

fun NavGraphBuilder.loginRoute() {
    composable(
        ROUTE
    ) {
        LoginScreen()
    }
}
