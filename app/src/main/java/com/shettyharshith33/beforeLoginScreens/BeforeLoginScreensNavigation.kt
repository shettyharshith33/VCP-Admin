package com.shettyharshith33.beforeLoginScreens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shettyharshith33.afterLoginScreens.CgpaCalculatorScreen
import com.shettyharshith33.afterLoginScreens.Gallery
import com.shettyharshith33.afterLoginScreens.HomeScreen
import com.shettyharshith33.afterLoginScreens.ResultDisplay


object BeforeLoginScreensNavigationObject {
    const val AUTH_CHECK = "authCheck"
    const val OTP_REQUEST_PAGE = "otpRequestPage"
    const val OTP_VERIFICATION_PAGE = "otpVerificationPage"
    const val ONBOARDING_SCREEN = "onBoardingScreen"
    const val SIGNUP_SCREEN = "signUpScreen"
    const val LOGIN_SCREEN = "loginScreen"
    const val HOME_SCREEN = "homeScreen"
    const val EMAIL_LINK_SENT_PAGE = "emailLinkSentPage"
    const val CGPA_CALCULATOR_SCREEN = "cgpaCalculatorScreen"
    const val GALLERY = "gallery"
//    const val RESULT_DISPLAY = "resultDisplay"


}


@Composable
fun BeforeLoginScreensNavigation(navController: NavController) {
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = BeforeLoginScreensNavigationObject.AUTH_CHECK
    ) {

        composable(BeforeLoginScreensNavigationObject.AUTH_CHECK) {
            AuthCheckScreen(navController)
        }

        composable(route = BeforeLoginScreensNavigationObject.OTP_VERIFICATION_PAGE) {
            OtpVerificationPage(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.OTP_REQUEST_PAGE) {
            OtpRequestPage(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.ONBOARDING_SCREEN) {
            OnBoardingScreen(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.SIGNUP_SCREEN) {
            SignUpScreen(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.LOGIN_SCREEN) {
            LoginScreen(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.HOME_SCREEN) {
            HomeScreen(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.EMAIL_LINK_SENT_PAGE) {
            EmailLinkSentPage(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.CGPA_CALCULATOR_SCREEN) {
            CgpaCalculatorScreen(navController)
        }
        composable (route = BeforeLoginScreensNavigationObject.GALLERY) {
            Gallery(navController)
        }
//        composable (route = BeforeLoginScreensNavigationObject.RESULT_DISPLAY) {
//            ResultDisplay(result = "",navController)
//        }


    }
}