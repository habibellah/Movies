@file:OptIn(ExperimentalFoundationApi::class)

package habibellah.ayata.movies.ui.screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import habibellah.ayata.movies.ui.composables.MovieItem
import habibellah.ayata.movies.ui.viewModels.HomeViewModel
import habibellah.ayata.movies.ui.viewModels.states.*


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    ){
    val homeState by viewModel.homeState.collectAsState()
    HomeScreenContent(homeState)
}

@Composable
private fun HomeScreenContent(homeState : HomeUiState) {
    LazyColumn {
        item { PopularMovieLazyRow(homeState.popularMovie) }
        item { TvShowsLazyGrid(homeState.tvShow) }
        item { OnTheAirLazyRow(homeState.onTheAir) }
        item { TrendingLazyRow(homeState.trending) }
        item { AiringTodayLazyGrid(homeState.airingToday) }
        item { NowStreamingLazyRow(homeState.nowStreaming) }
        item { UpComingLazyRow(homeState.upComing) }
        item { MySteryLazyRow(homeState.myStery) }
    }
}
    @Composable
    fun PopularMovieLazyRow(popularMovieState : List<PopularMovieUiState>){
      LazyRow(){
      }
    }

    @Composable
    fun TvShowsLazyGrid(tvShowsState: List<TvShowsUiState>){
//        LazyVerticalGrid(){
//
//        }
    }

    @Composable
    fun OnTheAirLazyRow(onTheAirState: List<OnTheAirUiState>){
        LazyRow(){

        }
    }

    @Composable
    fun TrendingLazyRow(trendingState: List<TrendingUiState>){
        LazyRow(){

        }
    }

    @Composable
    fun AiringTodayLazyGrid(airingTodayState: List<AiringTodayUiState>){
//    LazyVerticalGrid(){
//
//    }
    }

    @Composable
    fun NowStreamingLazyRow(nowStreamingState: List<NowStreamingUiState>){
        LazyRow(){

        }
    }

    @Composable
    fun UpComingLazyRow(upComingState: List<UpComingUiState>){
        LazyRow(){

        }
    }

   @Composable
   fun MySteryLazyRow(mySteryState: List<MySteryUiState>) {
       LazyRow(){

       }
   }

