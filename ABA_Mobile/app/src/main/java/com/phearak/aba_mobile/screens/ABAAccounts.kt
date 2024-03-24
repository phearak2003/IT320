package com.phearak.aba_mobile.screens

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.phearak.aba_mobile.R
import com.phearak.aba_mobile.ui.theme.BackgroundBlue
import com.phearak.aba_mobile.ui.theme.Primary
import com.phearak.aba_mobile.ui.theme.Secondary

@Preview(showSystemUi = true)
@Composable
fun AccountsScreenPreview(){
    val navController = rememberNavController()
    ComposeAccounts(navController = navController)
}

@Composable
fun AccountsScreen(navController: NavController) {
    ComposeAccounts(navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeAccounts(navController: NavController) {
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
                                text = " Accounts",
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
                    containerColor = BackgroundTransfer,
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(end = 20.dp, bottom = 10.dp),
                ) {
                    Box(contentAlignment = Alignment.BottomEnd,modifier= Modifier.fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(shape = CircleShape, color = Color(0xFF9A3432)),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(
                                onClick = {},
                                modifier = Modifier.size(30.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_notes),
                                    contentDescription ="Add",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
            }
        ) {
            composeAccountsBody()
        }
    }
}
@Composable
fun composeAccountsBody() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, bottom = 30.dp),
            horizontalArrangement = Arrangement.Start,
            ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .size(150.dp)
                    .background(shape = CircleShape, color = Secondary)
                    .border(shape = CircleShape, width = 20.dp, color = Color(0xFF007989))
            ) {
                Text(
                    text = "All Accounts ",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 12.sp,
                )
                Text(
                    text = "Summary",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 12.sp,
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Total in USD", textAlign = TextAlign.Start,
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp)
                )
                Text(
                    text = "$ 0.00",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, bottom = 10.dp)
                )
                HorizontalDivider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    text = "Total in KHR", textAlign = TextAlign.Start,
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, top = 10.dp)
                )
                Text(
                    text = "៛ 0.00",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    fontSize = 18.sp,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp)
                )
            }
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(BackgroundTransfer)
        ) {
            Spacer(Modifier.height(5.dp))
            account(Color(0xFF007989),acName = "USD Account",acNumber = "098765432", acType = "Saving", acBalance = "$ 0.00",acCard = null)
            account(Color(0xFF007989),acName = "USD Account",acNumber = "098765432", acType = "Saving", acBalance = "$ 0.00",acCard = null)
            account(Color(0xFF007989),acName = "USD Account",acNumber = "098765432", acType = "Saving", acBalance = "$ 0.00",acCard = null)

        }
    }
}

@Composable
fun account(startColor : Color,acName : String,acNumber:String,acType:String,acBalance:String,acCard : String?){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(horizontal = 10.dp, vertical = 4.dp)
            .background(Color(0xFF67737F), shape = RoundedCornerShape(10.dp))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                ,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(15.dp)
                        .background(
                            startColor,
                            shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)
                        )
                        .padding(start=2.dp)
                ) {
                }
                Column(modifier=Modifier.padding(horizontal = 15.dp,vertical = 5.dp)) {
                    Text(text = acName,color = Color.White,
                        fontSize = 16.sp, fontWeight = FontWeight.Bold
                    )
                    Row() {
                        Text(acNumber,color = Color.White,modifier=Modifier.padding(end = 5.dp),fontSize = 12.sp)
                        Text("|",color = Color.White,modifier=Modifier.padding(end = 5.dp),fontSize = 12.sp)
                        Text(acType,color = Color.White,fontSize = 12.sp)
                    }
                }
            }
            Column(modifier = Modifier.fillMaxHeight().padding(end=15.dp,top=5.dp), verticalArrangement= Arrangement.SpaceBetween,horizontalAlignment = Alignment.End ){
                    Image(
                        painter = painterResource(id = R.drawable.ic_more),
                        contentDescription = "More",
                        modifier = Modifier.size(20.dp),
                        alignment = Alignment.TopEnd,
                    )
                Text(acBalance,color = Color.White,
                    modifier = Modifier.padding(bottom=5.dp),
                    fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}