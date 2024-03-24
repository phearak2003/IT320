package com.phearak.aba_mobile.screens

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.phearak.aba_mobile.R

val BackgroundBlue = Color(0xFF38525F)
val BackgroundTransfer = Color(0xFF212D39)
val Secondary = Color(0xFF042335)

@Preview(showSystemUi = true)
@Composable
fun TransfersScreenPreview(){
    val navController = rememberNavController()
    ComposeTransfer(navController = navController)
}

@Composable
fun TransfersScreen(navController: NavController) {
    ComposeTransfer(navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeTransfer(navController: NavController) {
    Surface() {
        Scaffold(
            containerColor = Secondary,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(Secondary),
                    modifier = Modifier.height(60.dp),
                    title = {
                        Row(
                            modifier = Modifier.padding(top=10.dp)
                        ) {
                            Text(
                                text = "ABA",
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp,
                                color = Color.White,
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
                                color = Color.White,
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
                BottomAppBar(
                    modifier = Modifier.height(48.dp),
                    containerColor = Color(0xffEE5351)
                ) {
                    Text(
                        text = "Send",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        textDecoration = TextDecoration.Underline,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        ) {
            composeTransferBody()
        }
    }
}
@Composable
fun composeTransferBody(){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp),
            contentAlignment = Alignment.TopCenter
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Box(
                    modifier = Modifier
                        .size(90.dp)
                        .background(shape = CircleShape, color = BackgroundBlue),
                    contentAlignment = Alignment.Center,
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(160.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pic_ecash),
                            contentDescription = "Ecash",
                            modifier = Modifier.size(160.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Text(
                    text = "Cash to ATM",
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top=10.dp,bottom=60.dp)
                )
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(BackgroundTransfer) // Set white background
                ) {
                    Box {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(78.dp)
                                .padding(start = 20.dp, end = 20.dp, top = 18.dp)
                                .border(
                                    BorderStroke(1.dp, Color(0xFF67737F)),
                                    shape = RoundedCornerShape(5.dp)
                                )
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 14.dp),
                                horizontalArrangement = Arrangement.Absolute.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row{
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_wallet),
                                        contentDescription = "Wallet",
                                        modifier = Modifier.size(25.dp),
                                        contentScale = ContentScale.Crop
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Row {
                                        Text(
                                            text = "USD Account:",
                                            fontWeight = FontWeight.Normal,
                                            textAlign = TextAlign.Center,
                                            fontSize = 15.sp,
                                            color = Color.White,
                                            modifier = Modifier.padding(top = 5.dp)
                                        )
                                        Text(
                                            text = " 0.00 USD",
                                            fontWeight = FontWeight.Normal,
                                            textAlign = TextAlign.Center,
                                            fontSize = 15.sp,
                                            color = Color(0xFF5596BA),
                                            modifier = Modifier.padding(top = 5.dp)
                                        )
                                    }
                                }
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_down_new),
                                        contentDescription = "more",
                                        modifier = Modifier
                                            .size(10.dp)
                                            .padding(top = 5.dp)
                                    )
                            }
                        }
                        Text(
                            text = "Select your account",
                            fontWeight = FontWeight.Light,
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp,
                            color = Color(0xFF67737F),
                            modifier = Modifier
                                .padding(start = 30.dp, top = 5.dp)
                                .background(BackgroundTransfer)
                        )
                    }

                    Text(
                        text = "Choose amount to withdraw",
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color(0xFF67737F),
                        modifier = Modifier.padding(20.dp)
                    )
                    var selectedCurrency by remember { mutableStateOf(Currency.USD) }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .padding(horizontal = 20.dp)
                            .background(Color(0xFF67737F), shape = RoundedCornerShape(10.dp))
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 2.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clickable { selectedCurrency = Currency.USD }
                                    .background(
                                        color = if (selectedCurrency == Currency.USD) Color(0xFF5596BA) else Color.Transparent,
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .size(180.dp, 36.dp)
                                    .padding(2.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(start = 2.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = if (selectedCurrency == Currency.RIEL) R.drawable.ic_dollar_dark else R.drawable.ic_dollar),
                                        contentDescription = "Dollar",
                                        modifier = Modifier
                                            .size(20.dp)
                                            .padding(top = 2.dp)
                                    )
                                    Spacer(Modifier.width(5.dp))
                                    Text(
                                        "USD Dollar",
                                        color = if (selectedCurrency == Currency.USD) Color.White else Color.Black,
                                        textAlign = TextAlign.Center,
                                        fontSize = 14.sp,
                                    )
                                }
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .clickable { selectedCurrency = Currency.RIEL }
                                    .background(
                                        color = if (selectedCurrency == Currency.RIEL) Color(0xFF5596BA) else Color.Transparent,
                                        shape = RoundedCornerShape(10.dp)
                                    )
                                    .size(180.dp, 36.dp)
                                    .padding(2.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(start = 2.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_riel),
                                        contentDescription = "Riel",
                                        modifier = Modifier
                                            .size(20.dp)
                                            .padding(top = 2.dp)
                                    )
                                    Spacer(Modifier.width(5.dp))
                                    Text(
                                        "Khmer Riel",
                                        color = if (selectedCurrency == Currency.RIEL) Color.White else Color.Black,
                                        textAlign = TextAlign.Center,
                                        fontSize = 14.sp,
                                    )
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp)
                            .padding(start = 20.dp, end = 20.dp, top = 18.dp)
                            .border(
                                BorderStroke(1.dp, Color(0xFF67737F)),
                                shape = RoundedCornerShape(5.dp)
                            ),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        TextField(
                            value = "",
                            onValueChange = { /* Do something with the changed value */ },
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(color = Color.Black, textAlign = TextAlign.End),
                            placeholder = { Text(if (selectedCurrency == Currency.RIEL) "KHR" else "USD") },
                        )
                    }


                    Row(modifier = Modifier.padding(20.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_exclamation),
                            contentDescription = "exclamation",
                            modifier = Modifier
                                .size(20.dp)
                        )
                        Text(
                            text = "ATM only support 100$ note, Switch to Khemr " +
                                    "Riel to withdraw smaller note",
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Start,
                            fontSize = 14.sp,
                            color = Color(0xFF67737F),

                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(start = 20.dp, end = 20.dp)
                            .border(
                                BorderStroke(1.dp, Color(0xFF67737F)),
                                shape = RoundedCornerShape(5.dp)
                            )
                    ){
                        TextField(
                            value = "",
                            onValueChange = { /* Do something with the changed value */ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color(0xFF67737F),
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            textStyle = TextStyle(color = Color.White), // Change text color to white
                            placeholder = { Text("\uD83D\uDD8A    Remark (optional)") },
                        )
                    }
                }

            }
        }
}

enum class Currency {
    USD,
    RIEL
}
