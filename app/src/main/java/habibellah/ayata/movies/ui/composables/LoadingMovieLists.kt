package habibellah.ayata.movies.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import habibellah.ayata.movies.R

@Composable
fun LoadingMovieLists(){
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.progress_movie))
        LottieAnimation(composition = composition,
            modifier = Modifier.fillMaxSize(),
            iterations = LottieConstants.IterateForever,
            contentScale = ContentScale.None)


}
