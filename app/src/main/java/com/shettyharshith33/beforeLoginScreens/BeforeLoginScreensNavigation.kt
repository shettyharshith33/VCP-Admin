package com.shettyharshith33.beforeLoginScreens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


object BeforeLoginScreensNavigationObject {
    const val OTP_REQUEST_PAGE = "otpRequestPage"
    const val OTP_VERIFICATION_PAGE = "otpVerificationPage"
    const val ONBOARDING_SCREEN = "onBoardingScreen"
    const val SIGNUP_SCREEN = "signUpScreen"
    const val LOGIN_SCREEN = "loginScreen"
    const val HOME_SCREEN = "homeScreen"
    const val EMAIL_LINK_SENT_PAGE = "emailLinkSentPage"

}


@Composable
fun BeforeLoginScreensNavigation(navController: NavController) {
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = BeforeLoginScreensNavigationObject.HOME_SCREEN
    ) {
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
            HomeScreen()
        }
        composable(route = BeforeLoginScreensNavigationObject.EMAIL_LINK_SENT_PAGE) {
            EmailLinkSentPage(navController)
        }


    }
}