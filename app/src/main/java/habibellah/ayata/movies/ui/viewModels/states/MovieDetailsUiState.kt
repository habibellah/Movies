package habibellah.ayata.movies.ui.viewModels.states

data class MovieDetailsUiState(
    val movieTitle : String? = null,
    val imagePath : String? = null,
    val overView : String? = null,
    val releaseDate : String? = null,
    val genre : String? = null,
    val voteAverage : Double? = null,
    val voteCount : Int? = null
)

