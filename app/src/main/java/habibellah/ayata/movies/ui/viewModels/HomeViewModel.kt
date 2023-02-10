package habibellah.ayata.movies.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.movies.data.repositories.MovieRepository
import habibellah.ayata.movies.data.repositories.MovieState
import habibellah.ayata.movies.ui.viewModels.states.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel(){
    private val _homeState = MutableStateFlow(HomeUiState())
    val homeState = _homeState.asStateFlow()

    init {
        getPopularMovieLists()
        getUpComingMovieLists()
        getNowStreamingMovieLists()
        getTrendingMovieLists()
        getOnTheAirMovieLists()
    }
    private fun getPopularMovieLists(){
        viewModelScope.launch {
            movieRepository.getMovieListByType("popular").collect{
                when (it) {
                    is MovieState.Loading -> {
                        _homeState.update { homeUiState -> homeUiState.copy(popularMovie =MovieState.Loading ) }
                    }
                    is MovieState.Success -> {
                        _homeState.update { homeUiState -> homeUiState.copy(popularMovie = MovieState.Success(it.data) ) }
                    }
                    else -> {
                        _homeState.update { homeUiState -> homeUiState.copy(popularMovie =MovieState.Error("unknown") ) }
                    }
                }
            }
        }
    }

    private fun getUpComingMovieLists(){
        viewModelScope.launch {
            movieRepository.getMovieListByType("upcoming").collect{
                when (it) {
                    is MovieState.Loading -> {
                        _homeState.update { homeUiState -> homeUiState.copy(upComing =MovieState.Loading ) }
                    }
                    is MovieState.Success -> {
                        _homeState.update { homeUiState -> homeUiState.copy(upComing = MovieState.Success(it.data) ) }
                    }
                    else -> {
                        _homeState.update { homeUiState -> homeUiState.copy(upComing =MovieState.Error("unknown") ) }
                    }
                }
            }
        }
    }

    private fun getNowStreamingMovieLists(){
        viewModelScope.launch {
            movieRepository.getMovieListByType("now_playing").collect{
                when (it) {
                    is MovieState.Loading -> {
                        _homeState.update { homeUiState -> homeUiState.copy(nowStreaming =MovieState.Loading ) }
                    }
                    is MovieState.Success -> {
                        _homeState.update { homeUiState -> homeUiState.copy(nowStreaming = MovieState.Success(it.data) ) }
                    }
                    else -> {
                        _homeState.update { homeUiState -> homeUiState.copy(nowStreaming =MovieState.Error("unknown") ) }
                    }
                }
            }
        }
    }
    private fun getTrendingMovieLists(){
        viewModelScope.launch {
            movieRepository.getTrendingMovieList().collect{
                when (it) {
                    is MovieState.Loading -> {
                        _homeState.update { homeUiState -> homeUiState.copy(trending =MovieState.Loading ) }
                    }
                    is MovieState.Success -> {
                        _homeState.update { homeUiState -> homeUiState.copy(trending = MovieState.Success(it.data) ) }
                    }
                    else -> {
                        _homeState.update { homeUiState -> homeUiState.copy(trending =MovieState.Error("unknown") ) }
                    }
                }
            }
        }
    }
    private fun getOnTheAirMovieLists(){
        viewModelScope.launch {
            movieRepository.getOnTheAirTvList().collect{
                when (it) {
                    is MovieState.Loading -> {
                        _homeState.update { homeUiState -> homeUiState.copy(onTheAir =MovieState.Loading ) }
                    }
                    is MovieState.Success -> {
                        _homeState.update { homeUiState -> homeUiState.copy(onTheAir =MovieState.Success(it.data) ) }
                    }
                    else -> {
                        _homeState.update { homeUiState -> homeUiState.copy(onTheAir =MovieState.Error("unknown") ) }
                    }
                }
            }
        }
    }


}