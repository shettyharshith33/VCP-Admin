package com.shettyharshith33.beforeLoginScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shettyharshith33.vcputtur.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreen() {
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


    Column(
        verticalArrangement = Arrangement.Top, modifier = Modifier
            .height(325.dp)
            .fillMaxWidth()
    ) {
        Box() {
            HorizontalPager(
                state = pagerState, modifier = Modifier.fillMaxSize()
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
}