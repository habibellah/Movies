package habibellah.ayata.movies.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import habibellah.ayata.movies.ui.viewModels.states.Actor
import habibellah.ayata.movies.ui.viewModels.states.Review
import habibellah.ayata.movies.ui.viewModels.states.SimilarMovie

@Composable
fun HandleActorsLazyRow(
    actorsList : MutableList<Actor>?,
    modifier : Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            if (actorsList != null) {
                AnimatedVisibility(actorsList.isEmpty()) {
                    LoadingMovieLists()
                }
            } else {
                AnimatedVisibility(true) {
                  ActorItem(actor = Actor("",""))
                }
            }
        }
        if (actorsList != null) {
            if (actorsList.isNotEmpty()) {
                items(actorsList.toList()) {
                    ActorItem(
                       it
                    )
                }
            }
        }
    }
}


@Composable
fun HandleSimilarMoviesLazyRow(
    similarMovieList : MutableList<SimilarMovie>?,
    modifier : Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            if (similarMovieList != null) {
                AnimatedVisibility(similarMovieList.isEmpty()) {
                    LoadingMovieLists()
                }
            } else {
                AnimatedVisibility(true) {
                    ActorItem(actor = Actor("",""))
                }
            }
        }
        if (similarMovieList != null) {
            if (similarMovieList.isNotEmpty()) {
                items(similarMovieList.toList()) {
                    SimilarMovieItem(
                        it
                    )
                }
            }
        }
    }
}

@Composable
fun HandleMovieReviewsLazyColumn(
    reviewsList : MutableList<Review>?,
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .height(600.dp)
            .fillMaxWidth()
    ) {
        item {
            if (reviewsList != null) {
                AnimatedVisibility(reviewsList.isEmpty()) {
                    LoadingMovieLists()
                }
            } else {
                AnimatedVisibility(true) {
                    Text(text = "there is not review", fontSize = 30.sp)
                }
            }
        }
        if (reviewsList != null) {
            if (reviewsList.isNotEmpty()) {
                items(reviewsList.toList()) {
                ReviewItem(review = it)
                }
            }
        }
    }
}
