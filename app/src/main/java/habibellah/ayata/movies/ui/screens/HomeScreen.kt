@file:OptIn(ExperimentalFoundationApi::class)

package habibellah.ayata.movies.ui.screens


import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import habibellah.ayata.movies.data.movieDataSource.movieApi.MovieResponse
import habibellah.ayata.movies.data.repositories.MovieState
import habibellah.ayata.movies.ui.composables.LoadingMovieLists
import habibellah.ayata.movies.ui.composables.MovieItem
import habibellah.ayata.movies.ui.composables.StickyHeader
import habibellah.ayata.movies.ui.viewModels.HomeViewModel
import habibellah.ayata.movies.ui.viewModels.states.*


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    ){
    val homeState by viewModel.homeState.collectAsState()
    HomeScreenContent(homeState)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeScreenContent(homeState : HomeUiState) {
    LazyColumn (modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp, bottom = 50.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
             item { PopularMovieLazyRow(homeState.popularMovie) }
             stickyHeader {
                 StickyHeader(headerText = "trending",null)
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
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        when (popularMovieState) {
            is MovieState.Loading -> {
                item { LoadingMovieLists() }
            }
            is MovieState.Success -> {
                items(toMovieList(popularMovieState.data)) {
                    MovieItem(
                        movieState = it, modifier = Modifier
                            .fillMaxWidth()
                            .width(300.dp), 1
                    )
                }
            }
            else -> {
                item {
                    MovieItem(
                        movieState = MovieUiState(categoryName = "loading", imageUrl = ""),
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(300.dp),
                        3
                    )
                }
            }
        }
    }
}

    @Composable
    fun TrendingLazyGrid(tvShowsState: MovieState<MovieResponse?>?){
        LazyVerticalGrid(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Fixed(2),
            content = {
                when (tvShowsState) {
                    is MovieState.Loading -> {
                        item { LoadingMovieLists() }
                    }
                    is MovieState.Success -> {
                        items(toMovieList(tvShowsState.data).subList(0,4)) {
                            MovieItem(
                                movieState = it, modifier = Modifier
                                    .fillMaxWidth()
                                    .width(300.dp), 1
                            )
                        }
                    }
                    else -> {
                        item {
                            MovieItem(
                                movieState = MovieUiState(categoryName = "loading", imageUrl = ""),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .width(300.dp),
                                3
                            )
                        }
                    }
                }
            },
            modifier = Modifier.height(350.dp)
        )
    }

    @Composable
    fun OnTheAirLazyRow(onTheAirState:MovieState<MovieResponse?>?){
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        when (onTheAirState) {
            is MovieState.Loading -> {
                item { LoadingMovieLists() }
            }
            is MovieState.Success -> {
                items(toMovieList(onTheAirState.data)) {
                    MovieItem(
                        movieState = it, modifier = Modifier
                            .fillMaxWidth()
                            .width(300.dp), 1
                    )
                }
            }
            else -> {
                item {
                    MovieItem(
                        movieState = MovieUiState(categoryName = "loading", imageUrl = ""),
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(300.dp),
                        3
                    )
                }
            }
        }
    }
}


    @Composable
    fun NowStreamingLazyRow(nowStreamingState: MovieState<MovieResponse?>?){
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        when (nowStreamingState) {
            is MovieState.Loading -> {
                item { LoadingMovieLists() }
            }
            is MovieState.Success -> {
                items(toMovieList(nowStreamingState.data)) {
                    MovieItem(
                        movieState = it, modifier = Modifier
                            .fillMaxWidth()
                            .width(300.dp), 1
                    )
                }
            }
            else -> {
                item {
                    MovieItem(
                        movieState = MovieUiState(categoryName = "loading", imageUrl = ""),
                        modifier = Modifier
                            .fillMaxWidth()
                            .width(300.dp),
                        3
                    )
                }
            }
        }
    }
    }

    @Composable
    fun UpComingLazyRow(upComingState: MovieState<MovieResponse?>?){
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            when (upComingState) {
                is MovieState.Loading -> {
                    item { LoadingMovieLists() }
                }
                is MovieState.Success -> {
                    items(toMovieList(upComingState.data)) {
                        MovieItem(
                            movieState = it, modifier = Modifier
                                .fillMaxWidth()
                                .width(300.dp), 1
                        )
                    }
                }
                else -> {
                    item {
                        MovieItem(
                            movieState = MovieUiState(categoryName = "loading", imageUrl = ""),
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(300.dp),
                            3
                        )
                    }
                }
            }
        }
    }

private fun toMovieList(data: MovieResponse?): List<MovieUiState> {
    val movieList = ArrayList<MovieUiState>()
    for(i in 0 until data?.results!!.size){
        movieList.add(MovieUiState(categoryName = data.results[i]?.originalTitle, imageUrl = "https://image.tmdb.org/t/p/w500${data.results[i]?.posterPath}"))
    }
    return  movieList
}