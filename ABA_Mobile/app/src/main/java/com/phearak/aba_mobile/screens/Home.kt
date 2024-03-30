package com.phearak.aba_mobile.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerDefaults.scrimColor
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.phearak.aba_mobile.R
import com.phearak.aba_mobile.ui.theme.Primary
import com.phearak.aba_mobile.ui.theme.Red
import com.phearak.aba_mobile.ui.theme.Main
import com.phearak.aba_mobile.ui.theme.Sky
import kotlinx.coroutines.launch


data class DrawerItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val navScreen: String
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class,
    ExperimentalComposeUiApi::class
)

@Composable
fun Home(navigationController:NavController) {
    val navigationState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }


    val items = listOf(
        DrawerItem(
            title = "Government Services",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            navScreen = Screens.ABAServices.screen
        ),
        DrawerItem(
            title = "ABA Cashback",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            navScreen = Screens.ABAServices.screen
        ),
        DrawerItem(
            title = "Schedules",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            navScreen = Screens.ABAServices.screen
        ),
        DrawerItem(
            title = "Checkbook",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            navScreen = Screens.ABAServices.screen
        ),
        DrawerItem(
            title = "Exchange Rate",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            navScreen = Screens.ABAServices.screen
        ),
        DrawerItem(
            title = "Locator",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            navScreen = Screens.ABAServices.screen
        ),
        DrawerItem(
            title = "Invite Friend",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            navScreen = Screens.ABAServices.screen
        ),
    )

    Surface{
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Main)
                    ) {
                        Spacer(modifier = Modifier.height(26.dp))

                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clip(CircleShape)
                                        .border(3.dp, Color.White, CircleShape)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.t_transcard),
                                        contentDescription = "",
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }

                                Column(modifier = Modifier.padding(start = 15.dp)) {
                                    Text(text = "Hello, Phearak!", modifier = Modifier.padding(bottom = 7.dp), color = Color.White, fontSize = 20.sp, fontWeight = FontWeight(600))
                                    Text(text = "View Profile >", color = Color.White, fontWeight = FontWeight(300))
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(26.dp))

                        HorizontalDivider(thickness = 0.5.dp)

                        Spacer(modifier = Modifier.height(26.dp))

                        items.forEachIndexed { index, drawerItem ->
                            NavigationDrawerItem(
                                colors = NavigationDrawerItemDefaults.colors(unselectedContainerColor = Color.Transparent,selectedContainerColor = Color.Transparent),
                                label = {
                                    Text(text = drawerItem.title)
                                },
                                selected = index == selectedItemIndex,
                                onClick = {
                                    selectedItemIndex = index
                                    scope.launch {
                                        navigationState.close()
                                    }
                                    navigationController.navigate(drawerItem.navScreen)
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) {
                                            drawerItem.selectedIcon
                                        } else drawerItem.unselectedIcon,
                                        contentDescription = drawerItem.title
                                    )
                                },
                                modifier = Modifier
                                    .padding(NavigationDrawerItemDefaults.ItemPadding)
