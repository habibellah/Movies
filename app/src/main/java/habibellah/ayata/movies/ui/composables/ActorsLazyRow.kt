package habibellah.ayata.movies.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import habibellah.ayata.movies.ui.ShowType
import habibellah.ayata.movies.ui.viewModels.states.Actor
import habibellah.ayata.movies.ui.viewModels.states.MovieUiState

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
