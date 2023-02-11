package habibellah.ayata.movies.ui.viewModels.states

import habibellah.ayata.movies.data.movieDataSource.movieApi.MovieResponse
import habibellah.ayata.movies.data.repositories.MovieState

data class HomeUiState(
    val popularMovie: MovieState<MovieResponse?> =MovieState.Loading ,
    val onTheAir: MovieState<MovieResponse?> =MovieState.Loading,
    val trending:MovieState<MovieResponse?> =MovieState.Loading,
    val nowStreaming:MovieState<MovieResponse?> =MovieState.Loading,
    val upComing:MovieState<MovieResponse?> =MovieState.Loading,

    )

open class MovieUiState(
    open val categoryName: String? = null,
    open val imageUrl: String? = null
)
