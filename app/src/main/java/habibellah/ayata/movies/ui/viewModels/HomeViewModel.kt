package habibellah.ayata.movies.ui.viewModels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.movies.ui.viewModels.states.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(){
    private val _homeState = MutableStateFlow(HomeUiState())
    val homeState = _homeState.asStateFlow()

    init {
        getMovieLists()
    }
    private fun getMovieLists(){
        _homeState.update {
            it.copy(
                popularMovie = listOf(
                    PopularMovieUiState("sss","https://trailers.apple.com/trailers/sony_pictures/65/images/poster_2x.jpg"),
                    PopularMovieUiState("sss","https://trailers.apple.com/trailers/sony_pictures/65/images/poster_2x.jpg"),
                    PopularMovieUiState("sss","https://trailers.apple.com/trailers/sony_pictures/65/images/poster_2x.jpg"),
                    PopularMovieUiState("sss","https://trailers.apple.com/trailers/sony_pictures/65/images/poster_2x.jpg"),
                    PopularMovieUiState("sss","https://trailers.apple.com/trailers/sony_pictures/65/images/poster_2x.jpg"),
                    PopularMovieUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    PopularMovieUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    PopularMovieUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    PopularMovieUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    PopularMovieUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    PopularMovieUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    PopularMovieUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    PopularMovieUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    PopularMovieUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),

                ),
                tvShow =  listOf(
                    TvShowsUiState("sss","https://i.ytimg.com/vi/ubrquR6i0WQ/maxresdefault.jpg"),
                    TvShowsUiState("sss","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRL-ci3_PtUVqYWsOUNKLkvS9_QNyiVCMU6t9MUVatzfwLHrwnGISCgad9M3J58VJFkpkM&usqp=CAU"),
                    ),
                onTheAir =  listOf(
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    OnTheAirUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),

                    ),
                trending =  listOf(
                    TrendingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    TrendingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    TrendingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    TrendingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    TrendingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    TrendingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    TrendingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    TrendingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    TrendingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    TrendingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),

                ),
                airingToday =  listOf(
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    AiringTodayUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),

                ),
                nowStreaming =  listOf(
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    NowStreamingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),

                ),
                upComing =  listOf(
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    UpComingUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),

                ),
                myStery =  listOf(
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),
                    MySteryUiState("sss","https://media.gettyimages.com/id/1244034031/fr/vectoriel/affiche-de-cin%C3%A9ma-avec-cola-bande-de-film-et-clapper-vecteur.jpg?s=612x612&w=gi&k=20&c=v2-GDgkx8f1HeJrmi_k9fLj76Fou7ByaHwQ08hBvFls="),

                ),
            )
        }
    }
}