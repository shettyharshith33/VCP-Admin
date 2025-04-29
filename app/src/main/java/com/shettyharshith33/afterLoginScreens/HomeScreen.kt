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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.shettyharshith33.beforeLoginScreens.BeforeLoginScreensNavigationObject
import com.shettyharshith33.vcputtur.R
import com.shettyharshith33.vcputtur.ui.theme.buttonYellow
import com.shettyharshith33.vcputtur.ui.theme.cardColor
import com.shettyharshith33.vcputtur.ui.theme.dodgerBlue
import com.shettyharshith33.vcputtur.ui.theme.lightDodgerBlue
import com.shettyharshith33.vcputtur.ui.theme.lightestDodgerBlue
import com.shettyharshith33.vcputtur.ui.theme.myGrey
import com.shettyharshith33.vcputtur.ui.theme.poppinsFontFamily
import com.shettyharshith33.vcputtur.ui.theme.signInGrey
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val scope = rememberCoroutineScope()

    SetStatusBarColor(Color(lightDodgerBlue.toArgb()), useDarkIcons = false)
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet(modifier = Modifier, drawerContainerColor = lightDodgerBlue) {
            LazyColumn() {
                item {
                    Text("Developers",
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { /* handle click */ })
                }
                item {
                    Text("Departments",
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { /* handle click */ })
                }
                item {
                    Text("Admissions",
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { /* handle click */ })
                }
                item {
                    Text("Examinations",
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { /* handle click */ })
                }
                item {
                    Text("Campus",
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { /* handle click */ })
                }
                item {
                    Text("Gallery",
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { /* handle click */ })
                }
                item {
                    Text("Settings",
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { /* handle click */ })
                }
                item {
                    Text("Sign Out",
                        color = Color.White,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                signOutAndNavigate(navController)
                            })
                }
            }
        }
    }) {

        Scaffold(
            topBar = {
                TopAppBar(modifier = Modifier.height(60.dp), colors = TopAppBarColors(
                    containerColor = lightDodgerBlue,
                    scrolledContainerColor = Color.Transparent,
                    navigationIconContentColor = lightDodgerBlue,
                    titleContentColor = lightDodgerBlue,
                    actionIconContentColor = lightDodgerBlue
                ), title = {
                    Text(
                        text = "VC Puttur",
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFontFamily,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }, navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            drawerState.open() // 👈 smooth open
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu Icon",
                            tint = Color.White
                        )
                    }
                })
            }, containerColor = myGrey
        ) { innerPadding ->


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(lightestDodgerBlue)
                    .padding(innerPadding)
            ) {

                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .padding(10.dp)
                            .shadow(
                                elevation = 14.dp,
                                shape = RoundedCornerShape(12.dp),
                                ambientColor = Color.LightGray
                            )
                    ) {

                        Image(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(shape = RoundedCornerShape(18.dp)),
                            painter = painterResource(R.drawable.hp_admissions_open),
                            contentDescription = ""
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                                .padding(top = 70.dp)
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
                                modifier = Modifier,
                                color = buttonYellow,
                                fontSize = 28.sp,
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.ExtraBold,
                                fontStyle = FontStyle.Normal
                            )

                        }
                    }

                }
                item {
                    Text(
                        "CGPA Claculator",
                        modifier = Modifier.padding(start = 15.dp),
                        fontSize = 18.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Button(
                            onClick = { navController.navigate(BeforeLoginScreensNavigationObject.CGPA_CALCULATOR_SCREEN) },
                            colors = ButtonDefaults.buttonColors().copy(
                                containerColor = lightDodgerBlue
                            )
                        ) {
                            Text(
                                "Calculate Your CGPA",
                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.SemiBold
                            )

                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "Quick Access",
                        modifier = Modifier.padding(start = 15.dp),
                        fontSize = 18.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                item {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Card(
                                modifier = Modifier.size(100.dp),
                                colors = CardDefaults.cardColors().copy(
                                    containerColor = signInGrey
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
                                modifier = Modifier.size(100.dp),
                                colors = CardDefaults.cardColors().copy(
                                    containerColor = signInGrey
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
                                modifier = Modifier.size(100.dp),
                                colors = CardDefaults.cardColors().copy(
                                    containerColor = signInGrey
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
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Card(
                                modifier = Modifier.size(100.dp),
                                colors = CardDefaults.cardColors().copy(
                                    containerColor = signInGrey
                                )
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.exams),
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
                                modifier = Modifier.size(100.dp),
                                colors = CardDefaults.cardColors().copy(
                                    containerColor = signInGrey
                                )
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.campus),
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
                                modifier = Modifier.size(100.dp),
                                colors = CardDefaults.cardColors().copy(
                                    containerColor = signInGrey
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
                                        modifier = Modifier.size(60.dp)
                                            .clickable {
                                                navController.navigate(BeforeLoginScreensNavigationObject.GALLERY)
                                            },
                                        alignment = Alignment.Center
                                    )
                                    Text(
                                        "Gallery",
                                        fontFamily = poppinsFontFamily,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.clickable {
                                            navController.navigate(BeforeLoginScreensNavigationObject.GALLERY)
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "Courses",
                        modifier = Modifier.padding(start = 15.dp),
                        fontSize = 18.sp,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        colors = CardDefaults.cardColors().copy(
                            containerColor = cardColor
                        )
                    )
                    {
                        Spacer(modifier = Modifier.height(20.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(35.dp),
                                    colors = CardDefaults.cardColors().copy(
                                        containerColor = lightDodgerBlue
                                    )
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            "UG Courses",
                                            fontFamily = poppinsFontFamily,
                                            color = Color.White,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }


                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Column(modifier = Modifier.fillMaxSize()) {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Card(
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(35.dp),
                                        colors = CardDefaults.cardColors().copy(
                                            containerColor = signInGrey
                                        )
                                    ) {

                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "BCA",
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }

                                    Card(
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(35.dp),
                                        colors = CardDefaults.cardColors().copy(
                                            containerColor = signInGrey
                                        )
                                    ) {

                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "BBA",
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                    Card(
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(35.dp),
                                        colors = CardDefaults.cardColors().copy(
                                            containerColor = signInGrey
                                        )
                                    ) {

                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "BCom",
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 10.dp),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Card(
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(35.dp),
                                        colors = CardDefaults.cardColors().copy(
                                            containerColor = signInGrey
                                        )
                                    ) {

                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "BA",
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }

                                    Card(
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(35.dp),
                                        colors = CardDefaults.cardColors().copy(
                                            containerColor = signInGrey
                                        )
                                    ) {

                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "BSc",
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(25.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        colors = CardDefaults.cardColors().copy(
                            containerColor = cardColor
                        )
                    )
                    {
                        Spacer(modifier = Modifier.height(20.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Card(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(35.dp),
                                    colors = CardDefaults.cardColors().copy(
                                        containerColor = lightDodgerBlue
                                    )
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            "PG Courses",
                                            fontFamily = poppinsFontFamily,
                                            color = Color.White,
                                            fontSize = 12.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }


                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Column(modifier = Modifier.fillMaxSize()) {
                                Row(
                                    modifier = Modifier.fillMaxSize(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Card(
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(35.dp),
                                        colors = CardDefaults.cardColors().copy(
                                            containerColor = signInGrey
                                        )
                                    ) {

                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "BCA",
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }

                                    Card(
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(35.dp),
                                        colors = CardDefaults.cardColors().copy(
                                            containerColor = signInGrey
                                        )
                                    ) {

                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "BBA",
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                    Card(
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(35.dp),
                                        colors = CardDefaults.cardColors().copy(
                                            containerColor = signInGrey
                                        )
                                    ) {

                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "BCom",
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(top = 10.dp),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Card(
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(35.dp),
                                        colors = CardDefaults.cardColors().copy(
                                            containerColor = signInGrey
                                        )
                                    ) {

                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "BA",
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }

                                    Card(
                                        modifier = Modifier
                                            .width(100.dp)
                                            .height(35.dp),
                                        colors = CardDefaults.cardColors().copy(
                                            containerColor = signInGrey
                                        )
                                    ) {

                                        Column(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                "BSc",
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }

                }
            }
        }
    }
}


fun signOutAndNavigate(navController: NavController) {
    FirebaseAuth.getInstance().signOut()
    navController.navigate(BeforeLoginScreensNavigationObject.ONBOARDING_SCREEN) {
        popUpTo(0) // Clears all previous routes from backstack
    }
}


