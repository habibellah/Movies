package habibellah.ayata.movies.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import habibellah.ayata.movies.R

@Composable
fun ErrorMovieItem(
    modifier : Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.error), contentDescription = "ok",
        modifier = modifier
            .background(Color.Black),
        alignment = Alignment.TopCenter
    )
}