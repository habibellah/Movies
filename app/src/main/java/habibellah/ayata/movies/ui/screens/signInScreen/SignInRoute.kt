package habibellah.ayata.movies.ui.screens.signInScreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "SignIn"

fun NavController.navigateToSingInScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.singInRoute() {
    composable(
        ROUTE
    ) {
        SignInScreen()
    }
}
