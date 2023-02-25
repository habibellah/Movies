package habibellah.ayata.movies.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import habibellah.ayata.movies.ui.viewModels.states.MovieUiState


@Composable
fun HandleStateForLazyRow(
    movieState : MutableList<MovieUiState>?,
    onClick : (id : Int?) -> Unit,
    modifier : Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            if (movieState != null) {
                AnimatedVisibility(movieState.isEmpty()) {
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
        }
        if (movieState != null) {
            items(movieState.toList()) {
                MovieItem(
                    movieState = it, modifier
                        .fillMaxWidth()
                        .width(150.dp), 1,
                    onClick = { id ->
                        onClick(id)
                    }
                )
            }
        }
    }
}
