package habibellah.ayata.movies.ui.composables

import androidx.compose.runtime.Composable

@Composable
fun Header(headerText : String, seeMore : String?,onClick:()->Unit) {
    StickyHeader(headerText = headerText, seeMore,onClick)
}