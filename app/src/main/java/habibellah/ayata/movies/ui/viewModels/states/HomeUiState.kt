package habibellah.ayata.movies.ui.viewModels.states

import habibellah.ayata.movies.data.movieDataSource.movieApi.MovieResponse
import habibellah.ayata.movies.data.repositories.MovieState

data class HomeUiState(
    val popularMovie: MovieState<MovieResponse?>? =null ,
    val onTheAir: MovieState<MovieResponse?>? =null,
    val trending:MovieState<MovieResponse?>? =null,
    val nowStreaming:MovieState<MovieResponse?>? =null,
    val upComing:MovieState<MovieResponse?>? =null,

    )

open class MovieUiState(
    open val categoryName: String? = null,
    open val imageUrl: String? = null
)
