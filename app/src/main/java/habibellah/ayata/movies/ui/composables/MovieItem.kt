package habibellah.ayata.movies.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import habibellah.ayata.movies.Greeting
import habibellah.ayata.movies.R
import habibellah.ayata.movies.ui.theme.white

@Composable
fun MovieItemWithCategoryName(movieCategory: String){
    Column {
        Box {
            Image(painter = painterResource(id = R.drawable.movie_poster),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
            )
            Text(text = movieCategory, modifier = Modifier.align(Alignment.BottomStart)
                .padding(5.dp),
                fontSize = 10.sp,
                color = white)
        }
    }
}

@Composable
fun MovieItem(){
        Box {
            Image(painter = painterResource(id = R.drawable.movie_poster),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
            )
        }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview(){
    MovieItem()
}
