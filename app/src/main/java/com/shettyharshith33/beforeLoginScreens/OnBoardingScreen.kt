package com.shettyharshith33.beforeLoginScreens

import SetStatusBarColor
import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.android.gms.auth.api.identity.Identity
import com.shettyharshith33.utils.GoogleAuthUIClient
import com.shettyharshith33.vcputtur.R
import com.shettyharshith33.vcputtur.ui.theme.dodgerBlue
import com.shettyharshith33.vcputtur.ui.theme.lightDodgerBlue
import com.shettyharshith33.vcputtur.ui.theme.myGrey
import com.shettyharshith33.vcputtur.ui.theme.poppinsFontFamily
import com.shettyharshith33.vcputtur.ui.theme.signInGrey
import com.valentinilk.shimmer.shimmer
import kotlinx.coroutines.launch


@Composable
fun OnBoardingScreen(
    navController: NavController, viewModel: NetworkViewModel = hiltViewModel()
) {
    val isConnected by viewModel.isConnected.observeAsState()
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.welcome_animation_dodgerblue))

    SetStatusBarColor(Color(lightDodgerBlue.toArgb()), useDarkIcons = false)

    // Get screen width and height
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val context = LocalContext.current
    val haptic = LocalHapticFeedback.current


    val activity = context as Activity
    val scope = rememberCoroutineScope()


    val isSigningIn = remember { mutableStateOf(false) }


    val viewModel: AuthViewModel =
        hiltViewModel() // Replace with your ViewModel if named differently
    val oneTapClient = remember { Identity.getSignInClient(context) }
    val googleAuthUIClient = remember { GoogleAuthUIClient(context, oneTapClient) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult()
    ) { result ->
        scope.launch {
            if (result.resultCode == Activity.RESULT_OK) {
                val credential = googleAuthUIClient.signInWithIntent(result.data!!)
                val idToken = credential?.googleIdToken
                if (idToken != null) {
                    viewModel.signInWithGoogle(idToken) { isSuccess ->
                        isSigningIn.value = false
                        if (isSuccess) {
                            Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                            navController.navigate(BeforeLoginScreensNavigationObject.HOME_SCREEN) {
                                popUpTo("onboarding_screen") { inclusive = true }
                            }
                        } else {
                            Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    isSigningIn.value = false
                    Toast.makeText(context, "Sign-in cancelled", Toast.LENGTH_SHORT).show()
                }
            } else {
                isSigningIn.value = false
                Toast.makeText(context, "Sign-in cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    }







    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = screenWidth * 0.05f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(screenHeight * 0.08f))
        NetworkStatusBanner(isConnected ?: false)

        // College Name
        Text(
            "Vivekananda College of",
            fontSize = (screenWidth.value * 0.05f).sp,
            color = dodgerBlue,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Arts, Science and Commerce",
            fontSize = (screenWidth.value * 0.05f).sp,
            color = dodgerBlue,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold
        )
        Text(
            "(Autonomous)",
            fontSize = (screenWidth.value * 0.04f).sp,
            color = dodgerBlue,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(screenHeight * 0.02f))

        // College Logo
        Image(
            modifier = Modifier.size(screenWidth * 0.2f),
            painter = painterResource(R.drawable.collegelogo),
            contentDescription = null
        )

        // Animation
        LottieAnimation(
            composition = composition,
            modifier = Modifier.size(screenWidth * 0.8f),
            iterations = LottieConstants.IterateForever
        )
        Text(
            "Login with your e-mail and password",
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = (screenWidth.value * 0.04f).sp
        )

        Spacer(modifier = Modifier.height(screenHeight * 0.03f))

        // Login Button
        Button(
            onClick = {
                navController.navigate(BeforeLoginScreensNavigationObject.LOGIN_SCREEN)
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(screenHeight * 0.06f)
                .defaultMinSize(minWidth = 200.dp, minHeight = 48.dp)
                .widthIn(max = 400.dp), // Ensures button doesn't get too large
            colors = ButtonDefaults.buttonColors(containerColor = dodgerBlue)
        ) {
            Text("Login", color = Color.White, fontSize = (screenWidth.value * 0.045f).sp)
        }

        Spacer(modifier = Modifier.height(screenHeight * 0.03f))

        // Sign-in with Google Button
        Button(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(screenHeight * 0.06f)
                .border(0.5.dp, Color.Black, shape = RoundedCornerShape(5.dp))
                .widthIn(max = 400.dp),
            onClick = {
                isSigningIn.value = true
                scope.launch {
                    val result = googleAuthUIClient.signIn()
                    if (result != null) {
                        launcher.launch(IntentSenderRequest.Builder(result).build())
                    } else {
                        isSigningIn.value = false
                        Toast.makeText(context, "Sign-in Intent failed", Toast.LENGTH_SHORT).show()
                    }
                }
            },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = myGrey)
        ) {
            Text(
                "Sign-in with Google",
                color = Color.Black,
                fontSize = (screenWidth.value * 0.04f).sp
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                painterResource(R.drawable.googlelogo),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }



        Spacer(modifier = Modifier.height(screenHeight * 0.02f))

        // Sign-up Button
        Button(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(screenHeight * 0.06f)
                .widthIn(max = 400.dp),
            onClick = {
                navController.navigate(BeforeLoginScreensNavigationObject.SIGNUP_SCREEN)
            },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(
                "Don't have an account? Sign-up here",
                color = Color.Black,
                fontSize = (screenWidth.value * 0.035f).sp, // Smaller to prevent line breaks
                maxLines = 1
            )
        }
        Button(colors = ButtonDefaults.buttonColors().copy(
            containerColor = lightDodgerBlue
        ), onClick = {
            navController.navigate(BeforeLoginScreensNavigationObject.TEACHERS_LOGIN)  // We'll add this screen in the next step
        }) {
            Text("Teachers login")
        }

    }
    // Progress overlay
    if (isSigningIn.value) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(25.dp)),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenHeight * 0.3f)
                    .size(200.dp)
                    .clip(RoundedCornerShape(25.dp)), contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .clip(RoundedCornerShape(25.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(color = lightDodgerBlue)
                    Text(
                        "Loading...",
                        fontFamily = poppinsFontFamily,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}
