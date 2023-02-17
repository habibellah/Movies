package habibellah.ayata.movies.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import habibellah.ayata.movies.R
import habibellah.ayata.movies.ui.theme.white
import habibellah.ayata.movies.ui.viewModels.states.MovieDetailsUiState

@Composable
fun MovieDetailsItem(movieDetails : MovieDetailsUiState, modifier: Modifier = Modifier, movieResponse: Int = 0, onClick : ()->Unit){
    if(movieResponse!=3){
        Column (
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Box {
                SubcomposeAsyncImage( model = "https://image.tmdb.org/t/p/w500${movieDetails.imagePath}",
                    loading = {
                        Box(modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White)
                            .align(Alignment.Center)
                            .size(64.dp),
                            contentAlignment = Alignment.Center){
                            LottieAnimationView( raw = R.raw.progress_lottie,
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
                        .height(300.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .clickable { onClick() }
                )
                Column(modifier = Modifier
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .clip(RoundedCornerShape(30.dp)),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Red)
                    ) {
                        Text(text = "see trailler",modifier = Modifier.background(Color.Red))
                    }
                    Text(text = movieDetails.movieTitle.toString(),
                        fontSize = 25.sp,
                        color = white
                    )
                    Text(text = "realeae day"
                        ,
                        fontSize = 10.sp,
                        color = Color.Red
                    )
                    Text(text = "company production"
                        ,
                        fontSize = 10.sp,
                        color = white
                    )
                    Text(text = "rate and review"
                        ,
                        fontSize = 10.sp,
                        color = white
                    )
                }

            }
        }
    }
    else if(movieResponse == 3){
        Image(painter = painterResource(id = R.drawable.error), contentDescription = "ok",modifier = Modifier
            .clip(CircleShape)
            .background(Color.White)
            .size(64.dp),)
    }
}

//
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun Preview(){
//    MovieDetailsItem(Modifier.fillMaxWidth(), onClick = {})
//}
