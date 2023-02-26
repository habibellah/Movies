package habibellah.ayata.movies.ui.screens.movieDetailsScreen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import habibellah.ayata.movies.ui.composables.HandleActorsLazyRow
import habibellah.ayata.movies.ui.composables.MovieDetailsCard
import habibellah.ayata.movies.ui.theme.white
import habibellah.ayata.movies.ui.viewModels.MovieDetailsViewModel
import habibellah.ayata.movies.ui.viewModels.states.MovieDetailsUiState

@Composable
fun MovieDetailsScreen(
    movieDetailsViewModel : MovieDetailsViewModel = hiltViewModel()
) {
    val movieDetailsUiState by movieDetailsViewModel.movieDetailsUiState.collectAsState()
    MovieDetailsScreenContent(movieDetailsUiState)
}

@Composable
private fun MovieDetailsScreenContent(movieDetails : MovieDetailsUiState) {
    Column(
        modifier = Modifier
            .padding(bottom = 60.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MovieDetailsCard(movieDetails = movieDetails) {
        }

        Text(
            text = movieDetails.movieTitle.toString(),
            fontSize = 25.sp,
            color = white,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = movieDetails.releaseDate.toString(),
            fontSize = 15.sp,
            color = Color.Gray
        )
        Text(
            text = movieDetails.genre.toString(),
            fontSize = 15.sp,
            color = Red
        )
        Row {
            Text(
                text = movieDetails.voteAverage.toString(),
                fontSize = 15.sp,
                color = white
            )
            Icon(imageVector = Icons.Default.Star, contentDescription = "a star")
            Text(
                text = "${movieDetails.voteCount} reviews",
                fontSize = 15.sp,
                color = white
            )
        }
        Text(
            text = "Overview", textAlign = TextAlign.Left,
            fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
        )
        Text(
            text = movieDetails.overView.toString(),
            fontSize = 15.sp,
            color = Color.Gray,
            modifier = Modifier.padding(5.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "actors", textAlign = TextAlign.Left,
            fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        )
HandleActorsLazyRow(actorsList = movieDetails.actorsList)
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
