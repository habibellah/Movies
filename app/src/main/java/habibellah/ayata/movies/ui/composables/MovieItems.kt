package habibellah.ayata.movies.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import habibellah.ayata.movies.ui.theme.white
import habibellah.ayata.movies.ui.viewModels.states.*

@Composable
fun MovieItem(movieState : MovieUiState, modifier: Modifier = Modifier){
    Column {
        Box {
            Image(painter =rememberAsyncImagePainter(model = movieState.imageUrl),
                contentScale = ContentScale.Crop,
                contentDescription = "movie image",
                modifier = modifier
                    .size(150.dp)
                    .clip(shape = RoundedCornerShape(30.dp))
            )
            movieState.categoryName?.let {
                Text(text = it, modifier = Modifier.align(Alignment.BottomStart)
                    .padding(15.dp),
                    fontSize = 10.sp,
                    color = white)
            }
        }
    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun Preview(){
//
//}
