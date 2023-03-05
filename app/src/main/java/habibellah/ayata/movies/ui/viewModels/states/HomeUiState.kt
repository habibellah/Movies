package habibellah.ayata.movies.ui.viewModels.states

import habibellah.ayata.movies.ui.ShowType

data class HomeUiState(
    val popularMovie : MutableList<MovieUiState>? = mutableListOf(),
    val onTheAir : MutableList<MovieUiState>? = mutableListOf(),
    val trending : MutableList<MovieUiState>? = mutableListOf(),
    val nowStreaming : MutableList<MovieUiState>? = mutableListOf(),
    val upComing : MutableList<MovieUiState>? = mutableListOf(),
    val topRated : MutableList<MovieUiState>? = mutableListOf(),
    val popularTvShow : MutableList<MovieUiState>? = mutableListOf(),
)

class MovieUiState(
    val movieName : String? = null,
    val imageUrl : String? = null,
    val id : Int? = null,
    val type : ShowType
)
