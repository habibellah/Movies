package habibellah.ayata.movies.ui.screens.loginScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import habibellah.ayata.domain.useCase.AuthenticationState
import habibellah.ayata.movies.R
import habibellah.ayata.movies.ui.composables.LottieAnimationView
import habibellah.ayata.movies.ui.screens.profileScreen.navigateToProfileScreen
import habibellah.ayata.movies.ui.screens.signInScreen.navigateToSingInScreen
import habibellah.ayata.movies.ui.viewModels.LoginViewModel

@Composable
fun LoginScreen(navController : NavController, viewModel : LoginViewModel = hiltViewModel()) {
    val homeState by viewModel.authState.collectAsState()
    LoginScreenContent({ navController.navigateToSingInScreen() }, { userName, password ->
        viewModel.logIn(userName, password)
    }, homeState, { navController.navigateToProfileScreen() })
}

@Composable
private fun LoginScreenContent(
    singInClick : () -> Unit,
    logInClick : (userName : String, password : String) -> Unit,
    authState : AuthenticationState,
    navigateToProfileScreen : () -> Unit,
) {
    LaunchedEffect(authState == AuthenticationState.Success) {
        if(authState == AuthenticationState.Success) {
            navigateToProfileScreen()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubcomposeAsyncImage(
            model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_iwpPSZsnDqf52czYxFbuRgg_GbqgxUsG2g&usqp=CAU",
            loading = {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White)
                        .size(64.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    LottieAnimationView(
                        raw = R.raw.progress_lottie,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(270.dp)
                    )
                }
            },
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter,
            contentDescription = "movie image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login to your account",
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                textAlign = TextAlign.Start,
                fontSize = 25.sp
            )
            val userName = remember {
                mutableStateOf("")
            }

            TextField(
                value = userName.value,
                onValueChange = {
                    userName.value = it
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "")
                },
                modifier = Modifier.border(
                    BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(listOf(Color.Red, Color.Red))
                    ),
                    shape = RoundedCornerShape(20)
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = { Text(text = "user name") }
            )
            val password = remember {
                mutableStateOf("")
            }
            TextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "")
                },
                modifier = Modifier.border(
                    BorderStroke(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(listOf(Color.Red, Color.Red))
                    ),
                    shape = RoundedCornerShape(20)
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = { Text(text = "passwrod") }
            )
            Box(modifier = Modifier.padding(horizontal = 10.dp)) {
                Button(
                    onClick = {
                        logInClick(userName.value, password.value)
                    },
                    Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {
                    Text(text = "Login", color = Color.White, fontSize = 25.sp)
                    AnimatedVisibility(authState == AuthenticationState.Loading) {
                        LottieAnimationView(raw = R.raw.progress_lottie)
                    }

                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(text = "do not have an account?", color = Color.White)
                Text(
                    text = "sign up",
                    color = Color.Red,
                    modifier = Modifier.clickable { singInClick() })
            }
        }
    }
}
//
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun Preview() {
//    LoginScreen()
//}
