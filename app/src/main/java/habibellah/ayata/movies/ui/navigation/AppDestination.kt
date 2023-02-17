package habibellah.ayata.movies.ui.navigation

sealed class Screen(val route : String){
  object HomeScreen : Screen("home")
 }