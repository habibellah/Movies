@file:OptIn(ExperimentalFoundationApi::class)

package habibellah.ayata.movies.ui.screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
            StickyHeader(headerText = "tv shows",null)
        }
        item { TvShowsLazyGrid(homeState.tvShow) }
        stickyHeader {
            StickyHeader(headerText = "on the air")
        }
        item { OnTheAirLazyRow(homeState.onTheAir) }
        stickyHeader {
            StickyHeader(headerText = "trending")

        }
        item { TrendingLazyRow(homeState.trending) }
        stickyHeader {
            StickyHeader(headerText = "airign today")
        }
        item { AiringTodayLazyGrid(homeState.airingToday) }
        stickyHeader {
            StickyHeader(headerText = "now streaming")
        }
        item { NowStreamingLazyRow(homeState.nowStreaming) }
        stickyHeader {
            StickyHeader(headerText = "up coming")
        }
        item { UpComingLazyRow(homeState.upComing) }
        stickyHeader {
            StickyHeader(headerText = "my stery")
        }
        item { MySteryLazyRow(homeState.myStery) }
    }
}
    @Composable
    fun PopularMovieLazyRow(popularMovieState : List<PopularMovieUiState>){
      LazyRow(
      contentPadding = PaddingValues(16.dp),
          horizontalArrangement = Arrangement.spacedBy(16.dp)
      ){
          items(popularMovieState){
              MovieItem(movieState = it, modifier = Modifier
                  .fillMaxWidth()
                  .width(300.dp))
          }
      }
    }

    @Composable
    fun TvShowsLazyGrid(tvShowsState: List<TvShowsUiState>){
        LazyVerticalGrid(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Fixed(2),
            content = {
                item(span = {GridItemSpan(2)}){
                    MovieItem(movieState = tvShowsState[0],modifier = Modifier.fillMaxWidth())
                }
                items(tvShowsState){
                 MovieItem(movieState = it)
                }
            },
            modifier = Modifier.height(350.dp)
        )
    }

    @Composable
    fun OnTheAirLazyRow(onTheAirState: List<OnTheAirUiState>){
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(onTheAirState){
                MovieItem(movieState = it)
            }
        }
    }

    @Composable
    fun TrendingLazyRow(trendingState: List<TrendingUiState>){
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(trendingState){
                MovieItem(movieState = it)
            }
        }
    }

    @Composable
    fun AiringTodayLazyGrid(airingTodayState: List<AiringTodayUiState>){
        LazyVerticalGrid(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Fixed(3),
            modifier = Modifier.height(150.dp)
        ){
            items(airingTodayState){
                MovieItem(movieState = it)
            }
        }
    }

    @Composable
    fun NowStreamingLazyRow(nowStreamingState: List<NowStreamingUiState>){
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(nowStreamingState){
                MovieItem(movieState = it)
            }
        }
    }

    @Composable
    fun UpComingLazyRow(upComingState: List<UpComingUiState>){
        LazyRow(
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            items(upComingState){
                MovieItem(movieState = it)
            }
        }
    }

   @Composable
   fun MySteryLazyRow(mySteryState: List<MySteryUiState>) {
       LazyRow(
           contentPadding = PaddingValues(16.dp),
           horizontalArrangement = Arrangement.spacedBy(16.dp)
       ){
           items(mySteryState){
               MovieItem(movieState = it)
           }
       }
   }

