package com.shettyharshith33.afterLoginScreens

import SetStatusBarColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shettyharshith33.beforeLoginScreens.BeforeLoginScreensNavigationObject
import com.shettyharshith33.vcputtur.R
import com.shettyharshith33.vcputtur.ui.theme.dodgerBlue
import com.shettyharshith33.vcputtur.ui.theme.lightDodgerBlue
import com.shettyharshith33.vcputtur.ui.theme.myGrey
import com.shettyharshith33.vcputtur.ui.theme.poppinsFontFamily


@Composable
fun HomeScreen(navController: NavController) {

    val coroutineScope = rememberCoroutineScope()

    SetStatusBarColor(Color(lightDodgerBlue.toArgb()), useDarkIcons = false)




    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(myGrey)
    ) {
        item {
            Spacer(modifier = Modifier.height(32.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu Icon"
                )
                Text(
                    "VC Puttur",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 120.dp),
                    fontWeight = FontWeight.W900,
                    fontSize = 20.sp
                )
            }
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(10.dp)
                    .shadow(
                        elevation = 14.dp,
                        shape = RoundedCornerShape(12.dp),
                        ambientColor = Color.LightGray
                    )
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(lightDodgerBlue, Color.LightGray) // Blue gradient
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent // To let gradient show through
                    ),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(28.dp))
                        Text(
                            text = "Welcome to",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Normal
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "VC Puttur",
                            color = Color.White,
                            fontSize = 28.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.ExtraBold,
                            fontStyle = FontStyle.Normal
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Excellence in Education since 1965",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.ExtraLight,
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
            }

        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(10.dp)
                    .shadow(
                        elevation = 1.dp,
                        shape = RoundedCornerShape(12.dp),
                        ambientColor = Color.LightGray
                    )
                    .background(
                        Color.White
                    )
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent // To let gradient show through
                    ),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(120.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(90.dp)
                                    .clip(shape = RoundedCornerShape(10.dp))
                                    .background(lightDodgerBlue),
                                contentAlignment = Alignment.Center
                            )
                            {
                                Text(
                                    "LATEST NEWS",
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                        }

                        Text(
                            "Admissions open for academic year 2025-26 " +
                                    " \n• IT Fest Coming Soon..."
                        )
                    }
                }
            }
        }

        item {
            Text(
                "Quick Access",
                modifier = Modifier
                    .padding(start = 15.dp),
                fontSize = 18.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }

        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(10.dp),
                        colors = CardDefaults.cardColors().copy(
                            containerColor = Color.White
                        )
                    ) {

                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.admissions),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp),
                                alignment = Alignment.Center
                            )
                            Text(
                                "Admissions",
                                fontFamily = poppinsFontFamily,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(10.dp),
                        colors = CardDefaults.cardColors().copy(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.academics),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp),
                                alignment = Alignment.Center
                            )
                            Text(
                                "Academics",
                                fontFamily = poppinsFontFamily,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(10.dp),
                        colors = CardDefaults.cardColors().copy(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.departments),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp),
                                alignment = Alignment.Center
                            )
                            Text(
                                "Departments",
                                fontFamily = poppinsFontFamily,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(10.dp),
                        colors = CardDefaults.cardColors().copy(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.exam),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp),
                                alignment = Alignment.Center
                            )
                            Text(
                                "Examinations",
                                fontFamily = poppinsFontFamily,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(10.dp),
                        colors = CardDefaults.cardColors().copy(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.college_life),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp),
                                alignment = Alignment.Center
                            )
                            Text(
                                "Campus",
                                fontFamily = poppinsFontFamily,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                    Card(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(10.dp),
                        colors = CardDefaults.cardColors().copy(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.gallery),
                                contentDescription = "",
                                modifier = Modifier.size(60.dp),
                                alignment = Alignment.Center
                            )
                            Text(
                                "Gallery",
                                fontFamily = poppinsFontFamily,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }

        item {
            Text(
                "Upcoming Events",
                modifier = Modifier
                    .padding(start = 15.dp),
                fontSize = 18.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }

        item {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(10.dp)
                    .shadow(
                        elevation = 1.dp,
                        shape = RoundedCornerShape(12.dp),
                        ambientColor = Color.LightGray
                    )
                    .background(
                        Color.White
                    )
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent // To let gradient show through
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(120.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(90.dp)
                                    .clip(shape = RoundedCornerShape(10.dp))
                                    .background(Color.White),
                                contentAlignment = Alignment.CenterStart
                            )
                            {
                                Text(
                                    "2\n MAY",
                                    fontSize = 20.sp,
                                    textAlign = TextAlign.Center,
                                    color = dodgerBlue,
                                    fontFamily = poppinsFontFamily,
                                    fontWeight = FontWeight.Black
                                )
                            }

                        }

                        Text(
                            "Inter Class IT Fest",
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

        }

        item {
            Text(
                "Courses",
                modifier = Modifier
                    .padding(start = 15.dp),
                fontSize = 18.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.SemiBold
            )
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
