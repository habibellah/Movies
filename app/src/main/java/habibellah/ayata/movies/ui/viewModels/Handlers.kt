package habibellah.ayata.movies.ui.viewModels

import habibellah.ayata.domain.entity.MovieResponse
import habibellah.ayata.domain.entity.Result
import habibellah.ayata.domain.entity.TvShowsResponse
import habibellah.ayata.domain.useCase.MovieState
import habibellah.ayata.movies.ui.ShowType
import habibellah.ayata.movies.ui.viewModels.states.MovieUiState

object Handlers {
     fun handleMovieState(movieState : MovieState<MovieResponse?>) : MutableList<MovieUiState>? {
        return when (movieState) {
            is MovieState.Loading -> {
                mutableListOf()
            }
            is MovieState.Success -> {
                toMovieList(movieState.data?.results)
            }
            else -> {
                null
            }
        }
    }

     fun handleTVState(movieState : MovieState<TvShowsResponse?>) : MutableList<MovieUiState>? {
        return when (movieState) {
            is MovieState.Loading -> {
                mutableListOf()
            }
            is MovieState.Success -> {
                toTvShowList(movieState.data?.results)
            }
            else -> {
                null
            }
        }
    }

    private fun toMovieList(results : List<Result?>?) : MutableList<MovieUiState>? {
        return results?.map {
            MovieUiState(it?.title, "https://image.tmdb.org/t/p/w500${it?.posterPath}", it?.id,
                ShowType.MOVIE)
        }?.toMutableList()
    }

    private fun toTvShowList(results : List<Result>?) : MutableList<MovieUiState>? {
        return results?.map {
            MovieUiState(it.title, "https://image.tmdb.org/t/p/w500${it.posterPath}", it.id,
                ShowType.TV_SHOW)
        }?.toMutableList()
    }
}