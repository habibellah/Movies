package habibellah.ayata.movies.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import habibellah.ayata.movies.R
import habibellah.ayata.movies.ui.viewModels.states.MovieDetailsUiState

@Composable
fun MovieDetailsItem(
  movieDetails: MovieDetailsUiState,
  modifier: Modifier = Modifier,
  movieResponse: Int = 0,
  onClick: () -> Unit
) {
  if (movieResponse != 3) {
    Column(
      verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Box {
        SubcomposeAsyncImage(model = "https://image.tmdb.org/t/p/w500${movieDetails.imagePath}",
          loading = {
            Box(
              modifier = Modifier
                .background(Color.White)
                .align(Alignment.Center)
                .size(64.dp),
              contentAlignment = Alignment.Center
            ) {
              LottieAnimationView(
                raw = R.raw.progress_lottie,
                modifier = Modifier
                  .width(150.dp)
                  .height(150.dp)

              )
            }
          },
          contentScale = ContentScale.Crop,
          contentDescription = "movie image",
          modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(shape = RoundedCornerShape(5.dp))
            .clickable { onClick() }
        )
        Column(
          modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(vertical = 5.dp),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Button(
            onClick = { },
            modifier = Modifier
              .clip(RoundedCornerShape(50))
              .height(40.dp)
              .width(150.dp),
            colors = ButtonDefaults.buttonColors(
              backgroundColor = colorResource(id = R.color.red_movie)
            ),
          ) {
            Icon(painter = painterResource(id = R.drawable.play_trailer), contentDescription = "play icon")
            Text(text = "play trailer", modifier = Modifier.background(Color.Red), fontSize = 15.sp)
          }
        }

      }
    }
  } else {
    Image(
      painter = painterResource(id = R.drawable.error), contentDescription = "ok",
      modifier = Modifier
        .clip(CircleShape)
        .background(Color.White)
        .size(64.dp),
    )
  }
}

