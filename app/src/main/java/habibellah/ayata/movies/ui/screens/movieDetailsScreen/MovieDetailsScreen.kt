package habibellah.ayata.movies.ui.screens.movieDetailsScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import habibellah.ayata.movies.ui.composables.MovieDetailsItem
import habibellah.ayata.movies.ui.viewModels.MovieDetailsViewModel
import habibellah.ayata.movies.ui.viewModels.states.MovieDetailsUiState

@Composable
fun MovieDetailsScreen(
    movieDetailsViewModel: MovieDetailsViewModel = hiltViewModel()
){
    val movieDetailsUiState by movieDetailsViewModel.movieDetailsUiState.collectAsState()
  MovieDetailsScreenContent(movieDetailsUiState)
}

@Composable
private fun MovieDetailsScreenContent(movieDetails : MovieDetailsUiState){
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        MovieDetailsItem(movieDetails = movieDetails) {

        }

        Text(text = movieDetails.overView.toString())
        Text(text = "Cast")
         Text(text = "similar movie")
        Text(text = "list of similar movie")
        Text(text = "rate the movie")



    }
}

