package habibellah.ayata.movies.ui.composables

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import habibellah.ayata.movies.ui.viewModels.states.MovieUiState

@Composable
fun HandleTvShowItemState(
    popularTvShow : MutableList<MovieUiState>?,
    onClick : (id : Int?) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        HandleTvShowState(tvShow = popularTvShow, onClick = onClick, modifier = Modifier.height (305.dp)
            .width(150.dp),0)
        HandleTvShowState(tvShow = popularTvShow, onClick = onClick, modifier = Modifier.height (305.dp)
            .width(150.dp),1)
    }
}

@Composable
private fun  HandleTvShowState(
    tvShow : MutableList<MovieUiState>?,
    onClick : (id : Int?) -> Unit,
    modifier : Modifier = Modifier,
    numberOfTvShow : Int
) {
        if (tvShow != null) {
            AnimatedVisibility(tvShow.isEmpty()) {
                LoadingMovieLists()
            }
        } else {
            AnimatedVisibility(true) {
                MovieItem(
                    movieState = MovieUiState(categoryName = "loading", imageUrl = ""),
                    modifier = modifier
                        .fillMaxWidth()
                        .width(150.dp),
                    3,
                    onClick = { id ->
                        onClick(id)
                    }
                )
            }
        }
    if (tvShow != null) {
            MovieItem(
                movieState = tvShow[numberOfTvShow], modifier
                    .fillMaxWidth()
                    .width(150.dp), 1,
                onClick = { id ->
                    onClick(id)
                }
            )
    }
}
