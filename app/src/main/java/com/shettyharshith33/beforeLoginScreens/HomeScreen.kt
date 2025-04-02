package com.shettyharshith33.beforeLoginScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shettyharshith33.vcputtur.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(navController: NavController) {
    val images = listOf(
        R.drawable.hp_admissions_open,
        R.drawable.hp_admissions_open
    ) // ✅ Replace with actual drawables
    val pagerState =
        rememberPagerState(pageCount = { images.size }) // ✅ Fix: Correct way to set count
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

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
            .height(200.dp) // Fixed height
            .padding(horizontal = 12.dp) // Padding from start & end
        , colors = CardDefaults.cardColors().copy(containerColor = Color.Transparent)
    ) {
        HorizontalPager(
            state = pagerState, // ✅ Correctly passed
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(100.dp))
                    .padding(top = 10.dp, bottom = 10.dp),
                painter = painterResource(id = images[page]),
                contentDescription = null
            )
        }
    }


}