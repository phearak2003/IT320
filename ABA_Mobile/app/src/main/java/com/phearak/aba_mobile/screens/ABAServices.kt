package com.phearak.aba_mobile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.phearak.aba_mobile.R
import com.phearak.aba_mobile.ui.theme.Secondary

@Preview(showSystemUi = true)
@Composable
fun ServicesScreenPreview() {
    val navController = rememberNavController()
    ComposeServices(navController = navController)
}

@Composable
fun ServicesScreen(navController: NavController) {
    ComposeServices(navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeServices(navController: NavController) {
    Surface {
        Scaffold(
                containerColor = Secondary,
                topBar = {
                    TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(Secondary),
                            modifier = Modifier.height(60.dp),
                            title = {
                                Row(
                                        modifier = Modifier.padding(top = 10.dp)
                                ) {
                                    Text(
                                            text = "ABA",
                                            fontWeight = FontWeight.Bold,
                                            textAlign = TextAlign.Center,
                                            fontSize = 18.sp,
                                            color = White,
                                    )
                                    Text(
                                            text = "'",
                                            fontWeight = FontWeight.Bold,
                                            textAlign = TextAlign.Center,
                                            fontSize = 24.sp,
                                            color = Color.Red,
                                    )
                                    Text(
                                            text = " Services",
                                            fontWeight = FontWeight.Bold,
                                            textAlign = TextAlign.Center,
                                            fontSize = 18.sp,
                                            color = White,
                                    )
                                }
                            },

                            navigationIcon = {
                                IconButton(onClick = { navController.navigate("home") }) {
                                    Image(
                                            painter = painterResource(id = R.drawable.ic_back),
                                            contentDescription = "Back",
                                            modifier = Modifier.size(20.dp)
                                    )
                                }
                            }
                    )
                },
                bottomBar = {

                }
        ) {
            composeServiceBody()
        }
    }
}

@Composable
fun composeServiceBody() {
    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .verticalScroll(rememberScrollState())
    ) {
        Box {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp)) {
                Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.fillMaxWidth(0.7f)
                ) {
                    Text(
                            text = "Services ",
                            textAlign = TextAlign.Start,
                            color = White,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                    )
                    Text(
                            text = "Get instant access to your favorite service provide by external partnership",
                            textAlign = TextAlign.Start,
                            color = White,
                            fontSize = 12.sp,
                    )
                }
                Box(Modifier.padding()) {
                    Image(
                            painter = painterResource(id = R.drawable.ic_service),
                            contentDescription = null,
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                                    color = Secondary
                                )
                                .width(200.dp)
                                .height(150.dp)
                                .alpha(0.5f), // Change the opacity here
                            contentScale = ContentScale.FillBounds
                    )
                }
            }
            Column(
                    modifier = Modifier
                            .padding(top = 100.dp)
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(Color(0xFF0F1A25))
            ) {
                Column(modifier = Modifier.padding(15.dp)) {
                    Text(
                            text = "Essentials",
                            textAlign = TextAlign.Start,
                            color = White,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(bottom = 10.dp),
                            fontWeight = FontWeight.Bold
                    )
                    Box {
                        cardWithRoundIcon(
                                R.drawable.pc_cinema,
                                R.drawable.ic_cimea,
                                orangePurpleLightBlueGradient,
                                "Cinema Ticket",
                                "Book tickets for the latest movies in cinemas with hassle-free payment",
                                250
                        )
                        Box(
                                modifier = Modifier
                                        .fillMaxWidth(0.48f)
                                        .fillMaxHeight(0.1f)
                                        .padding(top = 22.dp)
                                        .background(
                                                color = Color(0xffEE5351),
                                                shape = RoundedCornerShape(topStart = 2.dp, bottomStart = 2.dp)
                                        ),

                                contentAlignment = Alignment.Center
                        ) {
                            Text(
                                    text = "15% off Prime Complex",
                                    textAlign = TextAlign.Center,
                                    color = White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                            )

                        }
                    }
                }
                Column(modifier = Modifier
                        .padding(15.dp)
                        .fillMaxSize()) {
                    Text(
                            text = "Goverments Services",
                            textAlign = TextAlign.Start,
                            color = White,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(bottom = 10.dp),
                            fontWeight = FontWeight.Bold
                    )

                    Row(
                            modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState())
                    ) {
                        Box(
                                modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                    R.drawable.pc_domain,
                                    R.drawable.ic_domain_blue,
                                    linearGradient(
                                            colors = listOf(Color(0xFF004081), Color(0xFF002340)) // Example gradient from dark blue to light blue
                                    ),
                                    "Domain .kh",
                                    "Domain Name .kh Registration",
                                    200
                            )
                        }
                        Box(
                                modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                    R.drawable.pc_cartax,
                                    R.drawable.ic_tax,
                                    linearGradient(
                                            colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                    ),
                                    "Road Tax",
                                    "General Department of Taxation",
                                    200
                            )
                        }
                        Box(
                                modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                    R.drawable.pc_propertytax,
                                    R.drawable.ic_tax,
                                    linearGradient(
                                            colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                    ),
                                    "Property Tax",
                                    "General Department of Taxation",
                                    200
                            )
                        }
                        Box(
                                modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                    R.drawable.pc_prefillingtax,
                                    R.drawable.ic_tax,
                                    linearGradient(
                                            colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                    ),
                                    "Prefilling Tax",
                                    "General Department of Taxation",
                                    200
                            )
                        }
                    }

                }
                Column(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()) {
                    Text(
                        text = "Travel & Tours",
                        textAlign = TextAlign.Start,
                        color = White,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 10.dp),
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                    ) {
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_domain,
                                R.drawable.ic_domain_blue,
                                linearGradient(
                                    colors = listOf(Color(0xFF004081), Color(0xFF002340)) // Example gradient from dark blue to light blue
                                ),
                                "Tovtrio",
                                "Your new adventure awaits!  " +
                                        " Tourtrip empower the local",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_cartax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Road Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_propertytax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Property Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_prefillingtax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Prefilling Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                    }

                }
                Column(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()) {
                    Text(
                        text = "Transportation",
                        textAlign = TextAlign.Start,
                        color = White,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 10.dp),
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                    ) {
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_domain,
                                R.drawable.ic_domain_blue,
                                linearGradient(
                                    colors = listOf(Color(0xFF004081), Color(0xFF002340)) // Example gradient from dark blue to light blue
                                ),
                                "Domain .kh",
                                "Domain Name .kh Registration",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_cartax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Road Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_propertytax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Property Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_prefillingtax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Prefilling Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                    }
                }
                Column(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()) {
                    Text(
                        text = "Education & Training",
                        textAlign = TextAlign.Start,
                        color = White,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 10.dp),
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                    ) {
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_domain,
                                R.drawable.ic_domain_blue,
                                linearGradient(
                                    colors = listOf(Color(0xFF004081), Color(0xFF002340)) // Example gradient from dark blue to light blue
                                ),
                                "Domain .kh",
                                "Domain Name .kh Registration",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_cartax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Road Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_propertytax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Property Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_prefillingtax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Prefilling Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                    }
                }
                Column(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()) {
                    Text(
                        text = "Entertainment",
                        textAlign = TextAlign.Start,
                        color = White,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 10.dp),
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                    ) {
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_domain,
                                R.drawable.ic_domain_blue,
                                linearGradient(
                                    colors = listOf(Color(0xFF004081), Color(0xFF002340)) // Example gradient from dark blue to light blue
                                ),
                                "Domain .kh",
                                "Domain Name .kh Registration",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_cartax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Road Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_propertytax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Property Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_prefillingtax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Prefilling Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                    }
                }
                Column(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()) {
                    Text(
                        text = "Technology",
                        textAlign = TextAlign.Start,
                        color = White,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 10.dp),
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                    ) {
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_domain,
                                R.drawable.ic_domain_blue,
                                linearGradient(
                                    colors = listOf(Color(0xFF004081), Color(0xFF002340)) // Example gradient from dark blue to light blue
                                ),
                                "Domain .kh",
                                "Domain Name .kh Registration",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_cartax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Road Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_propertytax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Property Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                        Box(
                            modifier = Modifier.width(300.dp) // Use weight modifier instead of width
                        ) {
                            cardWithRoundIcon(
                                R.drawable.pc_prefillingtax,
                                R.drawable.ic_tax,
                                linearGradient(
                                    colors = listOf(Color(0xFFffffff), Color(0xFFffffff)) // Example gradient from dark blue to light blue
                                ),
                                "Prefilling Tax",
                                "General Department of Taxation",
                                200
                            )
                        }
                    }
                }
            }
        }
    }
}

