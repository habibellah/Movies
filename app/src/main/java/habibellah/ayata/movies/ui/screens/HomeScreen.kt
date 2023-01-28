package habibellah.ayata.movies.ui.screens


import androidx.compose.runtime.Composable
import habibellah.ayata.movies.ui.composables.MovieItemWithCategoryName

@Composable
fun HomeScreen(){
    MovieItemWithCategoryName(movieCategory = "Top Rated")
}
