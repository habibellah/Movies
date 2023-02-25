package habibellah.ayata.movies.ui.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.domain.entity.Genre
import habibellah.ayata.domain.entity.GenreX
import habibellah.ayata.domain.useCase.GetMoviesUseCase
import habibellah.ayata.domain.useCase.MovieState
import habibellah.ayata.movies.ui.ShowType
import habibellah.ayata.movies.ui.screens.movieDetailsScreen.MovieDetailsArgs
import habibellah.ayata.movies.ui.viewModels.states.MovieDetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    savedStateHandle: SavedStateHandle
    ): ViewModel() {

   private val _movieDetailsUiState = MutableStateFlow(MovieDetailsUiState())
    val  movieDetailsUiState = _movieDetailsUiState.asStateFlow()

    private val args : MovieDetailsArgs = MovieDetailsArgs(savedStateHandle)

    init {
        getDetailsController()
    }

    private fun getDetailsController(){
        if (args.filmType == ShowType.TV_SHOW){
            getTvShowDetails()
        }else{
            getMovieDetails()
        }
    }
   private fun getMovieDetails(){
        viewModelScope.launch {
          getMoviesUseCase.getMovieDetails(args.id).collect{
                when (it) {
                    is MovieState.Loading -> {
                    }
                    is MovieState.Success -> {
                        _movieDetailsUiState.update { movieDetailsUiState ->
                            movieDetailsUiState.copy(
                                movieTitle = it.data?.title,
                                overView = it.data?.overview,
                                imagePath = it.data?.posterPath,
                                releaseDate = it.data?.releaseDate,
                                genre = returnGenres(it.data?.genres),
                                voteAverage = it.data?.voteAverage,
                                voteCount = it.data?.voteCount
                            )
                        }
                    }
                    else -> {
                    }
                }

            }
        }
    }

    private fun getTvShowDetails(){
        viewModelScope.launch {
            getMoviesUseCase.getTvShowDetails(args.id).collect{
                when (it) {
                    is MovieState.Loading -> {
                    }
                    is MovieState.Success -> {
                        _movieDetailsUiState.update { movieDetailsUiState ->
                            movieDetailsUiState.copy(
                                movieTitle = it.data?.name,
                                overView = it.data?.overview,
                                imagePath = it.data?.posterPath,
                                releaseDate = it.data?.firstAirDate,
                                genre = returnGenresX(it.data?.genres),
                                voteAverage = it.data?.voteAverage,
                                voteCount = it.data?.voteCount
                            )
                        }
                    }
                    else -> {
                    }
                }

            }
        }
    }

    private fun returnGenres(genres : List<Genre?>?):String{
        var allGenres : String? = ""
        genres?.forEach{
            if (it != null) {
                allGenres="${allGenres},${it.name}"
            }
        }
        return allGenres.toString()
    }

    private fun returnGenresX(genres : List<GenreX?>?):String{
        var allGenres : String? = ""
        genres?.forEach{
            if (it != null) {
                allGenres="${allGenres},${it.name}"
            }
        }
        return allGenres.toString()
    }
}