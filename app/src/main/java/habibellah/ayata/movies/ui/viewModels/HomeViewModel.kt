package habibellah.ayata.movies.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.domain.entity.MovieResponse
import habibellah.ayata.domain.entity.TvShowsResponse
import habibellah.ayata.domain.useCase.MovieState
import habibellah.ayata.domain.useCase.GetMoviesUseCase
import habibellah.ayata.movies.ui.viewModels.states.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import habibellah.ayata.domain.entity.Result
import habibellah.ayata.movies.ui.ShowType

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMoviesUseCase : GetMoviesUseCase) :
    ViewModel() {
    private val _homeState = MutableStateFlow(HomeUiState())
    val homeState = _homeState.asStateFlow()

    init {
        getPopularMovieLists()
        getUpComingMovieLists()
        getNowStreamingMovieLists()
        getTrendingMovieLists()
        getOnTheAirMovieLists()
        getTopRatedMovies()
        getPopularTvShow()
    }

    private fun getPopularMovieLists() {
        viewModelScope.launch {
            getMoviesUseCase.getMovieListByCategory("popular").collect {
                _homeState.update { homeUiState ->
                    homeUiState.copy(
                        popularMovie = handleMovieState(
                            it
                        )
                    )
                }
            }
        }
    }

    private fun getUpComingMovieLists() {
        viewModelScope.launch {
            getMoviesUseCase.getMovieListByCategory("upcoming").collect {
                _homeState.update { homeUiState -> homeUiState.copy(upComing = handleMovieState(it)) }
            }
        }
    }

    private fun getNowStreamingMovieLists() {
        viewModelScope.launch {
            getMoviesUseCase.getMovieListByCategory("now_playing").collect {
                _homeState.update { homeUiState ->
                    homeUiState.copy(
                        nowStreaming = handleMovieState(
                            it
                        )
                    )
                }
            }
        }
    }

    private fun getTrendingMovieLists() {
        viewModelScope.launch {
            getMoviesUseCase.getTrendingMovieList().collect {
                _homeState.update { homeUiState -> homeUiState.copy(trending = handleTVState(it)) }
            }
        }
    }

    private fun getOnTheAirMovieLists() {
        viewModelScope.launch {
            getMoviesUseCase.getOnTheAirTvList().collect {
                _homeState.update { homeUiState -> homeUiState.copy(onTheAir = handleMovieState(it)) }
            }
        }
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            getMoviesUseCase.getMovieListByCategory("top_rated").collect {
                _homeState.update { homeUiState -> homeUiState.copy(topRated = handleMovieState(it)) }
            }
        }
    }

    private fun getPopularTvShow() {
        viewModelScope.launch {
            getMoviesUseCase.getPopularTvShow().collect {
                _homeState.update { homeUiState -> homeUiState.copy(popularTvShow = handleTVState(it)) } }
        }
    }

    private fun handleMovieState(movieState : MovieState<MovieResponse?>) : MutableList<MovieUiState>? {
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

    private fun handleTVState(movieState : MovieState<TvShowsResponse?>) : MutableList<MovieUiState>? {
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
            MovieUiState(it?.title, "https://image.tmdb.org/t/p/w500${it?.posterPath}", it?.id,ShowType.MOVIE)
        }?.toMutableList()
    }

    private fun toTvShowList(results : List<Result>?) : MutableList<MovieUiState>? {
        return results?.map {
            MovieUiState(it.title, "https://image.tmdb.org/t/p/w500${it.posterPath}", it.id,ShowType.TV_SHOW)
        }?.toMutableList()
    }
}