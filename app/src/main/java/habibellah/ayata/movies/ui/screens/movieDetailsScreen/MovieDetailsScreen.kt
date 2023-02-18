package habibellah.ayata.movies.ui.screens.movieDetailsScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import habibellah.ayata.movies.ui.composables.MovieDetailsItem
import habibellah.ayata.movies.ui.theme.white
import habibellah.ayata.movies.ui.viewModels.MovieDetailsViewModel
import habibellah.ayata.movies.ui.viewModels.states.MovieDetailsUiState

@Composable
fun MovieDetailsScreen(
  movieDetailsViewModel: MovieDetailsViewModel = hiltViewModel()
) {
  val movieDetailsUiState by movieDetailsViewModel.movieDetailsUiState.collectAsState()
  MovieDetailsScreenContent(movieDetailsUiState)
}

@Composable
private fun MovieDetailsScreenContent(movieDetails: MovieDetailsUiState) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(rememberScrollState()),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    MovieDetailsItem(movieDetails = movieDetails) {

    }

    Text(
      text = movieDetails.movieTitle.toString(),
      fontSize = 15.sp,
      color = white
    )

    Text(
      text = "14/12/2020",
      fontSize = 10.sp,
      color = Color.Gray
    )
    Text(
      text = "company production",
      fontSize = 10.sp,
      color = Red
    )
    Row {
      Text(
        text = "7.7*",
        fontSize = 10.sp,
        color = white
      )
      Text(
        text = "2720 review",
        fontSize = 10.sp,
        color = white
      )
    }
    Text(text = "Overview")
    Text(text = movieDetails.overView.toString())
     Text(text = "similar movie")
    Text(text = "Rate the movie")
    Text(text = "Reviews")


  }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview() {
  MovieDetailsScreen()
}
