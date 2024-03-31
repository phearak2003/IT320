package com.phearak.aba_mobile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
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
import com.phearak.aba_mobile.ui.theme.Red
import com.phearak.aba_mobile.ui.theme.Sky
import com.phearak.aba_mobile.ui.theme.bg

@Preview(showSystemUi = true)
@Composable
fun FavoritePreview() {
    val navController = rememberNavController()
    Favorite(navController = navController)
}

@Composable
fun FavoriteScreen(navController: NavController) {
    Favorite(navController = navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Favorite(navController: NavController) {
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
                                text = " Favorites",
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
            FavoriteBody()
        }
    }
}

@Composable
fun FavoriteBody() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(Modifier.fillMaxSize()) {
                Box {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.fillMaxWidth(0.7f)
                        ) {
                            Text(
                                text = "Favorites",
                                textAlign = TextAlign.Start,
                                color = White,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(bottom = 7.dp)
                            )
                            Text(
                                text = "Transfer to friends quickly or pay bills",
                                textAlign = TextAlign.Start,
                                color = Color(0xFFBEDADD),
                                fontSize = 12.sp,
                            )
                            Text(
                                text = "easily from your saved favorites.",
                                textAlign = TextAlign.Start,
                                color = Color(0xFFBEDADD),
                                fontSize = 12.sp,
                            )
                        }
                    }
                    Box(
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.favorite),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(110.dp)
                                .padding(start = 250.dp)
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
                            Column(
                                modifier = Modifier
                                    .padding(top = 25.dp)
                            ) {
                                FavoriteBox(
                                    R.drawable.cellcard_round,
                                    linearGradient(
                                        colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                                    ),
                                    "Mon Chanden",
                                    "012 350 513"
                                )
                                FavoriteBox(
                                    R.drawable.t_profile,
                                    linearGradient(
                                        colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                                    ),
                                    "Phanny Oudom",
                                    "088 996 7754 1"
                                )
                                FavoriteBox(
                                    R.drawable.t_transfer,
                                    linearGradient(
                                        colors = listOf(Color(0xFFffffff), Color(0xFFffffff))
                                    ),
                                    "Pho Phearak",
                                    "096 786 7788"
                                )
                            }
                        }
                        Box(
                            modifier = Modifier
                                .padding(start = 15.dp, top = 90.dp, end = 15.dp)
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
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .absoluteOffset(x = (5).dp, y = (5).dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .background(Color.Blue, shape = CircleShape)
                            ) {
                                IconButton(
                                    onClick = { },
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clip(CircleShape)
                                        .background(Red),
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Add,
                                        contentDescription = "",
                                        tint = Color.White
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun FavoriteBox(icon: Int, iconBackground: Brush, name:String, des:String){
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
                        .size(36.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp)
        ) {
            Row(Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = name,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Text(
                        text = des,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp,
                        color = Color(0xFF88939D),
                        modifier = Modifier.padding(start = 8.dp, top = 3.dp, bottom = 17.dp),
                        lineHeight = 20.sp
                    )
                }
                Column(modifier = Modifier.padding(end = 10.dp)) {
                    Icon(modifier = Modifier.rotate(90f).padding(bottom = 10.dp),
                        imageVector = Icons.Filled.MoreVert,
                        tint = Color.White,
                        contentDescription = "")
                    Image(
                        painter = painterResource(id = R.drawable.pin),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}