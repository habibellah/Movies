package habibellah.ayata.movies.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import habibellah.ayata.domain.entity.MovieResponse
import habibellah.ayata.domain.repositories.MovieState
import habibellah.ayata.movies.ui.viewModels.states.MovieUiState

@Composable
fun HandleStateForLazyGrid(movieState: MovieState<MovieResponse?>?, onClick: (id: Int?) -> Unit) {
  LazyVerticalGrid(
    contentPadding = PaddingValues(16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    columns = GridCells.Fixed(2),
    content = {
      when (movieState) {
        is MovieState.Loading -> {
          item { LoadingMovieLists() }
        }
        is MovieState.Success -> {
          items(toMovieList(movieState.data).subList(0, 4)) {
            MovieItem(
              movieState = it, modifier = Modifier
                .fillMaxWidth()
                .width(300.dp), 1,
              onClick = { id ->
                onClick(id)
              }
            )
          }
        }
        else -> {
          item {
            MovieItem(
              movieState = MovieUiState(categoryName = "loading", imageUrl = ""),
              modifier = Modifier
                .fillMaxWidth()
                .width(300.dp),
              3,
              onClick = { id ->
                onClick(id)
              }
            )
          }
        }
      }
    },
    modifier = Modifier.height(350.dp)
  )
}


@Composable
fun HandleStateForLazyRow(movieState: MovieState<MovieResponse?>?, onClick: (id: Int?) -> Unit) {
  LazyRow(
    contentPadding = PaddingValues(16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    when (movieState) {
      is MovieState.Loading -> {
        item { LoadingMovieLists() }
      }
      is MovieState.Success -> {
        items(toMovieList(movieState.data)) {
          MovieItem(
            movieState = it, modifier = Modifier
              .fillMaxWidth()
              .width(300.dp), 1,
            onClick = { id ->
              onClick(id)
            }
          )
        }
      }
      else -> {
        item {
          MovieItem(
            movieState = MovieUiState(categoryName = "loading", imageUrl = ""),
            modifier = Modifier
              .fillMaxWidth()
              .width(300.dp),
            3,
            onClick = { id ->
              onClick(id)
            }
          )
        }
      }
    }
  }
}


private fun toMovieList(data: MovieResponse?): List<MovieUiState> {
  val movieList = ArrayList<MovieUiState>()
  for (i in 0 until data?.results!!.size) {
    movieList.add(
      MovieUiState(
        categoryName = data.results!![i]?.originalTitle,
        imageUrl = "https://image.tmdb.org/t/p/w500${data.results!![i]?.posterPath}",
        id = data.results!![i]?.id
      )
    )
  }
  return movieList
}