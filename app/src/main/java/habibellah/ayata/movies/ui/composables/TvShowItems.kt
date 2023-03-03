package habibellah.ayata.movies.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import habibellah.ayata.movies.ui.ShowType
import habibellah.ayata.movies.ui.viewModels.states.MovieUiState

@Composable
fun TvShowItemsState(
    popularTvShow : MutableList<MovieUiState>?,
    onClick : (id : Int?, filmType : ShowType) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TvShowState(
            tvShow = popularTvShow, onClick = onClick, modifier = Modifier
                .height(305.dp)
                .width(150.dp), 0
        )
        TvShowState(
            tvShow = popularTvShow, onClick = onClick, modifier = Modifier
                .height(305.dp)
                .width(150.dp), 1
        )
    }
}

@Composable
private fun TvShowState(
    tvShow : MutableList<MovieUiState>?,
    onClick : (id : Int?, filmType : ShowType) -> Unit,
    modifier : Modifier = Modifier,
    numberOfTvShow : Int
) {
    if (tvShow != null) {
        AnimatedVisibility(tvShow.isEmpty()) {
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
    if (tvShow != null) {
        if (tvShow.isNotEmpty()) {
            MovieItem(
                movieState = tvShow[numberOfTvShow], modifier
                    .fillMaxWidth()
                    .width(150.dp),
                onClick = { id, filmType ->
                    onClick(id, filmType)
                }
            )
        }
    }
}
