package com.shettyharshith33.afterLoginScreens

import SetStatusBarColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.shettyharshith33.beforeLoginScreens.BeforeLoginScreensNavigationObject
import com.shettyharshith33.beforeLoginScreens.showMsg
import com.shettyharshith33.beforeLoginScreens.triggerVibration
import com.shettyharshith33.vcputtur.R
import com.shettyharshith33.vcputtur.ui.theme.cardColor
import com.shettyharshith33.vcputtur.ui.theme.lightDodgerBlue
import com.shettyharshith33.vcputtur.ui.theme.lightestDodgerBlue
import com.shettyharshith33.vcputtur.ui.theme.myGrey
import com.shettyharshith33.vcputtur.ui.theme.orange
import com.shettyharshith33.vcputtur.ui.theme.poppinsFontFamily
import com.shettyharshith33.vcputtur.ui.theme.signInGrey
import com.shettyharshith33.vcputtur.ui.theme.textColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val haptic = LocalHapticFeedback.current

    SetStatusBarColor(Color(lightDodgerBlue.toArgb()), useDarkIcons = false)
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet(modifier = Modifier, drawerContainerColor = lightDodgerBlue)
        {
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
                            .clickable {
                                context.showMsg("Nothing to show for now!")
                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                triggerVibration(context)
                            })
                }
                item {
                    Text("Campus",
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {})
                }
                item {
                    Text("Gallery",
                        color = Color.White,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {})
                }
//                item {
//                    Text("Settings",
//                        color = Color.White,
//                        fontFamily = poppinsFontFamily,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier
//                            .padding(16.dp)
//                            .clickable { /* handle click */ })
//                }


                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Sign Out",
                            color = Color.Black,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(16.dp)
                                .clickable {
                                    signOutAndNavigate(navController)
                                })
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "",
                            modifier = Modifier.clickable {
                                signOutAndNavigate(navController)
                            })
                    }

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
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 70.dp),
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFontFamily,
                        color = Color.White
                    )
                }, navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            drawerState.open()
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


                    Spacer(modifier = Modifier.height(20.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    ) {
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
                                painterResource(R.drawable.principal), contentDescription = "",
                                modifier = Modifier.fillParentMaxSize()
                            )
                        }

                        Text(
                            "Prof.Vishnu Ganapathi Bhat",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = orange
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Principal",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "MSc, MPhil",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            "Message from the Principal:",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 3.dp),
                            textAlign = TextAlign.Left,
                            color = textColor,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            "There underlies very great principle," +
                                    " a noble reason and an exemplary vision behind the founding of" +
                                    " Vivekananda College of Arts, Science and Commerce by Vivekananda " +
                                    "Vidyavardhaka Sangha way back in 1965 in Puttur. It is the very vision of" +
                                    " inculcating the spirit of nationalism. At a certain period in history, when there" +
                                    " seemed a possible hurdle in the practice of our traditions and belief systems, the initiative " +
                                    "for establishing an educational institution that upholds the practice" +
                                    " was taken up by a few scholars and thinkers of the region.",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 3.dp),
                            textAlign = TextAlign.Left,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Light,
                            lineHeight = 25.sp
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            "Accelerate your career with Vivekananda College",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 3.dp),
                            textAlign = TextAlign.Center,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = textColor
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))


                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .padding(10.dp)
                            .clip(shape = RoundedCornerShape(18.dp))
                    ) {

                        AutoScrollingImageCarousel(
                            imageList = listOf(
                                R.drawable.panchajanya,
                                R.drawable.hp_admissions_open,
                                R.drawable.varsha_aurdino
                            )
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .padding(8.dp)
                    ) {
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
                                onClick = {
                                    navController.navigate(
                                        BeforeLoginScreensNavigationObject.CGPA_CALCULATOR_SCREEN
                                    )
                                },
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
                                        modifier = Modifier
                                            .size(60.dp)
                                            .clickable {
                                                navController.navigate(
                                                    BeforeLoginScreensNavigationObject.ADMISSIONS_SCREEN
                                                )
                                            },
                                        alignment = Alignment.Center

                                    )
                                    Text(
                                        "Admissions",
                                        modifier = Modifier.clickable {
                                            navController.navigate(
                                                BeforeLoginScreensNavigationObject.ADMISSIONS_SCREEN
                                            )
                                        },
                                        fontFamily = poppinsFontFamily,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                            Card(
                                modifier = Modifier
                                    .size(100.dp)
                                    .clickable {
                                        navController.navigate(BeforeLoginScreensNavigationObject.ACADEMICS_SCREEN)
                                    },
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
                                        modifier = Modifier
                                            .size(60.dp)
                                            .clickable {
                                                navController.navigate(
                                                    BeforeLoginScreensNavigationObject.ACADEMICS_SCREEN
                                                )
                                            },
                                        alignment = Alignment.Center
                                    )
                                    Text(
                                        "Academics",
                                        modifier = Modifier
                                            .clickable {
                                                navController.navigate(
                                                    BeforeLoginScreensNavigationObject.ACADEMICS_SCREEN
                                                )
                                            },
                                        fontFamily = poppinsFontFamily,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                            Card(
                                modifier = Modifier
                                    .size(100.dp)
                                    .clickable {
                                        navController.navigate(BeforeLoginScreensNavigationObject.DEPARTMENTS)
                                    },
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
                                        modifier = Modifier
                                            .size(60.dp)
                                            .clickable {
                                                navController.navigate(
                                                    BeforeLoginScreensNavigationObject.DEPARTMENTS
                                                )
                                            },
                                        alignment = Alignment.Center
                                    )
                                    Text(
                                        "Departments",
                                        fontFamily = poppinsFontFamily,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier
                                            .clickable {
                                                navController.navigate(
                                                    BeforeLoginScreensNavigationObject.DEPARTMENTS
                                                )
                                            }
                                    )
                                }
                            }
                        }
