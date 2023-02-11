@file:OptIn(ExperimentalFoundationApi::class)

package habibellah.ayata.movies.ui.screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import habibellah.ayata.movies.data.movieDataSource.movieApi.MovieResponse
import habibellah.ayata.movies.data.repositories.MovieState
import habibellah.ayata.movies.ui.composables.*
import habibellah.ayata.movies.ui.viewModels.HomeViewModel
import habibellah.ayata.movies.ui.viewModels.states.*


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val homeState by viewModel.homeState.collectAsState()
    HomeScreenContent(homeState)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeScreenContent(homeState: HomeUiState) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp, bottom = 50.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { PopularMovieLazyRow(homeState.popularMovie) }
        stickyHeader {
            StickyHeader(headerText = "trending", null)
        }
        item { TrendingLazyGrid(homeState.trending) }
        stickyHeader {
            StickyHeader(headerText = "on the air")
        }
        item { OnTheAirLazyRow(homeState.onTheAir) }

        stickyHeader {
            StickyHeader(headerText = "now streaming")
        }
        item { NowStreamingLazyRow(homeState.nowStreaming) }
        stickyHeader {
            StickyHeader(headerText = "up coming")
        }
        item { UpComingLazyRow(homeState.upComing) }
    }
}

@Composable
fun PopularMovieLazyRow(popularMovieState: MovieState<MovieResponse?>?) {
    HandleStateForLazyRow(movieState = popularMovieState)
}

@Composable
fun TrendingLazyGrid(tvShowsState: MovieState<MovieResponse?>?) {
    HandleStateForLazyGrid(movieState = tvShowsState)
}

@Composable
fun OnTheAirLazyRow(onTheAirState: MovieState<MovieResponse?>?) {
    HandleStateForLazyRow(movieState = onTheAirState)
}


@Composable
fun NowStreamingLazyRow(nowStreamingState: MovieState<MovieResponse?>?) {
    HandleStateForLazyRow(movieState = nowStreamingState)
}

@Composable
fun UpComingLazyRow(upComingState: MovieState<MovieResponse?>?) {
    HandleStateForLazyRow(movieState = upComingState)
}
