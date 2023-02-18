package habibellah.ayata.movies.ui.viewModels.states

import habibellah.ayata.domain.entity.MovieResponse
import habibellah.ayata.domain.repositories.MovieState

data class HomeUiState(
  val popularMovie: MovieState<MovieResponse?> = MovieState.Loading,
  val onTheAir: MovieState<MovieResponse?> = MovieState.Loading,
  val trending: MovieState<MovieResponse?> = MovieState.Loading,
  val nowStreaming: MovieState<MovieResponse?> = MovieState.Loading,
  val upComing: MovieState<MovieResponse?> = MovieState.Loading,

  )

class MovieUiState(
  val categoryName: String? = null,
  val imageUrl: String? = null,
  val id: Int? = null
)