val orangePurpleLightBlueGradient = linearGradient(
        colors = listOf(
                Color(0xFFFFA500), // Orange
                Color(0xFF800080), // Purple
                Color(0xFFADD8E6)  // Light Blue
        )
)

@Composable
fun cardWithRoundIcon(image: Int, icon: Int, iconBackground: Brush, name: String, des: String, height: Int) {
    Column(
            modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp)
                    .background(Color.Transparent, shape = RoundedCornerShape(15.dp))
                    .height(height.dp)
    ) {
        Box(
                Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.7f)
                        .background(
                                color = Color.Transparent,
                                shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
                        )
        ) {
            Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                            .background(
                                    shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                                    color = Secondary
                            )
                            .fillMaxSize(),
                    contentScale = ContentScale.FillWidth
            )
        }
        Box(
                Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(
                                Color(0xFF1D2B37),
                                shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
                        )
        ) {
            Row(
                    modifier = Modifier
                            .fillMaxSize()
                            .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
            ) {
                Column(
                        modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.2f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Box(
                            modifier = Modifier
                                    .size(40.dp)
                                    .background(shape = CircleShape, brush = iconBackground)
                                    .border(shape = CircleShape, width = 1.dp, color = White)
                                    .size(40.dp),
                            contentAlignment = Alignment.Center,
                    ) {
                        Image(
                                painter = painterResource(id = icon),
                                contentDescription = null,
                                modifier = Modifier
                                        .size(25.dp),
                                contentScale = ContentScale.Crop
                        )
                    }
                }
                Box(
                        contentAlignment = Alignment.TopStart,
                        modifier = Modifier
                                .fillMaxHeight()
                                .padding(top = 8.dp)

                ) {
                    Text(
                            text = name,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Bold,
                            color = White,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                            text = des,
                            textAlign = TextAlign.Start,
                            fontSize = 12.sp,
                            color = Color(0xFF89949F),
                            modifier = Modifier.padding(start = 10.dp, top = 20.dp),
                            lineHeight = 12.sp
                    )
                }

            }
        }
    }
}


