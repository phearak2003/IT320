package com.phearak.aba_mobile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.phearak.aba_mobile.ui.theme.Main
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
                        text = "Payments ",
                        textAlign = TextAlign.Start,
                        color = White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(bottom = 7.dp)
                    )
                    Text(
                        text = "Top-up phone, pay for utility bills and",
                        textAlign = TextAlign.Start,
                        color = Color(0xFFBEDADD),
                        fontSize = 12.sp
                    )
                    Text(
                        text = " many other popular services free of charge.",
                        textAlign = TextAlign.Start,
                        color = Color(0xFFBEDADD),
                        fontSize = 12.sp
                    )
                }
            }
            Box(
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dollar),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(110.dp)
                        .padding(start = 290.dp)
                )
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
                        PaymentBox(
                            R.drawable.p_phone,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Mobile Top-up",
                            "Supported operators: ",
                            R.drawable.cellcard,
                            R.drawable.smart,
                            R.drawable.metfone,
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
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(start = 10.dp, top = 3.dp)

                            )
                            Text(
                                text = "Search",
                                color = White,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(top = 12.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PaymentBox(icon: Int, iconBackground: Brush, name:String, des:String, icon1: Int, icon2:Int, icon3: Int){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 0.dp, start = 10.dp, end = 10.dp)
            .background(color = Color(0xFF1D2F38), shape = RoundedCornerShape(5.dp)),
        horizontalArrangement = Arrangement.Start,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .padding(top = 12.dp),
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
                        .size(36.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp)

        ) {
            Text(
                text = name,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                color = White,
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
            Row {
                Text(
                    text = des,
                    textAlign = TextAlign.Start,
                    fontSize = 10.sp,
                    color = Color(0xFF88939D),
                    modifier = Modifier.padding(start = 8.dp, top = 3.dp, bottom = 17.dp),
                    lineHeight = 15.sp
                )
                Row (
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(bottom = 14.dp)
                ){
                    Box(
                        modifier = Modifier
                            .size(30.dp, height = 10.dp)
                            .padding(start = 5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = icon1),
                            contentDescription = null,
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(18.dp, height = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = icon2),
                            contentDescription = null,
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(30.dp, height = 10.dp)
                            .padding(start = 5.dp)
                    ) {
                        Image(
                            painter = painterResource(id = icon3),
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }
}
