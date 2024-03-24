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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
fun ScanQrScreenPreview(){
    val navController = rememberNavController()
    ComposeScanQr(navController = navController)
}

@Composable
fun ScanQrScreen(navController: NavController) {
    ComposeScanQr(navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeScanQr(navController: NavController) {
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
                                text = " Scan",
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
                    containerColor = Secondary
                ) {
                    Column(
                        Modifier.fillMaxSize(),
                        verticalArrangement= Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        HorizontalDivider(
                            color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .width(250.dp)

                        )
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,

                        ) {
                            repeat(2) {
                                cardIcon(R.drawable.ic_abapay, "ABA pay")
                                cardIcon(R.drawable.ic_visa, "Visa pay")
                                cardIcon(R.drawable.ic_mastercard, "Mastercard pay")

                            }


                        }
                    }
                }
            }
        ) {
            composeOpenCamera()
        }
    }
}
@Composable
fun composeOpenCamera() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Scan QR",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "Align frame with QR code",
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .size(300.dp)
                    .border(BorderStroke(2.dp, Color.White))
            ) {

            }
            Row(modifier = Modifier.padding(all = 20.dp),){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                )  {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(shape = CircleShape, color = BackgroundBlue),

                        contentAlignment = Alignment.Center,
                    ) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.size(40.dp)
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.ic_flashlight),
                                contentDescription = "Flash",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    Text(
                        text = "Flash",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                )  {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(shape = CircleShape, color = BackgroundBlue),
                        contentAlignment = Alignment.Center,
                    ) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.size(36.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_qr_code),
                                contentDescription = "Flash",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    Text(
                        text = "Upload QR",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        color = Color.White,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun cardIcon(icon: Int, des: String) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = des,
        modifier = Modifier
            .size(45.dp)
            .padding(3.dp)
    )
}

