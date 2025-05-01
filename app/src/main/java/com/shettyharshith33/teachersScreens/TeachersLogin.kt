package com.shettyharshith33.teachersScreens

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.shettyharshith33.beforeLoginScreens.AuthViewModel
import com.shettyharshith33.beforeLoginScreens.BeforeLoginScreensNavigationObject
import com.shettyharshith33.beforeLoginScreens.triggerVibration
import com.shettyharshith33.firebaseAuth.AuthUser
import com.shettyharshith33.utils.ResultState
import com.shettyharshith33.vcputtur.R
import com.shettyharshith33.vcputtur.ui.theme.dodgerBlue
import com.shettyharshith33.vcputtur.ui.theme.myGreen
import com.shettyharshith33.vcputtur.ui.theme.netWorkRed
import com.shettyharshith33.vcputtur.ui.theme.poppinsFontFamily
import com.shettyharshith33.vcputtur.ui.theme.textColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

@Composable
fun TeachersLogin(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    var uid by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    var isDialog by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val haptic = LocalHapticFeedback.current
    var showForgotPasswordDialog by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }
    val encodedName = java.net.URLEncoder.encode(name, "UTF-8")

    if (isDialog) {
        Dialog(onDismissRequest = {}) {
            CircularProgressIndicator()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = screenWidth * 0.1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(screenHeight * 0.08f))

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

            Text(
                "Login",
                fontSize = 30.sp,
                color = dodgerBlue,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))


            Text(
                "Enter your Name",
                fontSize = 15.sp,
                color = dodgerBlue,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.W500
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                modifier = Modifier
                    .border(0.5.dp, textColor, shape = RoundedCornerShape(5.dp))
                    .height(50.dp)
                    .fillMaxWidth(),
                singleLine = true,
                value = name,
                onValueChange = { name = it },
                placeholder = { Text("Name") },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = if (emailError) Color.Red else dodgerBlue,
                    focusedIndicatorColor = if (emailError) Color.Red else dodgerBlue
                )
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Enter your UID",
                fontSize = 15.sp,
                color = dodgerBlue,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.W500
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                modifier = Modifier
                    .border(0.5.dp, textColor, shape = RoundedCornerShape(5.dp))
                    .height(50.dp)
                    .fillMaxWidth(),
                singleLine = true,
                value = uid,
                onValueChange = { uid = it },
                placeholder = { Text("UID") },
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = if (emailError) Color.Red else dodgerBlue,
                    focusedIndicatorColor = if (emailError) Color.Red else dodgerBlue
                )
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Enter your password",
                fontSize = 15.sp,
                color = dodgerBlue,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.W500
            )
            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                modifier = Modifier
                    .border(0.5.dp, textColor, shape = RoundedCornerShape(5.dp))
                    .height(50.dp)
                    .fillMaxWidth(),
                value = pwd,
                onValueChange = { pwd = it },
                placeholder = { Text("Password") },
                visualTransformation =
                if (passwordVisible)
                    VisualTransformation.None
                else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    val icon = if (passwordVisible)
                        R.drawable.visibilty
                    else
                        R.drawable.visibilty_off

                    Image(painterResource(icon), contentDescription = "",
                        modifier = Modifier.clickable { passwordVisible = !passwordVisible })
                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = if (passwordError) Color.Red else dodgerBlue,
                    focusedIndicatorColor = if (passwordError) Color.Red else dodgerBlue
                )
            )

            Button(
                onClick = {
                    if (uid.isNotEmpty() && pwd.isNotEmpty()) {
                        isDialog = true
                        scope.launch(Dispatchers.IO) {
                            try {
                                val db = FirebaseFirestore.getInstance()
                                val snapshot = db.collection("teachers")
                                    .whereEqualTo("uid", uid)
                                    .get()
                                    .await()

                                if (!snapshot.isEmpty) {
                                    val teacher = snapshot.documents[0]
                                    val storedPassword = teacher.getString("pwd")
                                    if (storedPassword == pwd) {
                                        withContext(Dispatchers.Main) {
//                                            navController.navigate(BeforeLoginScreensNavigationObject.TEACHERS_HOME_SCREEN)
                                            navController.navigate("teachers_home_screen/$uid")
                                        }
                                    } else {
                                        withContext(Dispatchers.Main) {
                                            showColoredToast(context, "Incorrect password.", false)
                                            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                            triggerVibration(context)
                                        }
                                    }
                                } else {
                                    withContext(Dispatchers.Main) {
                                        showColoredToast(context, "Teacher not found.", false)
                                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                        triggerVibration(context)
                                    }
                                }
                            } catch (e: Exception) {
                                withContext(Dispatchers.Main) {
                                    showColoredToast(context, "Error: ${e.message}", false)
                                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                    triggerVibration(context)
                                }
                            } finally {
                                withContext(Dispatchers.Main) {
                                    isDialog = false
                                }
                            }
                        }
                    } else {
                        showColoredToast(context, "Please enter both UID and password.", false)
                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                        triggerVibration(context)
                    }
                },
                modifier = Modifier.width(150.dp),
                colors = ButtonDefaults.buttonColors().copy(containerColor = dodgerBlue)
            ) {
                Text("Login", color = Color.White)
            }
        }
    }
}

fun showColoredToast(context: Context, message: String, isSuccess: Boolean) {
    try {
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        val view = toast.view

        if (view != null) {
            val bgColor = if (isSuccess) myGreen.toArgb() else netWorkRed.toArgb()
            view.setBackgroundColor(bgColor)

            val textView = view.findViewById<TextView>(android.R.id.message)
            textView?.setTextColor(if (isSuccess) Color.Black.toArgb() else Color.White.toArgb())

            toast.show()
        } else {
            throw Exception("Custom toast not supported")
        }
    } catch (e: Exception) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}