//                        Spacer(modifier = Modifier.height(10.dp))
//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.SpaceEvenly
//                        ) {
//
//                            Card(
//                                modifier = Modifier.size(100.dp),
//                                colors = CardDefaults.cardColors().copy(
//                                    containerColor = signInGrey
//                                )
//                            ) {
//                                Column(
//                                    modifier = Modifier.fillMaxSize(),
//                                    horizontalAlignment = Alignment.CenterHorizontally,
//                                    verticalArrangement = Arrangement.Center
//                                ) {
//                                    Image(
//                                        painter = painterResource(R.drawable.exams),
//                                        contentDescription = "",
//                                        modifier = Modifier.size(60.dp),
//                                        alignment = Alignment.Center
//                                    )
//                                    Text(
//                                        "Examinations",
//                                        fontFamily = poppinsFontFamily,
//                                        fontSize = 12.sp,
//                                        fontWeight = FontWeight.SemiBold
//                                    )
//
//                                }
//                            }
//                            Card(
//                                modifier = Modifier.size(100.dp),
//                                colors = CardDefaults.cardColors().copy(
//                                    containerColor = signInGrey
//                                )
//                            )
//                            {
//                                Column(
//                                    modifier = Modifier.fillMaxSize(),
//                                    horizontalAlignment = Alignment.CenterHorizontally,
//                                    verticalArrangement = Arrangement.Center
//                                ) {
//                                    Image(
//                                        painter = painterResource(R.drawable.campus),
//                                        contentDescription = "",
//                                        modifier = Modifier.size(60.dp),
//                                        alignment = Alignment.Center
//                                    )
//                                    Text(
//                                        "Campus",
//                                        fontFamily = poppinsFontFamily,
//                                        fontSize = 12.sp,
//                                        fontWeight = FontWeight.SemiBold
//                                    )
//                                }
//                            }
//                            Card(
//                                modifier = Modifier.size(100.dp),
//                                colors = CardDefaults.cardColors().copy(
//                                    containerColor = signInGrey
//                                )
//                            ) {
//                                Column(
//                                    modifier = Modifier.fillMaxSize(),
//                                    horizontalAlignment = Alignment.CenterHorizontally,
//                                    verticalArrangement = Arrangement.Center
//                                ) {
//                                    Image(
//                                        painter = painterResource(R.drawable.gallery),
//                                        contentDescription = "",
//                                        modifier = Modifier
//                                            .size(60.dp)
//                                            .clickable {
//                                                navController.navigate(
//                                                    BeforeLoginScreensNavigationObject.GALLERY
//                                                )
//                                            },
//                                        alignment = Alignment.Center
//                                    )
//                                    Text(
//                                        "Gallery",
//                                        fontFamily = poppinsFontFamily,
//                                        fontSize = 12.sp,
//                                        fontWeight = FontWeight.SemiBold,
//                                        modifier = Modifier.clickable {
//                                            navController.navigate(
//                                                BeforeLoginScreensNavigationObject.GALLERY
//                                            )
//                                        }
//                                    )
//                                }
//                            }
//
//
//                        }
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
                                            .clickable {
                                                navController.navigate(
                                                    BeforeLoginScreensNavigationObject.BCA
                                                )
                                            }
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
                                                modifier = Modifier.clickable {
                                                    navController.navigate(
                                                        BeforeLoginScreensNavigationObject.BCA
                                                    )
                                                },
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }

                                    Card(
                                        modifier = Modifier
                                            .clickable {
                                                navController.navigate(
                                                    BeforeLoginScreensNavigationObject.BBA
                                                )
                                            }
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
                                                modifier = Modifier
                                                    .clickable {
                                                        navController.navigate(
                                                            BeforeLoginScreensNavigationObject.BBA
                                                        )
                                                    },
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                    Card(
                                        modifier = Modifier
                                            .clickable {
                                                navController.navigate(
                                                    BeforeLoginScreensNavigationObject.BCOM
                                                )
                                            }
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
                                                modifier = Modifier
                                                    .clickable {
                                                        navController.navigate(
                                                            BeforeLoginScreensNavigationObject.BCOM
                                                        )
                                                    },
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
                                            .clickable {
                                                navController.navigate(
                                                    BeforeLoginScreensNavigationObject.BA
                                                )
                                            }
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
                                                modifier = Modifier
                                                    .clickable {
                                                        navController.navigate(
                                                            BeforeLoginScreensNavigationObject.BA
                                                        )
                                                    },
                                                fontFamily = poppinsFontFamily,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                    }

                                    Card(
                                        modifier = Modifier
                                            .clickable {
                                                navController.navigate(
                                                    BeforeLoginScreensNavigationObject.BSC
                                                )
                                            }
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
                                                modifier = Modifier.clickable {
                                                    navController.navigate(
                                                        BeforeLoginScreensNavigationObject.BSC
                                                    )
                                                },
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
                                        .clickable {

                                        }
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
                                            .clickable {

                                            }
                                            .width(100.dp)
                                            .height(35.dp),
                                        colors = CardDefaults
                                            .cardColors()
                                            .copy(
                                                containerColor = signInGrey
                                            )
                                    ) {

                                        LazyColumn(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            item {
                                                Text(
                                                    "M.Com",
                                                    fontFamily = poppinsFontFamily,
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                        }
                                    }

                                    Card(
                                        modifier = Modifier
                                            .clickable {

                                            }
                                            .width(100.dp)
                                            .height(35.dp),
                                        colors = CardDefaults.cardColors().copy(
                                            containerColor = signInGrey
                                        )
                                    ) {

                                        LazyColumn(
                                            modifier = Modifier.fillMaxSize(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            item {
                                                Text(
                                                    "MSc",
                                                    fontFamily = poppinsFontFamily,
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                        }
                                    }
                                    Card(
                                        modifier = Modifier
                                            .clickable {

                                            }
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
                                                "MCJ",
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


@Composable
fun AutoScrollingImageCarousel(imageList: List<Int>) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    // Auto-scroll effect
    LaunchedEffect(Unit) {
        while (true) {
            delay(2000) // Wait 2 seconds
            val currentIndex = listState.firstVisibleItemIndex
            val nextIndex = (currentIndex + 1) % imageList.size
            coroutineScope.launch {
                listState.animateScrollToItem(nextIndex)
            }
        }
    }

    LazyRow(
        state = listState,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp), // Adjust height as needed
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(imageList.size) { index ->
            Image(
                modifier = Modifier
                    .fillParentMaxSize()
                    .clip(RoundedCornerShape(18.dp)),
                painter = painterResource(id = imageList[index]),
                contentDescription = "Staff Image $index"

            )
        }
    }
}


//
//package com.shettyharshith33.afterLoginScreens
//
//import SetStatusBarColor
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.rememberLazyListState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ExitToApp
//import androidx.compose.material.icons.filled.Menu
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.DrawerValue
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.ModalDrawerSheet
//import androidx.compose.material3.ModalNavigationDrawer
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarColors
//import androidx.compose.material3.rememberDrawerState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.toArgb
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import coil.compose.rememberAsyncImagePainter
//import com.google.firebase.auth.FirebaseAuth
//import com.shettyharshith33.beforeLoginScreens.BeforeLoginScreensNavigationObject
//import com.shettyharshith33.vcputtur.R
//import com.shettyharshith33.vcputtur.ui.theme.buttonYellow
//import com.shettyharshith33.vcputtur.ui.theme.cardColor
//import com.shettyharshith33.vcputtur.ui.theme.lightDodgerBlue
//import com.shettyharshith33.vcputtur.ui.theme.lightestDodgerBlue
//import com.shettyharshith33.vcputtur.ui.theme.myGrey
//import com.shettyharshith33.vcputtur.ui.theme.orange
//import com.shettyharshith33.vcputtur.ui.theme.poppinsFontFamily
//import com.shettyharshith33.vcputtur.ui.theme.signInGrey
//import com.shettyharshith33.vcputtur.ui.theme.textColor
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeScreen(navController: NavController) {
//    val scope = rememberCoroutineScope()
//    val context = LocalContext.current
//
//    // Set status bar color once
//    SetStatusBarColor(Color(lightDodgerBlue.toArgb()), useDarkIcons = false)
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//
//    // Pre-create drawer items to avoid recreating during recomposition
//    val drawerItems = remember {
//        listOf(
//            "Developers" to { /* handle click */ },
//            "Departments" to { /* handle click */ },
//            "Admissions" to {
//                navController.navigate(BeforeLoginScreensNavigationObject.ADMISSIONS_SCREEN)
//            },
//            "Examinations" to { /* handle click */ },
//            "Campus" to { /* handle click */ },
//            "Gallery" to {
//                navController.navigate(BeforeLoginScreensNavigationObject.GALLERY)
//            }
//        )
//    }
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            ModalDrawerSheet(
//                modifier = Modifier,
//                drawerContainerColor = lightDodgerBlue
//            ) {
//                LazyColumn {
//                    // Render drawer items efficiently
//                    items(drawerItems.size) { index ->
//                        val (text, onClick) = drawerItems[index]
//                        Text(
//                            text,
//                            fontFamily = poppinsFontFamily,
//                            fontWeight = FontWeight.Bold,
//                            color = Color.White,
//                            modifier = Modifier
//                                .padding(16.dp)
//                                .clickable(onClick = onClick)
//                        )
//                    }
//
//                    item {
//                        Row(
//                            verticalAlignment = Alignment.CenterVertically,
//                            horizontalArrangement = Arrangement.SpaceBetween,
//                            modifier = Modifier.clickable {
//                                signOutAndNavigate(navController)
//                            }
//                        ) {
//                            Text(
//                                "Sign Out",
//                                color = Color.Black,
//                                fontFamily = poppinsFontFamily,
//                                fontWeight = FontWeight.Bold,
//                                modifier = Modifier.padding(16.dp)
//                            )
//                            Icon(
//                                imageVector = Icons.Default.ExitToApp,
//                                contentDescription = "Sign Out"
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    ) {
//        Scaffold(
//            topBar = {
//                TopAppBar(
//                    modifier = Modifier.height(60.dp),
//                    colors = TopAppBarColors(
//                        containerColor = lightDodgerBlue,
//                        scrolledContainerColor = Color.Transparent,
//                        navigationIconContentColor = lightDodgerBlue,
//                        titleContentColor = lightDodgerBlue,
//                        actionIconContentColor = lightDodgerBlue
//                    ),
//                    title = {
//                        Text(
//                            text = "VC Puttur",
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(start = 70.dp),
//                            fontWeight = FontWeight.Bold,
//                            fontFamily = poppinsFontFamily,
//                            color = Color.White
//                        )
//                    },
//                    navigationIcon = {
//                        IconButton(onClick = {
//                            scope.launch {
//                                drawerState.open()
//                            }
//                        }) {
//                            Icon(
//                                imageVector = Icons.Default.Menu,
//                                contentDescription = "Menu Icon",
//                                tint = Color.White
//                            )
//                        }
//                    }
//                )
//            },
//            containerColor = myGrey
//        ) { innerPadding ->
//            HomeContent(innerPadding, navController)
//        }
//    }
//}
//
//@Composable
//private fun HomeContent(innerPadding: PaddingValues, navController: NavController) {
//    // Extract content into a separate composable for better recomposition
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(lightestDodgerBlue)
//            .padding(innerPadding)
//    ) {
//        item { PrincipalSection() }
//        item {
//            Spacer(modifier = Modifier.height(20.dp))
//            ImageCarouselCard()
//        }
//        item { CgpaCalculatorCard(navController) }
//        item { QuickAccessHeader() }
//        item { QuickAccessGrid(navController) }
//        item { CoursesHeader() }
//        item { UgCoursesCard(navController) }
//        item { PgCoursesCard() }
//    }
//}
//
//@Composable
//private fun PrincipalSection() {
//    Spacer(modifier = Modifier.height(20.dp))
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//    ) {
//        // Principal's image
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(250.dp)
//                .padding(10.dp)
//                .shadow(
//                    elevation = 14.dp,
//                    shape = RoundedCornerShape(12.dp),
//                    ambientColor = Color.LightGray
//                )
//        ) {
//            // Use ContentScale.Crop for more efficient rendering
//            Image(
//                painterResource(R.drawable.principal),
//                contentDescription = "Principal's Photo",
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
//        }
//
//        // Principal's details
//        Text(
//            "Prof.Vishnu Ganapathi Bhat",
//            modifier = Modifier.fillMaxWidth(),
//            textAlign = TextAlign.Center,
//            fontFamily = poppinsFontFamily,
//            fontWeight = FontWeight.Bold,
//            fontSize = 18.sp,
//            color = orange
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(
//            "Principal",
//            modifier = Modifier.fillMaxWidth(),
//            textAlign = TextAlign.Center,
//            fontFamily = poppinsFontFamily,
//            fontWeight = FontWeight.Bold,
//            color = Color.Black
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(
//            "MSc, MPhil",
//            modifier = Modifier.fillMaxWidth(),
//            textAlign = TextAlign.Center,
//            fontFamily = poppinsFontFamily,
//            fontWeight = FontWeight.SemiBold
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        // Principal's message
//        Text(
//            "Message from the Principal:",
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 3.dp),
//            textAlign = TextAlign.Left,
//            color = textColor,
//            fontFamily = poppinsFontFamily,
//            fontWeight = FontWeight.SemiBold
//        )
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Text(
//            "There underlies very great principle, a noble reason and an" +
//                    " exemplary vision behind the founding of Vivekananda College of Arts, " +
//                    "Science and Commerce by Vivekananda Vidyavardhaka Sangha way back in 1965 " +
//                    "in Puttur. It is the very vision of inculcating the spirit of nationalism." +
//                    " At a certain period in history, when there seemed a possible hurdle in the " +
//                    "practice of our traditions and belief systems, the initiative for " +
//                    "establishing an educational institution that upholds the practice was taken " +
//                    "up by a few scholars and thinkers of the region.",
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 3.dp),
//            textAlign = TextAlign.Left,
//            fontFamily = poppinsFontFamily,
//            fontWeight = FontWeight.Light,
//            lineHeight = 25.sp
//        )
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Text(
//            "Accelerate your career with Vivekananda College",
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 3.dp),
//            textAlign = TextAlign.Center,
//            fontFamily = poppinsFontFamily,
//            fontWeight = FontWeight.Bold,
//            fontSize = 16.sp,
//            color = textColor
//        )
//    }
//}
//
//@Composable
//private fun ImageCarouselCard() {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(250.dp)
//            .padding(10.dp)
//            .clip(shape = RoundedCornerShape(18.dp))
//    ) {
//        AutoScrollingImageCarousel(
//            imageList = listOf(
//                R.drawable.panchajanya,
//                R.drawable.hp_admissions_open,
//                R.drawable.varsha_aurdino,
//                R.drawable.admissions
//            )
//        )
//    }
//}
//
//@Composable
//private fun CgpaCalculatorCard(navController: NavController) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clip(RoundedCornerShape(12.dp))
//            .padding(8.dp)
//    ) {
//        Text(
//            "CGPA Calculator",
//            modifier = Modifier.padding(start = 15.dp),
//            fontSize = 18.sp,
//            fontFamily = poppinsFontFamily,
//            fontWeight = FontWeight.SemiBold
//        )
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Button(
//                onClick = {
//                    navController.navigate(
//                        BeforeLoginScreensNavigationObject.CGPA_CALCULATOR_SCREEN
//                    )
//                },
//                colors = ButtonDefaults.buttonColors().copy(
//                    containerColor = lightDodgerBlue
//                )
//            ) {
//                Text(
//                    "Calculate Your CGPA",
//                    fontFamily = poppinsFontFamily,
//                    fontWeight = FontWeight.SemiBold
//                )
//            }
//        }
//    }
//}
//
//@Composable
//private fun QuickAccessHeader() {
//    Spacer(modifier = Modifier.height(10.dp))
//    Text(
//        "Quick Access",
//        modifier = Modifier.padding(start = 15.dp),
//        fontSize = 18.sp,
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.SemiBold
//    )
//}
//
//@Composable
//private fun QuickAccessGrid(navController: NavController) {
//    // Pre-define quick access items to prevent recreations
//    val quickAccessItems = remember {
//        listOf(
//            Triple(R.drawable.admissions, "Admissions") {
//                navController.navigate(BeforeLoginScreensNavigationObject.ADMISSIONS_SCREEN)
//            },
//            Triple(R.drawable.academics, "Academics") {},
//            Triple(R.drawable.departments, "Departments") { /* Click action */ },
//            Triple(R.drawable.exams, "Examinations") { /* Click action */ },
//            Triple(R.drawable.campus, "Campus") { /* Click action */ },
//            Triple(R.drawable.gallery, "Gallery") {
//                navController.navigate(BeforeLoginScreensNavigationObject.GALLERY)
//            }
//        )
//    }
//
//    Column(modifier = Modifier.fillMaxWidth()) {
//        // First row of quick access items
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            for (i in 0 until 3) {
//                QuickAccessItem(
//                    iconResId = quickAccessItems[i].first,
//                    text = quickAccessItems[i].second,
//                    onClick = quickAccessItems[i].third
//                )
//            }
//        }
//
//        Spacer(modifier = Modifier.height(10.dp))
//
//        // Second row of quick access items
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            for (i in 3 until 6) {
//                QuickAccessItem(
//                    iconResId = quickAccessItems[i].first,
//                    text = quickAccessItems[i].second,
//                    onClick = quickAccessItems[i].third
//                )
//            }
//        }
//    }
//}
//
//@Composable
//private fun QuickAccessItem(iconResId: Int, text: String, onClick: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .size(100.dp)
//            .clickable(onClick = onClick),
//        colors = CardDefaults.cardColors().copy(
//            containerColor = signInGrey
//        )
//    ) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Image(
//                painter = painterResource(iconResId),
//                contentDescription = text,
//                modifier = Modifier.size(60.dp),
//                alignment = Alignment.Center
//            )
//            Text(
//                text,
//                fontFamily = poppinsFontFamily,
//                fontSize = 12.sp,
//                fontWeight = FontWeight.SemiBold
//            )
//        }
//    }
//}
//
//@Composable
//private fun CoursesHeader() {
//    Spacer(modifier = Modifier.height(10.dp))
//    Text(
//        "Courses",
//        modifier = Modifier.padding(start = 15.dp),
//        fontSize = 18.sp,
//        fontFamily = poppinsFontFamily,
//        fontWeight = FontWeight.SemiBold
//    )
//}
//
//@Composable
//private fun UgCoursesCard(navController: NavController) {
//    // Pre-define UG courses to prevent recreations
//    val ugCourses = remember {
//        listOf(
//            Pair("BCA") { navController.navigate(BeforeLoginScreensNavigationObject.BCA) },
//            Pair("BBA") {navController.navigate(BeforeLoginScreensNavigationObject.BBA)},
//            Pair("BCom") {navController.navigate(BeforeLoginScreensNavigationObject.BCOM)},
//            Pair("BA") {navController.navigate(BeforeLoginScreensNavigationObject.BA)},
//            Pair("BSc") {navController.navigate(BeforeLoginScreensNavigationObject.BSC)}
//        )
//    }
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(20.dp)
//            .clip(RoundedCornerShape(5.dp)),
//        colors = CardDefaults.cardColors().copy(
//            containerColor = cardColor
//        )
//    ) {
//        Spacer(modifier = Modifier.height(20.dp))
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            // UG courses header
//            Card(
//                modifier = Modifier
//                    .width(100.dp)
//                    .height(35.dp),
//                colors = CardDefaults.cardColors().copy(
//                    containerColor = lightDodgerBlue
//                )
//            ) {
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    Text(
//                        "UG Courses",
//                        fontFamily = poppinsFontFamily,
//                        color = Color.White,
//                        fontSize = 12.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            // First row of UG courses
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                for (i in 0 until 3) {
//                    CourseItem(
//                        courseName = ugCourses[i].first,
//                        onClick = ugCourses[i].second
//                    )
//                }
//            }
//
//            // Second row of UG courses
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 10.dp),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                for (i in 3 until 5) {
//                    CourseItem(
//                        courseName = ugCourses[i].first,
//                        onClick = ugCourses[i].second
//                    )
//                }
//            }
//        }
//        Spacer(modifier = Modifier.height(20.dp))
//    }
//}
//
//@Composable
//private fun PgCoursesCard() {
//    // Pre-define PG courses to prevent recreations
//    val pgCourses = remember {
//        listOf(
//            "M.Com" to { /* Click action */ },
//            "MSc" to { /* Click action */ },
//            "MCJ" to { /* Click action */ }
//        )
//    }
//
//    Spacer(modifier = Modifier.height(25.dp))
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(20.dp)
//            .clip(RoundedCornerShape(5.dp)),
//        colors = CardDefaults.cardColors().copy(
//            containerColor = cardColor
//        )
//    ) {
//        Spacer(modifier = Modifier.height(20.dp))
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            // PG courses header
//            Card(
//                modifier = Modifier
//                    .width(100.dp)
//                    .height(35.dp),
//                colors = CardDefaults.cardColors().copy(
//                    containerColor = lightDodgerBlue
//                )
//            ) {
//                Column(
//                    modifier = Modifier.fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    Text(
//                        "PG Courses",
//                        fontFamily = poppinsFontFamily,
//                        color = Color.White,
//                        fontSize = 12.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            // Row of PG courses
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                pgCourses.forEach { (courseName, onClick) ->
//                    CourseItem(
//                        courseName = courseName,
//                        onClick = onClick
//                    )
//                }
//            }
//        }
//        Spacer(modifier = Modifier.height(20.dp))
//    }
//}
//
//@Composable
//private fun CourseItem(courseName: String, onClick: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .clickable(onClick = onClick)
//            .width(100.dp)
//            .height(35.dp),
//        colors = CardDefaults.cardColors().copy(
//            containerColor = signInGrey
//        )
//    ) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(
//                courseName,
//                fontFamily = poppinsFontFamily,
//                fontSize = 12.sp,
//                fontWeight = FontWeight.Bold
//            )
//        }
//    }
//}
//
//@Composable
//fun AutoScrollingImageCarousel(imageList: List<Int>) {
//    val listState = rememberLazyListState()
//    val coroutineScope = rememberCoroutineScope()
//
//    // Auto-scroll effect
//    LaunchedEffect(Unit) {
//        while (true) {
//            delay(2000) // Wait 2 seconds
//            val currentIndex = listState.firstVisibleItemIndex
//            val nextIndex = (currentIndex + 1) % imageList.size
//            coroutineScope.launch {
//                listState.animateScrollToItem(nextIndex)
//            }
//        }
//    }
//
//    LazyRow(
//        state = listState,
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(250.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//        contentPadding = PaddingValues(horizontal = 16.dp)
//    ) {
//        items(imageList.size) { index ->
//            Image(
//                modifier = Modifier
//                    .fillParentMaxSize()
//                    .clip(RoundedCornerShape(18.dp)),
//                painter = painterResource(id = imageList[index]),
//                contentDescription = "Carousel Image $index",
//                contentScale = ContentScale.Crop
//            )
//        }
//    }
//}
//
//fun signOutAndNavigate(navController: NavController) {
//    FirebaseAuth.getInstance().signOut()
//    navController.navigate(BeforeLoginScreensNavigationObject.ONBOARDING_SCREEN) {
//        popUpTo(0) // Clears all previous routes from backstack
//    }
//}