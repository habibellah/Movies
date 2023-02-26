package habibellah.ayata.movies.ui.screens.movieDetailsScreen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import habibellah.ayata.movies.R
import habibellah.ayata.movies.ui.composables.*
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

@OptIn(ExperimentalComposeUiApi::class)
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
        Row (horizontalArrangement = Arrangement.SpaceEvenly){
            Image(
                painter = painterResource(id = R.drawable.review_star),
                contentDescription = "review star",
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier
                .width(5.dp)
                .height(5.dp))
            Text(
                text = movieDetails.voteAverage.toString(),
                fontSize = 15.sp,
                color = white
            )
            Spacer(modifier = Modifier
                .width(10.dp)
                .height(10.dp))
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
                .padding(vertical = 10.dp),
        )
        Text(
            text = movieDetails.overView.toString(),
            fontSize = 15.sp,
            color = Color.Gray,
            modifier = Modifier.padding(5.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Actors", textAlign = TextAlign.Left,
            fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
        HandleActorsLazyRow(actorsList = movieDetails.actorsList)
        Text(
            text = "Similar Movie", textAlign = TextAlign.Left,
            fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
        )
        HandleSimilarMoviesLazyRow(similarMovieList = movieDetails.similarMovieList)
        Text(
            text = "Rate The Movie", textAlign = TextAlign.Left,
            fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
        )
        RatingBar(rating = 0, isSelectable = true)
        Text(
            text = "Reviews", textAlign = TextAlign.Left,
            fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
        )
        HandleMovieReviewsLazyColumn(reviewsList = movieDetails.reviewsList)
        Button(
            onClick = { },
            modifier = Modifier
                .clip(RoundedCornerShape(40))
                .height(50.dp)
                .width(350.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.red_movie)
            ),
            contentPadding = PaddingValues(5.dp)
        ) {
            Text(text = "View All Reviews", modifier = Modifier.background(Red), fontSize = 15.sp)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview() {
    MovieDetailsScreen()
}
