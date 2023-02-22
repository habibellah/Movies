package habibellah.ayata.movies.ui.screens.profileScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import habibellah.ayata.movies.R

@Composable
fun ProfileScreen(){
ProfileScreenContent()
}

@Composable
private fun ProfileScreenContent(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = (R.drawable.movie_poster)), contentDescription = null)
        Text(text = "habibayata", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp))
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start){
            Row {
                Icon(imageVector = Icons.Default.Done, contentDescription = "")
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Watch History", fontSize = 20.sp)
            }
            Row {
                Icon(imageVector = Icons.Default.Star, contentDescription = "")
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "My Rating", fontSize = 20.sp)
            }
            Row {
                Icon(imageVector = Icons.Default.Close, contentDescription = "")
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Sign Out", fontSize = 20.sp)
            }
        }



    }
}
