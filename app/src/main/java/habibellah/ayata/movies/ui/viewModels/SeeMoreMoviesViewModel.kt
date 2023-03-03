package habibellah.ayata.movies.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.domain.DefaultPaginator
import habibellah.ayata.domain.entity.MovieResponsePager
import habibellah.ayata.domain.entity.Result
import habibellah.ayata.domain.useCase.GetMoviesUseCase
import habibellah.ayata.domain.useCase.MovieState
import habibellah.ayata.movies.ui.ShowType
import habibellah.ayata.movies.ui.screens.seeMoreMoviesScreen.SeeMoreMovieArgs
import habibellah.ayata.movies.ui.viewModels.states.MovieUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeeMoreMoviesViewModel @Inject constructor(
    private val getMoviesUseCase : GetMoviesUseCase,
    savedStateHandle : SavedStateHandle
) : ViewModel() {
    var state by mutableStateOf(ScreenState())
    private val args : SeeMoreMovieArgs = SeeMoreMovieArgs(savedStateHandle)
    private val paginator = DefaultPaginator(
        initialKey = state.page,
        onLoadUpdated = {
            state = state.copy(isLoading = it)
        },
        onRequest = { nextPage ->
            getMoviesUseCase.getMoviesByTypePager(movieCategory = args.movieType, page = nextPage)
        },
        getNextKey = {
            state.page + 1
        },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = { items, newKey ->
            items.collect {
                val itemsaaa : MutableList<MovieUiState> = mutableListOf()
                handleMovieState(it)?.let { it1 -> itemsaaa.addAll(it1) }
                val itemsaa = state.movieList + itemsaaa
                state = state.copy(
                    movieList = itemsaa,
                    page = newKey,
                    endReached = itemsaa.isEmpty()
                )
            }
        }
    )

    init {
        loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

    private fun toMovieList(results : List<Result?>?) : List<MovieUiState>? {
        return results?.map {
            MovieUiState(
                it?.title, "https://image.tmdb.org/t/p/w500${it?.posterPath}", it?.id,
                ShowType.MOVIE
            )
        }?.toList()
    }

    private fun handleMovieState(movieState : MovieState<MovieResponsePager?>) : List<MovieUiState>? {
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
}

data class ScreenState(
    val isLoading : Boolean = false,
    val movieList : List<MovieUiState> = mutableListOf(),
    val error : String? = null,
    val endReached : Boolean = false,
    val page : Int = 1
)