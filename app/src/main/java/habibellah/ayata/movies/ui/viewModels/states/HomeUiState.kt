package habibellah.ayata.movies.ui.viewModels.states

data class HomeUiState(
    val popularMovie: List<PopularMovieUiState> = emptyList(),
    val tvShow: List<TvShowsUiState> = emptyList(),
    val onTheAir: List<OnTheAirUiState> = emptyList(),
    val trending: List<TrendingUiState> = emptyList(),
    val airingToday: List<AiringTodayUiState> = emptyList(),
    val nowStreaming: List<NowStreamingUiState> = emptyList(),
    val upComing: List<UpComingUiState> = emptyList(),
    val myStery: List<MySteryUiState> = emptyList(),

    )

open class MovieUiState(
    open val categoryName: String? = null,
    open val imageUrl: String? = null
)

data class PopularMovieUiState(override val categoryName: String?, override val imageUrl: String?) : MovieUiState(categoryName = categoryName, imageUrl = imageUrl)

data class TvShowsUiState(override val categoryName: String?, override val imageUrl: String?) : MovieUiState(categoryName = categoryName, imageUrl = imageUrl)

data class OnTheAirUiState(override val categoryName: String?, override val imageUrl: String?) : MovieUiState(categoryName = categoryName, imageUrl = imageUrl)

data class TrendingUiState(override val categoryName: String?, override val imageUrl: String?) : MovieUiState(categoryName = categoryName, imageUrl = imageUrl)

data class AiringTodayUiState(override val categoryName: String?, override val imageUrl: String?) : MovieUiState(categoryName = categoryName, imageUrl = imageUrl)

data class NowStreamingUiState(override val categoryName: String?, override val imageUrl: String?) : MovieUiState(categoryName = categoryName, imageUrl = imageUrl)

data class UpComingUiState(override val categoryName: String?, override val imageUrl: String?) : MovieUiState(categoryName = categoryName, imageUrl = imageUrl)

data class MySteryUiState(override val categoryName: String?, override val imageUrl: String?) : MovieUiState(categoryName = categoryName, imageUrl = imageUrl)