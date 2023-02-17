package habibellah.ayata.movies.ui.viewModels.states

data class MovieDetailsUiState(
    val movieTitle: String? = null,
    val imagePath : String? = null,
    val overView : String? = null,
    val actorsList : List<Actor>? = null
)

data class Actor(val name : String,val imagePath: String?)