package com.shettyharshith33.beforeLoginScreens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shettyharshith33.afterLoginScreens.AcademicsScreen
import com.shettyharshith33.afterLoginScreens.AdmissionsScreen
import com.shettyharshith33.afterLoginScreens.CgpaCalculatorScreen
import com.shettyharshith33.afterLoginScreens.DepartmentsScreen
import com.shettyharshith33.afterLoginScreens.Gallery
import com.shettyharshith33.afterLoginScreens.HomeScreen
import com.shettyharshith33.beforeLoginScreens.departments.bcaStaffs.TeacherListScreen
import com.shettyharshith33.teachersScreens.TeachersHomeScreen
import com.shettyharshith33.teachersScreens.TeachersLogin
import com.shettyharshith33.ugCourses.BA
import com.shettyharshith33.ugCourses.BBA
import com.shettyharshith33.ugCourses.BCA
import com.shettyharshith33.ugCourses.BCOM
import com.shettyharshith33.ugCourses.BSC


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
    const val ADMISSIONS_SCREEN = "admissionsScreen"
    const val BCA = "bca"
    const val BBA = "bba"
    const val BCOM = "bCom"
    const val BA = "ba"
    const val BSC = "bSc"
    const val ACADEMICS_SCREEN = "academicsScreen"
    const val DEPARTMENTS = "departments"

    const val TEACHER_LIST_SCREEN = "teacherListScreen"

    const val TEACHERS_LOGIN = "teachersLogin"
//    const val TEACHERS_HOME_SCREEN = "teachersHomeScreen"
    const val TEACHERS_HOME_SCREEN = "teachers_home_screen/{uid}"


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
        composable(route = BeforeLoginScreensNavigationObject.GALLERY) {
            Gallery(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.ADMISSIONS_SCREEN) {
            AdmissionsScreen(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.BCA) {
            BCA(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.BSC) {
            BSC(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.BCOM) {
            BCOM(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.BBA) {
            BBA(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.BA) {
            BA(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.ACADEMICS_SCREEN) {
            AcademicsScreen(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.DEPARTMENTS) {
            DepartmentsScreen(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.TEACHERS_LOGIN) {
            TeachersLogin(navController)
        }
        composable(route = BeforeLoginScreensNavigationObject.TEACHER_LIST_SCREEN) {
            TeacherListScreen(viewModel = viewModel(),navController)
        }

//        composable(route = BeforeLoginScreensNavigationObject.TEACHERS_HOME_SCREEN) {
//            TeachersHomeScreen(navController)
//        }

        composable(
            route = BeforeLoginScreensNavigationObject.TEACHERS_HOME_SCREEN,
            arguments = listOf(navArgument("uid") { type = NavType.StringType })
        ) { backStackEntry ->
            val uid = backStackEntry.arguments?.getString("uid") ?: ""
            TeachersHomeScreen(navController = navController, uid = uid)
        }

    }
}