package habibellah.ayata.movies.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StickyHeader(headerText : String, seeMore : String? = "see more"){
    Row(modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = headerText,
            fontSize = 20.sp,
        modifier = Modifier.padding(horizontal = 10.dp))
        seeMore?.let {
            Text(
                text = it,
                modifier = Modifier.clickable {  }
                    .padding(horizontal = 10.dp,),
                color = Color.Red
            )
        }
    }
}

