package habibellah.ayata.movies.ui.viewModels

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.movies.data.repositories.MovieRepository
import habibellah.ayata.movies.data.repositories.MovieState
import habibellah.ayata.movies.ui.screens.movieDetailsScreen.MovieDetailsArgs
import habibellah.ayata.movies.ui.viewModels.states.MovieDetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    savedStateHandle: SavedStateHandle
    ): ViewModel() {

   private val _movieDetailsUiState = MutableStateFlow(MovieDetailsUiState())
    val  movieDetailsUiState = _movieDetailsUiState.asStateFlow()

    private val args : MovieDetailsArgs = MovieDetailsArgs(savedStateHandle)

    init {
        getMovieDetails()
    }
   private fun getMovieDetails(){
        viewModelScope.launch {

          movieRepository.getMovieDetails(args.id).collect{
                when (it) {
                    is MovieState.Loading -> {
                    }
                    is MovieState.Success -> {
                        _movieDetailsUiState.update { movieDetailsUiState ->
                            movieDetailsUiState.copy(
                                movieTitle = it.data?.title,
                                overView = it.data?.overview,
                                imagePath = it.data?.posterPath
                            )
                        }
                    }
                    else -> {
                    }
                }

            }
        }
    }
}