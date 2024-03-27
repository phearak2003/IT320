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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
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

@Preview(showSystemUi = true)
@Composable
fun AccountOpening(){
    val navController = rememberNavController()
    AccountOpeningHeader(navController = navController)
}

@Composable
fun AccountOpeningScreen(navController: NavController) {
    AccountOpeningHeader(navController = navController)
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountOpeningHeader(navController: NavController) {
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
                                text = " Account Opening",
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
            AccountOpeningBody()
        }
    }
}
@Composable
fun AccountOpeningBody(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp)
            .verticalScroll(rememberScrollState()),
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
                        painter = painterResource(id = R.drawable.acc_newaccount),
                        contentDescription = "NewAccount",
                        modifier = Modifier.size(160.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Text(
                text = "New Account",
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
                    R.drawable.acc_people,
                    linearGradient(
                        colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                    ),
                    "Mobile Joint Account",
                    "Create Joint Account with family members or partners to manage savings and spendings jointly.",
                    "NEW JOINT ACCOUNT >")
                LoansBox(
                    R.drawable.acc_safer,
                    linearGradient(
                        colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                    ),
                    "Mobile Fixed Deposit",
                    "Open Fixed Deposit in KHR or USD and see your savings grow. You can choose flexibly the preferred maturity date and earn interest at your convenience.",
                    "MAKE NEW DEPOSIT >")
                LoansBox(
                    R.drawable.acc_child,
                    linearGradient(
                        colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                    ),
                    "Junior Account",
                    "Junior Account is a basic joint savings account designed for kids to help them understand the value of money and learn how to save. With this feature parents can always stay informed on their financial activities.",
                    "CREATE ACCOUNT >")
                LoansBox(
                    R.drawable.acc_gfav,
                    linearGradient(
                        colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                    ),
                    "Premium Account Number",
                    "Create a new ABA account with your favorite number that easy to remember. It can contain date of birth, vehicle plate or any other special number that important for you.",
                    "EXPLORE MORE >")
                LoansBox(
                    R.drawable.acc_elephant,
                    linearGradient(
                        colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                    ),
                    "Mobile Savings Account",
                    "Our most popular bank account that helps you reach saving goals with competitive interest rate and other great features.",
                    "OPEN NEW ACCOUNT >")
                LoansBox(
                    R.drawable.acc_riels,
                    linearGradient(
                        colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                    ),
                    "Mobile Flexi Account",
                    "With ABA Flexi Account in KHR you can deposit or/and withdraw funds any time and keep earning high interest on your ongoing balance.",
                    "OPEN NEW ACCOUNT >")
                LoansBox(
                    R.drawable.acc_graphdollar,
                    linearGradient(
                        colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                    ),
                    "Mobile Trading Account",
                    "Open Mobile Trading Account that can be used for funding your brokerage at our partnered companies. Find partner companies list at: Payments > Finance & Investment.",
                    "OPEN NEW ACCOUNT >")
            }
        }
    }
}
