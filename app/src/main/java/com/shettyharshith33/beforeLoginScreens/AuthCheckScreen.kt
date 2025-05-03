package com.shettyharshith33.beforeLoginScreens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.shettyharshith33.utils.TeacherSessionManager

//
//@Composable
//fun AuthCheckScreen(navController: NavController) {
//    val auth = FirebaseAuth.getInstance()
//    val isUserLoggedIn = auth.currentUser != null
//
//    LaunchedEffect(Unit){
//        if (isUserLoggedIn) {
//            navController.navigate(BeforeLoginScreensNavigationObject.HOME_SCREEN) {
//                popUpTo(0) // Clear backstack
//            }
//        } else {
//            navController.navigate(BeforeLoginScreensNavigationObject.ONBOARDING_SCREEN) {
//                popUpTo(0)
//            }
//        }
//    }
//}
//
//



@Composable
fun AuthCheckScreen(navController: NavController) {
    val context = LocalContext.current
    val firebaseAuth = FirebaseAuth.getInstance()
    val teacherSessionManager = TeacherSessionManager(context)

    LaunchedEffect(Unit) {
        val firebaseUser = firebaseAuth.currentUser
        val teacherUid = teacherSessionManager.getTeacherSession()

        if (firebaseUser != null) {
            // Student is logged in
            navController.navigate(BeforeLoginScreensNavigationObject.HOME_SCREEN) {
                popUpTo(0)
            }
        } else if (teacherUid != null) {
            // Teacher is logged in
            navController.navigate(BeforeLoginScreensNavigationObject.TEACHERS_HOME_SCREEN) {
                popUpTo(0)
            }
        } else {
            navController.navigate(BeforeLoginScreensNavigationObject.ONBOARDING_SCREEN) {
                popUpTo(0)
            }
        }
    }
}

