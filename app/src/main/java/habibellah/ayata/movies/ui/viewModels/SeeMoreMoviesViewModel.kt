package habibellah.ayata.movies.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.domain.pagination.DefaultPagination
import habibellah.ayata.domain.entity.MovieResponse
import habibellah.ayata.domain.entity.TvShowsResponse
import habibellah.ayata.domain.useCase.GetMoviesUseCase
import habibellah.ayata.domain.useCase.MovieState
import habibellah.ayata.movies.ui.ShowType
import habibellah.ayata.movies.ui.screens.seeMoreMoviesScreen.SeeMoreMovieArgs
import habibellah.ayata.movies.ui.viewModels.states.MovieUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
@HiltViewModel
class SeeMoreMoviesViewModel @Inject constructor(
    private val getMoviesUseCase : GetMoviesUseCase,
    savedStateHandle : SavedStateHandle
) : ViewModel() {
    var state by mutableStateOf(ScreenState())
    private val args : SeeMoreMovieArgs = SeeMoreMovieArgs(savedStateHandle)
    private val pagination = DefaultPagination(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            if (args.filmType == ShowType.MOVIE) {
                getMoviesPagerType(nextPage)
            } else {
                getTvShowsPagerType(nextPage)
            }
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = { items, newKey ->
            val initItems : MutableList<MovieUiState> = mutableListOf()
            if (args.filmType == ShowType.MOVIE) {
                items.collect {
                    Handlers.handleMovieState(it as MovieState<MovieResponse?>)?.let { it1 ->
                        initItems.addAll(
                            it1
                        )
                    }
                    val movieItems = state.movieList + initItems
                    state = state.copy(
                        movieList = movieItems,
                        page = newKey,
                        endReached = movieItems.isEmpty()
                    )
                }
            } else {
                items.collect {
                    Handlers.handleTVState(it as MovieState<TvShowsResponse?>)?.let { it1 ->
                        initItems.addAll(
                            it1
                        )
                    }
                    val tvShowItems = state.movieList + initItems
                    state = state.copy(
                        movieList = tvShowItems,
                        page = newKey,
                        endReached = tvShowItems.isEmpty()
                    )
                }
            }
        }
    )

    private suspend fun getTvShowsPagerType(nextPage : Int) : Result<Flow<MovieState<TvShowsResponse?>>> {
        return getMoviesUseCase.getOnTheAirPager(nextPage)
    }

    private suspend fun getMoviesPagerType(nextPage : Int) : Result<Flow<MovieState<MovieResponse?>>> {
        return if (args.movieType == "trending") {
            getMoviesUseCase.getTrendingPager(page = nextPage)
        } else {
            getMoviesUseCase.getMoviesByTypePager(movieCategory = args.movieType, page = nextPage)
        }
    }

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            pagination.loadNextItems()
        }
    }
}

data class ScreenState(
    val isLoading : Boolean = false,
    val movieList : List<MovieUiState> = mutableListOf(),
    val error : String? = null,
    val endReached : Boolean = false,
    val page : Int = 1
)