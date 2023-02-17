package habibellah.ayata.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import habibellah.ayata.movies.ui.navigation.BottomNavItem
import habibellah.ayata.movies.ui.navigation.BottomNavigationBar
import habibellah.ayata.movies.ui.navigation.Navigation
import habibellah.ayata.movies.ui.theme.MoviesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(items = listOf(
                            BottomNavItem(
                                name = "Home",
                                route = "home",
                                icon = Icons.Default.Home
                                ),
                            BottomNavItem(
                                name = "Search",
                                route = "search",
                                icon = Icons.Default.Search
                            ),
                            BottomNavItem(
                                name = "Favorite",
                                route = "favorite",
                                icon = Icons.Default.Favorite
                            ),
                            BottomNavItem(
                                name = "Profile",
                                route = "profile",
                                icon = Icons.Default.Person
                            ),
                        ), navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            })
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoviesTheme {
        Greeting("Android")
    }
}