//                                    .background(if (index == selectedItemIndex) Color.Red else Color.Transparent)
                            )
                        }
                        DrawerFooter()
                    }
                }
            },
            drawerState = navigationState,
        ) {

            Scaffold(topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Primary,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                navigationState.open()
                            }
                        }) {
                            Icon(imageVector = Icons.Filled.Menu, tint = Color.White, contentDescription = "")
                        }
                    },
                    title = {
                        Row {
                            Text("ABA", color = Color.White, letterSpacing = 5.sp, fontWeight = FontWeight(600))
                            Text("'", color = Red, fontWeight = FontWeight(600))
                        }
                    },
                    actions = {
                        Row {
                            IconButton(onClick = { /* Do something */ }) {
                                Icon(Icons.Default.Notifications, tint = Color.White, contentDescription = "Search")
                            }
                            IconButton(onClick = { /* Do something */ }) {
                                Image(
                                    painter = painterResource(R.drawable.khqr),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.size(30.dp)
//                                    colorFilter = ColorFilter.tint(Color.White)
                                )
                            }
                        }
                    }
                )
            }) {
                Column {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .background(Main)
                        .padding(it)) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                IconWithText(Icons.Rounded.AccountBox, "Accounts", Brush.horizontalGradient(listOf(Primary, Color.White))){ navigationController.navigate(Screens.ABAAccounts.screen) }
                                IconWithText(Icons.Rounded.Email, "Cards", Brush.horizontalGradient(listOf(Primary, Color.White))){ navigationController.navigate(Screens.ABAServices.screen) }
                                IconWithText(Icons.Rounded.AccountBox, "Payment", Brush.horizontalGradient(listOf(Primary, Color.White))){ navigationController.navigate(Screens.ABAPayment.screen) }
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                IconWithText(Icons.Rounded.AccountBox, "New Account", Brush.horizontalGradient(listOf(Color.White, Primary))){ navigationController.navigate(Screens.AccountOpening.screen) }
                                IconWithText(Icons.Rounded.AccountBox, "E-Cash", Brush.horizontalGradient(listOf(Color.White, Primary))){ navigationController.navigate(Screens.ABATransfers.screen) }
                                IconWithText(Icons.Rounded.AccountBox, "Transfer", Brush.horizontalGradient(listOf(Color.White, Primary))){ navigationController.navigate(Screens.Transfer.screen) }
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                IconWithText(Icons.Rounded.AccountBox, "ABA Scan", Brush.horizontalGradient(listOf(Color.White, Primary))){ navigationController.navigate(Screens.ABAScan.screen) }
                                IconWithText(Icons.Rounded.AccountBox, "Loans", Brush.horizontalGradient(listOf(Color.White, Primary))){ navigationController.navigate("loan") }
                                IconWithText(Icons.Rounded.AccountBox, "Services", Brush.horizontalGradient(listOf(Color.White, Primary))){ navigationController.navigate(Screens.ABAServices.screen) }
                            }
                        }
                    }

                    QuickShortcut(
                        text1 = "Favorite Transfers",
                        text2 = "Access your favorites here for quick transfers",
                        backgroundColor = Red,
                        navigateToScreen = {
                            navigationController.navigate(Screens.FavoriteTransferScreen.screen)
                        }
                    )

                    QuickShortcut(
                        text1 = "Favorite Payments",
                        text2 = "Paying your bills with templates is faster",
                        backgroundColor = Sky,
                        navigateToScreen = {
                            navigationController.navigate(Screens.FavoriteScreen.screen)
                        }
                    )
                }

            }

        }
    }

}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun DrawerFooter(
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp)
    ) {
        LazyRow {
            item {
                Button(colors = ButtonDefaults.outlinedButtonColors(Color.White),
                    onClick = {  }) {
                    Text("Edit Home")
                }
            }
        }
    }
}

@Composable
fun QuickShortcut(
    text1: String,
    text2: String,
    backgroundColor: Color,
    navigateToScreen: () -> Unit // New parameter for navigation
) {
    Box(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .height(180.dp)
            .padding(start = 20.dp)
            .fillMaxHeight().clickable(onClick = {navigateToScreen()})
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .fillMaxHeight()
                .wrapContentSize(Alignment.CenterStart)
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            modifier = Modifier.padding(bottom = 10.dp),
                            text = text1,
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight(400)
                        )
                        Text(
                            text = text2,
                            fontSize = 14.sp,
                            color = Color.White,
                            fontWeight = FontWeight(300)
                        )
                    }
                    Box(contentAlignment = Alignment.BottomEnd) {
                        Image(
                            painter = painterResource(R.drawable.dollar),
                            contentDescription = "Your Image",
                            modifier = Modifier
                                .padding(start = 90.dp,top = 80.dp)
                                .alpha(0.2f)
                        )
                    }
                }
            }
        }


    }
}

@Composable
fun IconWithText(icon: ImageVector, label: String, gradient: Brush, onClick: () -> Unit) {
    val screen = LocalConfiguration.current.screenWidthDp.dp

    Box(
        modifier = Modifier
            .width(screen / 3)
            .aspectRatio(1f)
            .clickable(onClick = onClick) // Add click listener to the Box
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            drawRect(
                brush = gradient,
                size = size,
                style = Stroke(width = 0.5.dp.toPx())
            )
        }

        Column(
            modifier = Modifier
                .matchParentSize()
                .padding(0.5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                icon,
                tint = Color.White,
                contentDescription = "Notifications",
                modifier = Modifier
                    .width(screen / 3)
                    .aspectRatio(2.7f)
            )
            Text(
                text = label,
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}
