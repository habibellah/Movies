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
import coil.compose.SubcomposeAsyncImage
import habibellah.ayata.movies.R
import habibellah.ayata.movies.ui.viewModels.states.Actor

@Composable
fun ActorItem(actor : Actor){
    Column {
        SubcomposeAsyncImage(model = "https://image.tmdb.org/t/p/w500${actor.image}",
            loading = {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .align(Alignment.Center)
                        .size(25.dp),
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
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .clip(shape = RoundedCornerShape(50))
                .clickable {   }
        )
        Text(text = actor.name.toString())
    }
}