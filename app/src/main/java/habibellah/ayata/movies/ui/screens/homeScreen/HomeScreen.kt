package habibellah.ayata.movies.ui.screens.homeScreen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import habibellah.ayata.movies.ui.composables.*
import habibellah.ayata.movies.ui.screens.movieDetailsScreen.navigateToMovieDetailsScreen
import habibellah.ayata.movies.ui.viewModels.HomeViewModel
import habibellah.ayata.movies.ui.viewModels.states.*

@Composable
fun HomeScreen(
    navController : NavController,
    viewModel : HomeViewModel = hiltViewModel(),
) {
    val homeState by viewModel.homeState.collectAsState()
    HomeScreenContent(homeState) { navController.navigateToMovieDetailsScreen(it!!) }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeScreenContent(homeState : HomeUiState, onClick : (id : Int?) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp, bottom = 50.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            PopularMovieLazyRow(homeState.popularMovie, onClick = { id ->
                onClick(id)
            })
        }
        stickyHeader {
            StickyHeader(headerText = "tv shows", null)
        }
//        item {
//            HandleTvShowItemState(popularTvShow = homeState.popularTvShow, onClick = { id ->
//                onClick(id)
//            })
//        }
        stickyHeader {
            StickyHeader(headerText = "trending", null)
        }
        item {
            TrendingLazyRow(homeState.trending, onClick = { id ->
                onClick(id)
            })
        }
        stickyHeader {
            StickyHeader(headerText = "on the air")
        }
        item {
            OnTheAirLazyRow(homeState.onTheAir, onClick = { id ->
                onClick(id)
            })
        }

        stickyHeader {
            StickyHeader(headerText = "now streaming")
        }
        item {
            NowStreamingLazyRow(homeState.nowStreaming, onClick = { id ->
                onClick(id)
            })
        }
        stickyHeader {
            StickyHeader(headerText = "up coming")
        }
        item {
            UpComingLazyRow(homeState.upComing, onClick = { id ->
                onClick(id)
            })
        }

        stickyHeader {
            StickyHeader(headerText = "Top Rated")
        }
        item {
            TopRatedLazyRow(homeState.topRated, onClick = { id ->
                onClick(id)
            })
        }
    }
}

@Composable
fun PopularMovieLazyRow(
    popularMovieState : MutableList<MovieUiState>?,
    onClick : (id : Int?) -> Unit
) {
    HandleStateForLazyRow(movieState = popularMovieState, onClick = { id ->
        onClick(id)
    }, modifier = Modifier.width(300.dp))
}

@Composable
fun TrendingLazyRow(trendingMovies : MutableList<MovieUiState>?, onClick : (id : Int?) -> Unit) {
    HandleStateForLazyRow(movieState = trendingMovies, onClick = { id ->
        onClick(id)
    })
}

@Composable
fun OnTheAirLazyRow(onTheAirState : MutableList<MovieUiState>?, onClick : (id : Int?) -> Unit) {
    HandleStateForLazyRow(movieState = onTheAirState, onClick = { id ->
        onClick(id)
    })
}

@Composable
fun NowStreamingLazyRow(
    nowStreamingState : MutableList<MovieUiState>?,
    onClick : (id : Int?) -> Unit
) {
    HandleStateForLazyRow(movieState = nowStreamingState, onClick = { id ->
        onClick(id)
    })
}

@Composable
fun UpComingLazyRow(upComingState : MutableList<MovieUiState>?, onClick : (id : Int?) -> Unit) {
    HandleStateForLazyRow(movieState = upComingState, onClick = { id ->
        onClick(id)
    })
}

@Composable
fun TopRatedLazyRow(topRated : MutableList<MovieUiState>?, onClick : (id : Int?) -> Unit) {
    HandleStateForLazyRow(movieState = topRated, onClick = { id ->
        onClick(id)
    })
}
