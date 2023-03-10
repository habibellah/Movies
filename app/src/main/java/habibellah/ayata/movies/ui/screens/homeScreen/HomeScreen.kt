package habibellah.ayata.movies.ui.screens.homeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import habibellah.ayata.movies.ui.ShowType
import habibellah.ayata.movies.ui.composables.*
import habibellah.ayata.movies.ui.screens.movieDetailsScreen.navigateToMovieDetailsScreen
import habibellah.ayata.movies.ui.screens.seeMoreMoviesScreen.navigateToSeeMoreMoviesScreen
import habibellah.ayata.movies.ui.viewModels.HomeViewModel
import habibellah.ayata.movies.ui.viewModels.states.*

@Composable
fun HomeScreen(
    navController : NavController,
    viewModel : HomeViewModel = hiltViewModel(),
) {
    val homeState by viewModel.homeState.collectAsState()
    HomeScreenContent(
        homeState,
        onSeeMoreMoviesClick = { movieType, filmType ->
            navController.navigateToSeeMoreMoviesScreen(
                movieType,
                filmType
            )
        },
        onClick = { id, filmType ->
            navController.navigateToMovieDetailsScreen(
                id!!,
                filmType
            )
        })
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeScreenContent(
    homeState : HomeUiState,
    onClick : (id : Int?, filmType : ShowType) -> Unit,
    onSeeMoreMoviesClick : (movieType : String, filmType : ShowType) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp, bottom = 50.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PopularMovieLazyRow(homeState.popularMovie, onClick = { id, filmType ->
                onClick(id, filmType)
            })
        }
        stickyHeader {
            Header(headerText = "Popular Tv Shows", null) {
                onSeeMoreMoviesClick("popular", ShowType.TV_SHOW)
            }
        }
        item {
            TvShowItemsState(
                popularTvShow = homeState.popularTvShow,
                onClick = { id, filmType ->
                    onClick(id, filmType)
                })
        }
        stickyHeader {
            Header(headerText = "Trending Movies", "see more") {
                onSeeMoreMoviesClick("trending", ShowType.MOVIE)
            }
        }
        item {
            TrendingLazyRow(homeState.trending, onClick = { id, filmType ->
                onClick(id, filmType)
            })
        }
        stickyHeader {
            Header(headerText = "On The Air Tv Show", "see more") {
                onSeeMoreMoviesClick("on_the_air", ShowType.TV_SHOW)
            }
        }
        item {
            OnTheAirLazyRow(homeState.onTheAir, onClick = { id, filmType ->
                onClick(id, filmType)
            })
        }

        stickyHeader {
            Header(headerText = "Now Streaming Movies", "see more") {
                onSeeMoreMoviesClick("now_playing", ShowType.MOVIE)
            }
        }
        item {
            NowStreamingLazyRow(homeState.nowStreaming, onClick = { id, filmType ->
                onClick(id, filmType)
            })
        }
        stickyHeader {
            Header(headerText = "Up Coming Movies", "see more") {
                onSeeMoreMoviesClick("upcoming", ShowType.MOVIE)
            }
        }
        item {
            UpComingLazyRow(homeState.upComing, onClick = { id, filmType ->
                onClick(id, filmType)
            })
        }

        stickyHeader {
            Header(headerText = "Top Rated Movies", "see more") {
                onSeeMoreMoviesClick("top_rated", ShowType.MOVIE)
            }
        }
        item {
            TopRatedLazyRow(homeState.topRated, onClick = { id, filmType ->
                onClick(id, filmType)
            })
        }
    }
}

@Composable
fun PopularMovieLazyRow(
    popularMovieState : MutableList<MovieUiState>?,
    onClick : (id : Int?, filmType : ShowType) -> Unit
) {
    LazyRowState(movieState = popularMovieState, onClick = { id, filmType ->
        onClick(id, filmType)
    }, modifier = Modifier.width(300.dp))
}

@Composable
fun TrendingLazyRow(
    trendingMovies : MutableList<MovieUiState>?,
    onClick : (id : Int?, filmType : ShowType) -> Unit
) {
    LazyRowState(movieState = trendingMovies, onClick = { id, filmType ->
        onClick(id, filmType)
    })
}

@Composable
fun OnTheAirLazyRow(
    onTheAirState : MutableList<MovieUiState>?,
    onClick : (id : Int?, filmType : ShowType) -> Unit
) {
    LazyRowState(movieState = onTheAirState, onClick = { id, filmType ->
        onClick(id, filmType)
    })
}

@Composable
fun NowStreamingLazyRow(
    nowStreamingState : MutableList<MovieUiState>?,
    onClick : (id : Int?, filmType : ShowType) -> Unit
) {
    LazyRowState(movieState = nowStreamingState, onClick = { id, filmType ->
        onClick(id, filmType)
    })
}

@Composable
fun UpComingLazyRow(
    upComingState : MutableList<MovieUiState>?,
    onClick : (id : Int?, filmType : ShowType) -> Unit
) {
    LazyRowState(movieState = upComingState, onClick = { id, filmType ->
        onClick(id, filmType)
    })
}

@Composable
fun TopRatedLazyRow(
    topRated : MutableList<MovieUiState>?,
    onClick : (id : Int?, filmType : ShowType) -> Unit
) {
    LazyRowState(movieState = topRated, onClick = { id, filmType ->
        onClick(id, filmType)
    })
}
