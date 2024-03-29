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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.phearak.aba_mobile.ui.theme.Main
import com.phearak.aba_mobile.ui.theme.Primary
import com.phearak.aba_mobile.ui.theme.Secondary
import com.phearak.aba_mobile.ui.theme.bg

@Preview(showSystemUi = true)
@Composable
fun TransferPreview() {
    val navController = rememberNavController()
    Transfer(navController = navController)
}

@Composable
fun TransferScreen(navController: NavController) {
    Transfer(navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Transfer(navController: NavController) {
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
                                text = " Transfers",
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
            TransferBody()
        }
    }
}

@Composable
fun TransferBody() {
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
                        text = "Transfers ",
                        textAlign = TextAlign.Start,
                        color = White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(bottom = 7.dp)
                    )
                    Text(
                        text = "Transfer money to your friends,",
                        textAlign = TextAlign.Start,
                        color = Color(0xFFBEDADD),
                        fontSize = 12.sp,
                    )
                    Text(
                        text = "relatives or partners in couple of simple steps.",
                        textAlign = TextAlign.Start,
                        color = Color(0xFFBEDADD),
                        fontSize = 12.sp,
                    )
                }
            }
            Box(
            ) {
                Image(
                    painter = painterResource(id = R.drawable.transfer),
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
                            "Transfer to friends from your favorite list"
                        )
                        TransferBox(
                            R.drawable.t_profile,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Transfer to own ABA account",
                            "Make a transfer to your own account"
                        )
                        TransferBox(
                            R.drawable.t_transfer,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Transfer to other ABA account",
                            "Transfer money to other ABA customers"
                        )
                        TransferBox(
                            R.drawable.t_ecash,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Send money to ABA ATM's",
                            "Make cardless cash withdrawal at any ABA ATM"
                        )
                        TransferBox(
                            R.drawable.t_wallet,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "Transfer to Local Banks & Wallets",
                            "Make transfer to banks or wallets in Cambodia"
                        )
                        TransferBox(
                            R.drawable.t_world,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "International Transfer",
                            "Send money abroad via various channels"
                        )
                        TransferCard(
                            R.drawable.t_transcard,
                            linearGradient(
                                colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                            ),
                            "International Transfer",
                            "Send money abroad via various channels",
                            R.drawable.ic_visa,
                            R.drawable.ic_mastercard,
                            R.drawable.ic_visa
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
                        contentAlignment = Alignment.CenterStart

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
fun TransferBox(icon: Int, iconBackground: Brush, name:String, des:String){
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
            Text(
                text = des,
                textAlign = TextAlign.Start,
                fontSize = 10.sp,
                color = Color(0xFF88939D),
                modifier = Modifier.padding(start = 8.dp, top = 3.dp, bottom = 17.dp),
                lineHeight = 15.sp
            )
        }
    }
}

@Composable
fun TransferCard(icon: Int, iconBackground: Brush, name:String, des:String, icon1: Int, icon2: Int, icon3: Int){
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
                .padding(top = 18.dp),
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
            Row (
            ){
                Text(
                    text = name,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    color = White,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 7.dp)
                )
                Image(
                    painter = painterResource(id = icon1),
                    contentDescription = des,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(start = 3.dp)
                )
                Image(
                    painter = painterResource(id = icon2),
                    contentDescription = des,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 3.dp)
                )
                Image(
                    painter = painterResource(id = icon3),
                    contentDescription = des,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 3.dp)
                )
            }
            Text(
                text = des,
                textAlign = TextAlign.Start,
                fontSize = 10.sp,
                color = Color(0xFF88939D),
                modifier = Modifier.padding(start = 8.dp, top = 3.dp, bottom = 17.dp),
                lineHeight = 15.sp
            )
        }
    }
}