package com.phearak.aba_mobile.screens

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
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
import com.phearak.aba_mobile.ui.theme.Main
import com.phearak.aba_mobile.ui.theme.Primary
import com.phearak.aba_mobile.ui.theme.bg
import com.phearak.aba_mobile.ui.theme.font

@Preview(showSystemUi = true)
@Composable
fun Loan(){
    val navController = rememberNavController()
    LoansHeader(navController = navController)
}

@Composable
fun LoansScreen(navController: NavController) {
    LoansHeader(navController = navController)
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoansHeader(navController: NavController) {
    Surface() {
        Scaffold(
            containerColor = Main,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(Main),
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
                                text = " Loans",
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
        ) {
            LoansBody()
        }
    }
}
@Composable
fun LoansBody(){
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
                    .background(shape = CircleShape, color = Primary),
                contentAlignment = Alignment.Center,
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(160.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.l_loan),
                        contentDescription = "Loan",
                        modifier = Modifier.size(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Text(
                text = "Get Loan",
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(top=10.dp,bottom=60.dp)
            )
            Column(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(bg)
            ) {
                LoansBox(
                    R.drawable.l_dollartime,
                    linearGradient(
                        colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                    ),
                    "Instant Loan",
                    "Request Instant Loan to borrow cash of up to 90% of your Fixed Deposit amount and make repayment anytime with no penalty for early loan repayment.",
                    "GET NEW LOAN >")
                LoansBox(
                    R.drawable.l_calendar,
                    linearGradient(
                        colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                    ),
                    "Salary Loan",
                    "Request Salary Loan to borrow cash of up to 50% of your salary and make repayment monthly up to 12 months.",
                    "GET NEW LOAN >")
            }
        }
    }
}

@Composable
fun LoansBox(icon: Int, iconBackground: Brush, name:String, des:String, loan:String){
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
                .padding(top = 20.dp),
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
                        .size(40.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Column(

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)

        ) {
            Text(
                text = name,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal,
                color = White,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                text = des,
                textAlign = TextAlign.Start,
                fontSize = 11.sp,
                color = Color(0xFF88939D),
                modifier = Modifier.padding(start = 8.dp, top = 3.dp),
                lineHeight = 15.sp
            )
            Text(
                text = loan,
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp,
                color = font,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 20.dp)
                    .fillMaxWidth(0.95f),
                textAlign = TextAlign.End,
                lineHeight = 12.sp
            )
        }
    }
}
