package habibellah.ayata.movies.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.domain.useCase.GetMoviesUseCase
import habibellah.ayata.movies.ui.viewModels.states.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import habibellah.ayata.movies.ui.viewModels.Handlers.handleMovieState
import habibellah.ayata.movies.ui.viewModels.Handlers.handleTVState

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
                _homeState.update { homeUiState -> homeUiState.copy(trending = handleMovieState(it)) }
            }
        }
    }

    private fun getOnTheAirMovieLists() {
        viewModelScope.launch {
            getMoviesUseCase.getOnTheAirTvList().collect {
                _homeState.update { homeUiState -> homeUiState.copy(onTheAir = handleTVState(it)) }
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
}