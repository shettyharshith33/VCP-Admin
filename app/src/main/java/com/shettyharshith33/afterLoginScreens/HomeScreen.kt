package com.shettyharshith33.afterLoginScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.model.content.CircleShape
import com.google.firebase.auth.FirebaseAuth
import com.shettyharshith33.beforeLoginScreens.BeforeLoginScreensNavigationObject
import com.shettyharshith33.vcputtur.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



@Composable
fun HomeScreen(navController: NavController) {
    val images = listOf(
        R.drawable.adm_open,
        R.drawable.hp_admissions_open,
        R.drawable.sowj_lab,
        R.drawable.harsh_garden,
        R.drawable.panchajanya,
        R.drawable.varsha_aurdino
    )
    val pagerState = rememberPagerState(pageCount = { images.size })
    val coroutineScope = rememberCoroutineScope()

    // Auto-scroll effect
    LaunchedEffect(pagerState) {
        while (true) {
            delay(3000) // Change image every 3 seconds
            coroutineScope.launch {
                val nextPage = (pagerState.currentPage + 1) % images.size
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

//
//    Column(
//        verticalArrangement = Arrangement.Top, modifier = Modifier
//            .height(325.dp)
//            .fillMaxWidth()
//    ) {
//        Box() {
//            HorizontalPager(
//                state = pagerState, modifier = Modifier.fillMaxSize()
//            ) { page ->
//                Image(
//                    modifier = Modifier
//                        .height(250.dp)
//                        .fillMaxWidth()
//                        .clip(RoundedCornerShape(45.dp))
//                        .padding(top = 10.dp, bottom = 10.dp),
//                    painter = painterResource(id = images[page]),
//                    contentDescription = null
//                )
//            }
//
//        }
//    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Spacer(modifier = Modifier.height(25.dp))
            Box(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxSize()
                ) { page ->
                    Image(
                        modifier = Modifier
                            .height(250.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(45.dp))
                            .padding(top = 10.dp, bottom = 10.dp),
                        painter = painterResource(id = images[page]),
                        contentDescription = null
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 5.dp),
                text = "Category",
                fontFamily = FontFamily.Monospace,
                fontSize = 20.sp
            )
        }

        item {
            LazyRow(Modifier.padding(10.dp)){
                item {
                    Image(
                        painterResource(R.drawable.library), contentDescription = "",
                        modifier = Modifier.clip(CircleShape).size(80.dp),
                        contentScale = ContentScale.Crop)

                }

                item {
                    Spacer(modifier = Modifier.padding(2.dp))
                    Image(
                        painterResource(R.drawable.library), contentDescription = "",
                        modifier = Modifier.clip(CircleShape).size(80.dp),
                        contentScale = ContentScale.Crop)

                }
            }
        }

    }

}

//
//fun signOutAndNavigate(navController: NavController) {
//    FirebaseAuth.getInstance().signOut()
//    navController.navigate(BeforeLoginScreensNavigationObject.ONBOARDING_SCREEN) {
//        popUpTo(0) // Clears all previous routes from backstack
//    }
//}
