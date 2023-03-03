package habibellah.ayata.movies.ui.screens.seeMoreMoviesScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import habibellah.ayata.movies.ui.composables.MovieItem
import habibellah.ayata.movies.ui.viewModels.SeeMoreMoviesViewModel

@Composable
fun SeeMoreMoviesScreen(viewModel : SeeMoreMoviesViewModel = hiltViewModel()) {
    val state = viewModel.state

    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(16.dp, bottom = 50.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(state.movieList.size) { i ->
            val item = state.movieList[i]

            if (i >= state.movieList.size - 1 && !state.endReached && !state.isLoading) {
                viewModel.loadNextItems()
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                MovieItem(
                    movieState = item, Modifier
                        .fillMaxWidth()
                        .width(150.dp),
                    onClick = { _, _ ->
                    }
                )
                Spacer(
                    modifier = Modifier
                        .width(5.dp)
                        .height(5.dp)
                )
            }
        }
        item {
            if (state.isLoading) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .background(color = Color.Black)
                            .height(100.dp)
                            .width(100.dp)
                    )
                }
            }
        }
    }
}
