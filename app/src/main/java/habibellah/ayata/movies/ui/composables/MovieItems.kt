package habibellah.ayata.movies.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import habibellah.ayata.movies.ui.theme.white
import habibellah.ayata.movies.ui.viewModels.states.*
import habibellah.ayata.movies.R
import habibellah.ayata.movies.ui.ShowType

@Composable
fun MovieItem(
    movieState : MovieUiState,
    modifier : Modifier = Modifier,
    onClick : (id : Int?, filmType : ShowType) -> Unit
) {
    Column {
        Box {
            SubcomposeAsyncImage(model = movieState.imageUrl,
                loading = {
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .size(64.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        LottieAnimationView(
                            raw = R.raw.progress_lottie,
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp)
                        )
                    }
                },
                contentScale = ContentScale.Crop,
                contentDescription = "movie image",
                modifier = modifier
                    .size(150.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
                    .clickable { onClick(movieState.id, movieState.type) }
            )
            movieState.movieName?.let {
                Text(
                    text = it, modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(15.dp),
                    fontSize = 10.sp,
                    color = white
                )
            }
        }
    }
}
