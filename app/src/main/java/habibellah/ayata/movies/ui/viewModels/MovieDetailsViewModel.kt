package habibellah.ayata.movies.ui.viewModels

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.domain.entity.*
import habibellah.ayata.domain.useCase.GetActorsUseCase
import habibellah.ayata.domain.useCase.GetMoviesUseCase
import habibellah.ayata.domain.useCase.MovieState
import habibellah.ayata.movies.ui.ShowType
import habibellah.ayata.movies.ui.screens.movieDetailsScreen.MovieDetailsArgs
import habibellah.ayata.movies.ui.viewModels.states.Actor
import habibellah.ayata.movies.ui.viewModels.states.MovieDetailsUiState
import habibellah.ayata.movies.ui.viewModels.states.Review
import habibellah.ayata.movies.ui.viewModels.states.SimilarMovie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMoviesUseCase : GetMoviesUseCase,
    private val getActorsUseCase : GetActorsUseCase,
    savedStateHandle : SavedStateHandle
) : ViewModel() {
    private val _movieDetailsUiState = MutableStateFlow(MovieDetailsUiState())
    val movieDetailsUiState = _movieDetailsUiState.asStateFlow()
    private val args : MovieDetailsArgs = MovieDetailsArgs(savedStateHandle)

    init {

        getDetailsController()
    }

    private fun getDetailsController() {
        if (args.filmType == ShowType.TV_SHOW) {
            getTvShowDetails()
            getTvShowActorsList()
            getSimilarTvShow()
            getTvShowReviews()
        } else {
            getMovieDetails()
            getMovieActorsList()
            getSimilarMovie()
            getMovieReviews()
        }
    }

    private fun getMovieDetails() {
        viewModelScope.launch {
            getMoviesUseCase.getMovieDetails(args.id).collect {
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

    private fun getTvShowDetails() {
        viewModelScope.launch {
            getMoviesUseCase.getTvShowDetails(args.id).collect {
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

    private fun returnGenres(genres : List<Genre?>?) : String {
        var allGenres : String? = ""
        genres?.forEach {
            if (it != null) {
                allGenres = "${allGenres},${it.name}"
            }
        }
        return allGenres.toString()
    }

    private fun getMovieActorsList() {
        viewModelScope.launch {
            getActorsUseCase.getMovieActorsList(args.id).collect {
                _movieDetailsUiState.update { movieDetailsUiState ->
                    movieDetailsUiState.copy(
                        actorsList = handleMovieActorState(it)
                    )
                }
            }
        }
    }

    private fun getTvShowActorsList() {
        viewModelScope.launch {
            getActorsUseCase.getTvShowActorsList(args.id).collect {
                _movieDetailsUiState.update { movieDetailsUiState ->
                    movieDetailsUiState.copy(
                        actorsList = handleTvShowActorList(it)
                    )
                }
            }
        }
    }

    private fun handleMovieActorState(movieState : MovieState<MovieActorsResponse?>) : MutableList<Actor>? {
        return when (movieState) {
            is MovieState.Loading -> {
                mutableListOf()
            }
            is MovieState.Success -> {
                toActorsList(movieState.data?.cast)
            }
            else -> {
                null
            }
        }
    }

    private fun handleTvShowActorList(movieState : MovieState<TvShowActorResponse?>) : MutableList<Actor>? {
        return when (movieState) {
            is MovieState.Loading -> {
                mutableListOf()
            }
            is MovieState.Success -> {
                toTvShowActorsList(movieState.data?.cast)
            }
            else -> {
                null
            }
        }
    }

    private fun toActorsList(cast : List<Cast?>?) : MutableList<Actor>? {
        return cast?.map {
            Actor(it?.name, it?.profilePath)
        }?.toMutableList()
    }

    private fun toTvShowActorsList(cast : List<CastX?>?) : MutableList<Actor>? {
        return cast?.map {
            Actor(it?.name, it?.profilePath)
        }?.toMutableList()
    }

    private fun getSimilarMovie() {
        viewModelScope.launch {
            getMoviesUseCase.getSimilarMovies(args.id).collect {
                _movieDetailsUiState.update { movieDetailsUiState ->
                    movieDetailsUiState.copy(
                        similarMovieList = handleSimilarMovieState(it)
                    )
                }
            }
        }
    }

    private fun handleSimilarMovieState(movieState : MovieState<SimilarMoviesResponse?>) : MutableList<SimilarMovie>? {
        return when (movieState) {
            is MovieState.Loading -> {
                mutableListOf()
            }
            is MovieState.Success -> {
                toSimilarMovie(movieState.data?.results)
            }
            else -> {
                null
            }
        }
    }

    private fun toSimilarMovie(cast : List<Result?>?) : MutableList<SimilarMovie>? {
        return cast?.map {
            SimilarMovie(it?.posterPath)
        }?.toMutableList()
    }

    private fun getSimilarTvShow() {
        viewModelScope.launch {
            getMoviesUseCase.getSimilarTvShows(args.id).collect {
                _movieDetailsUiState.update { movieDetailsUiState ->
                    movieDetailsUiState.copy(
                        similarMovieList = handleSimilarTvShowState(it)
                    )
                }
            }
        }
    }

    private fun handleSimilarTvShowState(movieState : MovieState<SimilarTvShowResponse?>) : MutableList<SimilarMovie>? {
        return when (movieState) {
            is MovieState.Loading -> {
                mutableListOf()
            }
            is MovieState.Success -> {
                toSimilarTvShow(movieState.data?.results)
            }
            else -> {
                null
            }
        }
    }

    private fun toSimilarTvShow(cast : List<ResultX?>?) : MutableList<SimilarMovie>? {
        return cast?.map {
            SimilarMovie(it?.posterPath)
        }?.toMutableList()
    }

    private fun getMovieReviews() {
        viewModelScope.launch {
            getMoviesUseCase.getMovieReview(args.id).collect {
                _movieDetailsUiState.update { movieDetailsUiState ->
                    movieDetailsUiState.copy(
                        reviewsList = handleMovieReviewsState(it)
                    )
                }
            }
        }
    }

    private fun handleMovieReviewsState(movieState : MovieState<MovieReviewResponse?>) : MutableList<Review>? {
        return when (movieState) {
            is MovieState.Loading -> {
                mutableListOf()
            }
            is MovieState.Success -> {
                toMovieReviews(movieState.data)
            }
            else -> {
                null
            }
        }
    }

    private fun toMovieReviews(movieReviewResponse : MovieReviewResponse?) : MutableList<Review>? {
        return movieReviewResponse?.results?.map {
            Review(
                author = it.author,
                userName = it.authorDetails?.username,
                rating = it.authorDetails?.rating?.toInt(),
                avatarPath = it.authorDetails?.avatarPath,
                reviewContent = it.content
            )
        }?.toMutableList()
    }

    private fun getTvShowReviews() {
        viewModelScope.launch {
            getMoviesUseCase.getTvShowReview(args.id).collect {
                _movieDetailsUiState.update { movieDetailsUiState ->
                    movieDetailsUiState.copy(
                        reviewsList = handleTvShowReviewsState(it)
                    )
                }
            }
        }
    }

    private fun handleTvShowReviewsState(movieState : MovieState<TvShowReviewResponse?>) : MutableList<Review>? {
        return when (movieState) {
            is MovieState.Loading -> {
                mutableListOf()
            }
            is MovieState.Success -> {
                toTvShowReviews(movieState.data)
            }
            else -> {
                null
            }
        }
    }

    private fun toTvShowReviews(tvShowReviewResponse : TvShowReviewResponse?) : MutableList<Review>? {
        return tvShowReviewResponse?.results?.map {
            Review(
                author = it.author,
                userName = it.authorDetails?.username,
                rating = it.authorDetails?.rating?.toInt(),
                avatarPath = it.authorDetails?.avatarPath,
                reviewContent = it.content
            )
        }?.toMutableList()
    }
}

