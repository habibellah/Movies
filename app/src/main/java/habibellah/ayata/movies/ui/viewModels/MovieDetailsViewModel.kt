package habibellah.ayata.movies.ui.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.domain.useCase.GetMovies
import habibellah.ayata.movies.ui.screens.movieDetailsScreen.MovieDetailsArgs
import habibellah.ayata.movies.ui.viewModels.states.MovieDetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
  private val getMovies: GetMovies,
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

          getMovies.getMovieDetails(args.id).collect{
                when (it) {
                    is habibellah.ayata.domain.repositories.MovieState.Loading -> {
                    }
                    is habibellah.ayata.domain.repositories.MovieState.Success -> {
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