package com.phearak.aba_mobile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import com.phearak.aba_mobile.ui.theme.Main
import com.phearak.aba_mobile.ui.theme.Secondary
import com.phearak.aba_mobile.ui.theme.bg

@Preview(showSystemUi = true)
@Composable
fun PaymentPreview() {
    val navController = rememberNavController()
    Payment(navController = navController)
}

@Composable
fun PaymentScreen(navController: NavController) {
    Payment(navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Payment(navController: NavController) {
    Surface {
        Scaffold(
            containerColor = Main,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(Main),
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
                                text = " Payments",
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
            PaymentBody()
        }
    }
}

@Composable
fun PaymentBody() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp)
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
                        text = "Payments ",
                        textAlign = TextAlign.Start,
                        color = White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(bottom = 7.dp)
                    )
                    Text(
                        text = "Top-up phone, pay for utility bills and many other popular services free of charge.",
                        textAlign = TextAlign.Start,
                        color = Color(0xFFBEDADD),
                        fontSize = 12.sp
                    )
                }
                Box() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_service),
                        contentDescription = null,
                        modifier = Modifier
                            .background(
                                shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
                                color = Main
                            )
                            .width(200.dp)
                            .height(150.dp)
                            .alpha(0.5f),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
            Box(
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 110.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(color = bg)
                ) {
                    Column (
                        modifier = Modifier
                            .padding(top = 25.dp)
                    ){
                        TransferBox(
                            R.drawable.p_fav,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Choose from Favorites",
                            "Pay bills from your favorites list"
                        )
                        TransferBox(
                            R.drawable.p_phone,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Mobile Top-up",
                            "Supported operators: "
                        )
                        TransferBox(
                            R.drawable.p_plug,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Utilities",
                            "Pay for electricity, water and waste bills"
                        )
                        TransferBox(
                            R.drawable.p_castle,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Government Services",
                            "Pay for taxes or public services"
                        )
                        TransferBox(
                            R.drawable.p_wifi,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Internet & TV",
                            "Pay your internet and TV bills"
                        )
                        TransferBox(
                            R.drawable.p_home,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Real Estate",
                            "Pay for property"
                        )
                        TransferBox(
                            R.drawable.p_umbrella,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Insurance",
                            "Pay for insurance premiums"
                        )
                        TransferBox(
                            R.drawable.p_holddollar,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Finance & Distribution",
                            "Pay trading partners or distributors "
                        )
                        TransferBox(
                            R.drawable.p_education,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Education",
                            "Pay for school fees"
                        )
                        TransferBox(
                            R.drawable.p_game,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Entertainment",
                            "Shop for credit for games and apps"
                        )
                        TransferBox(
                            R.drawable.p_card,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Membership & Subscription",
                            "Pay for your subscriptions"
                        )
                        TransferBox(
                            R.drawable.p_case,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Travel & Tours",
                            "Pay to travel service-providers"
                        )
                        TransferBox(
                            R.drawable.p_love,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Charity & Donation",
                            "Donate to charitable organizations"
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        . padding(start = 15.dp, top= 90.dp, end = 15.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xFF1D2F38),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .fillMaxWidth()
                            .size(40.dp),
                        contentAlignment = Alignment.CenterStart,
                    ) {
                        Text(
                            text = "Search",
                            color = White,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .padding(start = 40.dp)
                        )
                    }
                }
            }
        }
    }
}
