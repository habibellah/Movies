package habibellah.ayata.movies.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import habibellah.ayata.movies.ui.ShowType
import habibellah.ayata.movies.ui.viewModels.states.MovieUiState

@Composable
fun LazyRowState(
    movieState : MutableList<MovieUiState>?,
    onClick : (id : Int?, filmType : ShowType) -> Unit,
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
                    ErrorMovieItem(
                        modifier = modifier
                            .fillMaxWidth()
                            .width(150.dp)
                    )
                }
            }
        }
        if (movieState != null) {
            if (movieState.isNotEmpty()) {
                items(movieState.toList()) {
                    MovieItem(
                        movieState = it, modifier
                            .fillMaxWidth()
                            .width(150.dp),
                        onClick = { id, filmType ->
                            onClick(id, filmType)
                        }
                    )
                }
            }
        }
    }
}
