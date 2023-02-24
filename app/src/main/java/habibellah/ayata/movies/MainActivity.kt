package habibellah.ayata.movies

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import habibellah.ayata.movies.ui.navigation.BottomNavItem
import habibellah.ayata.movies.ui.navigation.BottomNavigationBar
import habibellah.ayata.movies.ui.navigation.Navigation
import habibellah.ayata.movies.ui.theme.MoviesTheme
import habibellah.ayata.movies.ui.viewModels.UserInfoViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                val userInfoViewModel : UserInfoViewModel = hiltViewModel()
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
                            profileOrLoginScreen(userInfoViewModel.getUserName()),
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

fun profileOrLoginScreen(userName : String?) : BottomNavItem {
    return if (userName != null) {
        BottomNavItem(
            name = "Profile",
            route = "profile",
            icon = Icons.Default.Person
        )
    } else {
        BottomNavItem(
            name = "Login",
            route = "Login",
            icon = Icons.Default.Close
        )

    }
}

@Composable
fun Greeting(name : String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoviesTheme {
        Greeting("Android")
    }
}