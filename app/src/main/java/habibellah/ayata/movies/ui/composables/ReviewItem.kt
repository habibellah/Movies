package habibellah.ayata.movies.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import habibellah.ayata.movies.R
import habibellah.ayata.movies.ui.viewModels.states.Review

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ReviewItem(review : Review) {
    Column {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            SubcomposeAsyncImage(model = "https://image.tmdb.org/t/p/w500${review.avatarPath}",
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
                    .width(50.dp)
                    .height(50.dp)
                    .clip(shape = RoundedCornerShape(50))
                    .clickable { }
            )
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = review.userName.toString())
                Text(text = "@${review.author.toString()}", fontSize = 10.sp, color = Color.Gray)
            }
        }
        Text(text = review.reviewContent.toString(), maxLines = 5)
        Box(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Start)
            .height(50.dp)) {
            RatingBar(rating = 5, isSelectable = false)
        }
        Spacer(modifier = Modifier
            .height(5.dp)
            .clip(RoundedCornerShape(50))
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.red_movie)))
    }
}
