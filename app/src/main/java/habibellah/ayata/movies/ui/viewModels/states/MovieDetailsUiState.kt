package habibellah.ayata.movies.ui.viewModels.states

data class MovieDetailsUiState(
    val movieTitle : String? = null,
    val imagePath : String? = null,
    val overView : String? = null,
    val releaseDate : String? = null,
    val genre : String? = null,
    val voteAverage : Double? = null,
    val voteCount : Int? = null,
    val actorsList : MutableList<Actor>? = mutableListOf(),
    val similarMovieList : MutableList<SimilarMovie>? = mutableListOf(),
    val reviewsList : MutableList<Review>? = mutableListOf()
)

data class Actor(
    val name : String? = null,
    val image : String? = null
)

data class SimilarMovie(
    val image : String? = null
)

data class Review(
    val author : String? = null,
    val userName : String? = null,
    val rating : Int? = null,
    val avatarPath : String? = null,
    val reviewContent : String? = null,
    )

