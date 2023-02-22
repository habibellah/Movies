package habibellah.ayata.movies.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.domain.entity.MovieResponse
import habibellah.ayata.domain.useCase.MovieState
import habibellah.ayata.domain.useCase.GetMoviesUseCase
import habibellah.ayata.movies.ui.viewModels.states.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase) :
  ViewModel() {
  private val _homeState = MutableStateFlow(HomeUiState())
  val homeState = _homeState.asStateFlow()

  init {
    getPopularMovieLists()
    getUpComingMovieLists()
    getNowStreamingMovieLists()
    getTrendingMovieLists()
    getOnTheAirMovieLists()
  }

  private fun getPopularMovieLists() {
    viewModelScope.launch {
      getMoviesUseCase.getMovieListByType("popular").collect {
        _homeState.update { homeUiState -> homeUiState.copy(popularMovie = handleMovieState(it)) }
      }
    }
  }


  private fun getUpComingMovieLists() {
    viewModelScope.launch {
      getMoviesUseCase.getMovieListByType("upcoming").collect {
        _homeState.update { homeUiState -> homeUiState.copy(upComing = handleMovieState(it)) }
      }
    }
  }

  private fun getNowStreamingMovieLists() {
    viewModelScope.launch {
      getMoviesUseCase.getMovieListByType("now_playing").collect {
        _homeState.update { homeUiState -> homeUiState.copy(nowStreaming = handleMovieState(it)) }
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
        _homeState.update { homeUiState -> homeUiState.copy(onTheAir = handleMovieState(it)) }
      }
    }
  }

  private fun handleMovieState(movieState: MovieState<MovieResponse?>): MovieState<MovieResponse?> {
    return when (movieState) {
      is MovieState.Loading -> {
        MovieState.Loading
      }
      is MovieState.Success -> {
        MovieState.Success(movieState.data)
      }
      else -> {
        MovieState.Error("unknown")
      }
    }
  }
}